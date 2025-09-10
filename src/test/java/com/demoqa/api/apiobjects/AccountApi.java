package com.demoqa.api.apiobjects;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * <summary>
 * Classe responsável por encapsular as operações da API de contas de usuário.
 * </summary>
 */
public class AccountApi {
    private static final String BASE_URL = "https://demoqa.com";

    /**
     * <summary>
     * Cria um novo usuário na API.
     * </summary>
     * <param name="userName">Nome de usuário desejado.</param>
     * <param name="password">Senha do usuário.</param>
     * <return>Response da requisição HTTP.</return>
     */
    public Response createUser(String userName, String password) {
        // Prepare the JSON payload for user creation
        String payload = String.format("{\"userName\":\"%s\", \"password\":\"%s\"}", userName, password);

        // Send POST request to create user and return the response
        return RestAssured.given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/Account/v1/User")
                .then()
                .extract()
                .response();
    }

    /**
     * <summary>
     * Gera um token de autenticação para o usuário.
     * </summary>
     * <param name="userName">Nome do usuário.</param>
     * <param name="password">Senha do usuário.</param>
     * <return>Response da requisição HTTP.</return>
     */
    public Response generateToken(String userName, String password) {
        // Prepare the JSON payload for token generation
        String payload = String.format("{\"userName\":\"%s\", \"password\":\"%s\"}", userName, password);

        // Send POST request to generate token and return the response
        return RestAssured.given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/Account/v1/GenerateToken")
                .then()
                .extract()
                .response();
    }

    /**
     * <summary>
     * Verifica se o token informado é autorizado.
     * </summary>
     * <param name="token">Token JWT do usuário.</param>
     * <return>Response da requisição HTTP.</return>
     */
    public Response authorized(String token) {
        // Send POST request with Bearer token to check authorization
        return RestAssured.given()
                .baseUri(BASE_URL)
                .header("Authorization", "Bearer " + token)
                .when()
                .post("/Account/v1/Authorized")
                .then()
                .extract()
                .response();
    }

    /**
     * <summary>
     * Obtém os dados de um usuário pelo seu ID.
     * </summary>
     * <param name="userId">ID do usuário.</param>
     * <return>Response da requisição HTTP.</return>
     */
    public Response getUser(String userId) {
        // Send GET request to retrieve user information
        return RestAssured.given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .when()
                .get("/Account/v1/User/" + userId)
                .then()
                .extract()
                .response();
    }
}
