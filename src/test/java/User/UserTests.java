package User;

import Entities.User;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //setar a ordem dos testes
public class UserTests {

    private static User user;
    public static Faker faker;
    public static RequestSpecification request;

    @BeforeAll //executada antes de tudo
    public static void setup(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        faker = new Faker();
        user = new User(faker.name().username(),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().safeEmailAddress(),
                faker.internet().password(8,10),
                faker.phoneNumber().toString());
    }

    @BeforeEach
    void setRequest(){
        request = given()
                .header("api-key","special-key")
                .contentType(ContentType.JSON);
    }

    //primeiro teste - POST
    @Test
    public void CreateNewUser_WithValidData_ReturnOk(){ //sempre colocar bem especificado o que o teste irá fazer e retorna
        request.body(user)
                .when()
                .post("/user")
                .then()
                .assertThat().statusCode(200).and()
                .body("code", equalTo(200))
                .body("type", equalTo("unknown"))
                .body("message", isA(String.class))
                .body("size()", equalTo(3));
    }

    //Primeiro teste - GET
    @Test
    public void GetLogin_validUser_ReturnOk(){
        request
                .param("username", user.getUsername())
                .param("password", user.getPassword())
                .when()
                .get("/user/login")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .time(lessThan(2000L))
                .and()
                .body(matchesJsonSchemaInClasspath("loginResponseSchema.json")); //passando o caminho da schema, setado em um arquivo de configuração json
    }
}
