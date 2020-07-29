package br.api.inmetrics.teste;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import br.api.inmetrics.core.BaseTest;

public class ApiInmetricsTest extends BaseTest {
	
	
	@Test
	public void deveCadastrarUsuarioComSucesso() {
		given()
		.contentType(APP_CONTENT_TYPE)
		.body("{\"admissao\":\"25/07/2000\",\"cargo\": \"Analista\",\"comissao\": \"1.000,00\",\"cpf\": \"075.216.116-40\",\"departamentoId\": 1,\"nome\": \"Leandro Pereira\",\"salario\": \"1.000,00\",\"sexo\":\"m\",\"tipoContratacao\":\"clt\"}")
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
		.get("/list/181")
	.then()
		.statusCode(202)	
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
		.body("{\"admissao\":\"25/07/2000\",\"cargo\": \"Analista de Testes automatizados\",\"comissao\": \"1.000,00\",\"cpf\": \"075.216.116-40\",\"departamentoId\": 1,\"nome\": \"Leandro Pereira\",\"salario\": \"1.000,00\",\"sexo\":\"m\",\"tipoContratacao\":\"clt\"}")
		.auth().basic("inmetrics", "automacao")
	.when()
		.put("/alterar/181")
	.then()
		.statusCode(202)	
	;
	}
}
