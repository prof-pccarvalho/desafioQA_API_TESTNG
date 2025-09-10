package com.demoqa.api.apiobjects;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * <summary>
 * Handles bookstore-related API operations such as listing books and reserving books for a user.
 * </summary>
 */
public class BookStoreApi {
    private static final String BASE_URL = "https://demoqa.com";

    /**
     * <summary>
     * Retrieves the list of all available books.
     * </summary>
     * <return>HTTP Response containing the list of books.</return>
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
     * Reserves books for a specific user.
     * </summary>
     * <param name="userId">The user's ID.</param>
     * <param name="token">JWT token for authentication.</param>
     * <param name="isbns">Array of ISBNs to reserve.</param>
     * <return>HTTP Response after attempting reservation.</return>
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
