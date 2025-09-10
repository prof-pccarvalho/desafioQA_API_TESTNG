package com.demoqa.api.apiobjects;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * <summary>
 * Classe responsável por encapsular as operações da API de Livraria.
 * </summary>
 */
public class BookStoreApi {
    private static final String BASE_URL = "https://demoqa.com";

    /**
     * <summary>
     * Lista todos os livros disponíveis na livraria.
     * </summary>
     * <return>Response da requisição HTTP.</return>
     */
    public Response listBooks() {
        // Send GET request to fetch the list of books
        return RestAssured.given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .when()
                .get("/BookStore/v1/Books")
                .then()
                .extract()
                .response();
    }

    /**
     * <summary>
     * Reserva livros para um usuário específico.
     * </summary>
     * <param name="userId">ID do usuário.</param>
     * <param name="token">Token de autenticação do usuário.</param>
     * <param name="isbns">Array de ISBNs dos livros a reservar.</param>
     * <return>Response da requisição HTTP.</return>
     */
    public Response reserveBooks(String userId, String token, String[] isbns) {
        // Build JSON payload for reserving books
        StringBuilder sb = new StringBuilder();
        sb.append("{\"userId\":\"").append(userId).append("\", \"collectionOfIsbns\":[");
        for (int i = 0; i < isbns.length; i++) {
            sb.append("{\"isbn\":\"").append(isbns[i]).append("\"}");
            if (i < isbns.length - 1) sb.append(",");
        }
        sb.append("]}");

        // Send POST request to reserve books
        return RestAssured.given()
                .baseUri(BASE_URL)
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(sb.toString())
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .extract()
                .response();
    }
}
