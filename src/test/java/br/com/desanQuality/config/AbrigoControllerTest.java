//package br.com.desanQuality.config;
//
//import io.restassured.http.ContentType;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class AbrigoControllerTest {
//
//    private static final String BASE_URL = "http://localhost:8080";
//
//    @BeforeAll
//    public void setup() {
//        baseURI = BASE_URL;
//    }
//
//    @Test
//    @DisplayName("Deve listar todos os abrigos")
//    public void testListarAbrigos() {
//        given()
//                .contentType(ContentType.JSON)
//                .when()
//                .get("/abrigos")
//                .then()
//                .statusCode(200)
//                .body("$", not(empty()));
//    }
//
//    @Test
//    @DisplayName("Deve cadastrar um novo abrigo com sucesso")
//    public void testCadastrarAbrigo() {
//        String abrigoJson = """
//            {
//                "nome": "Abrigo Teste",
//                "telefone": "11999999999",
//                "email": "abrigo@teste.com"
//            }
//            """;
//
//        given()
//                .contentType(ContentType.JSON)
//                .body(abrigoJson)
//                .when()
//                .post("/abrigos")
//                .then()
//                .statusCode(200);
//    }
//
//    @Test
//    @DisplayName("Deve listar pets de um abrigo específico")
//    public void testListarPetsDoAbrigo() {
//        String idOuNome = "abrigo-teste";
//
//        given()
//                .contentType(ContentType.JSON)
//                .pathParam("idOuNome", idOuNome)
//                .when()
//                .get("/abrigos/{idOuNome}/pets")
//                .then()
//                .statusCode(200)
//                .body("$", not(empty()));
//    }
//
//    @Test
//    @DisplayName("Deve cadastrar um pet em um abrigo específico")
//    public void testCadastrarPet() {
//        String idOuNome = "abrigo-teste";
//        String petJson = """
//            {
//                "tipo": "CACHORRO",
//                "nome": "Rex",
//                "raca": "Vira-lata",
//                "idade": 2,
//                "peso": 8.5,
//                "cor": "Caramelo"
//            }
//            """;
//
//        given()
//                .contentType(ContentType.JSON)
//                .pathParam("idOuNome", idOuNome)
//                .body(petJson)
//                .when()
//                .post("/abrigos/{idOuNome}/pets")
//                .then()
//                .statusCode(200);
//    }
//
//    @Test
//    @DisplayName("Deve retornar erro ao cadastrar abrigo com dados inválidos")
//    public void testCadastrarAbrigoComDadosInvalidos() {
//        String abrigoInvalidoJson = """
//            {
//                "nome": "",
//                "telefone": "123",
//                "email": "email-invalido"
//            }
//            """;
//
//        given()
//                .contentType(ContentType.JSON)
//                .body(abrigoInvalidoJson)
//                .when()
//                .post("/abrigos")
//                .then()
//                .statusCode(400);
//    }
//
//    @Test
//    @DisplayName("Deve retornar 404 ao buscar pets de abrigo inexistente")
//    public void testListarPetsAbrigoInexistente() {
//        String idOuNome = "abrigo-inexistente";
//
//        given()
//                .contentType(ContentType.JSON)
//                .pathParam("idOuNome", idOuNome)
//                .when()
//                .get("/abrigos/{idOuNome}/pets")
//                .then()
//                .statusCode(404);
//    }
//}
//
//
