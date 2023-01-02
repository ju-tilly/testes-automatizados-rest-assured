# Desenvolvendo testes automatizados com Rest Assured

Testes Automatizados com Rest Assured - Desenvolvidos junto com o Bootcamp QA GFT para Mulheres.

No curso de: Testes de API: Dos Manuais aos Automatizados da Dio_me.

Acompanhado pela professora Carolina Louzada.

## ***Ferramentas e extensões utilizadas***:

- Intellij

- Java version 17

- Site Maven repository: https://mvnrepository.com/ para baixar as dependências pom.xml:

  - JUnit - jupiter - version: 5.9.1 :
    - API
    - Engine
    - Platform Runner version: 1.9.1

  - Rest-Assured - versão 5.3.0 :
    - Json Schema Validator
    - Json Path

  - Java Faker - version 1.0.2
  
- Maven versão 4.0.0

- GitHub

- Endpoints:
  - getAllBookingsById_returnOk - Obtém todas as reservas por id e retorna status code 200 OK;
  - getAllBookingsByUserFirstName_BookingExists_returnOk - Obtém reserva pelo primeiro nome do usuário (passando como parâmetro firstname=Juce), e retorna status code 200 OK;
  - CreateBooking_WithValidData_returnOk - Cria reserva com dados válidos e retorna status code 200 OK;