package br.api.inmetrics.teste;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import br.api.inmetrics.core.BaseTest;

public class ApiInmetricsTest extends BaseTest {
	
	
	@Test
	public void deveCadastrarUsuarioComSucesso() {
		given()
		.contentType(APP_CONTENT_TYPE)
		.body("{\"email\": \"leandro.nares@gmail.com\",\"empregadoId\": 01,\"password\": \"leandro\"}")
		.auth().basic("inmetrics", "automacao")
	.when()
		.post("/cadastrar")
	.then()
		.statusCode(200)	
	;
	}
	
	@Test
	public void deveListarUsuarioCadastrado() {
		given()
		.auth().basic("inmetrics", "automacao")
	.when()
		.get("/list_all/01")
	.then()
		.statusCode(200)	
	;	
	}
	
	@Test
	public void deveListarUsuariosCadastrados() {
		given()
			.log().all()
			.auth().basic("inmetrics", "automacao")
		.when()
			.get("/list_all")
		.then()
		    .log().all()
			.statusCode(200)	
		;
	}
	
	@Test
	public void deveAlterarUsuarioCadastrado() {
		given()
		.contentType(APP_CONTENT_TYPE)
		.body("{\"email\": \"leandro.pereira@outlook.com\",\"empregadoId\": 01,\"password\": \"leandro\"}")
		.auth().basic("inmetrics", "automacao")
	.when()
		.post("/alterar/01")
	.then()
		.statusCode(200)	
	;
	}
}
