package com.demoqa.api.apiobjects;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * <summary>
 * Handles user account-related API operations such as user creation, token generation, authorization, and user retrieval.
 * </summary>
 */
public class AccountApi {
    private static final String BASE_URL = "https://demoqa.com";

    /**
     * <summary>
     * Creates a new user in the API.
     * </summary>
     * <param name="userName">The desired username.</param>
     * <param name="password">The user's password.</param>
     * <return>HTTP Response from the API.</return>
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
     * Generates an authentication token for a user.
     * </summary>
     * <param name="userName">The username.</param>
     * <param name="password">The user's password.</param>
     * <return>HTTP Response containing the token.</return>
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
     * Checks if the provided token is authorized.
     * </summary>
     * <param name="token">JWT token to be checked.</param>
     * <return>HTTP Response indicating authorization status.</return>
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
     * Retrieves user information by user ID.
     * </summary>
     * <param name="userId">The user's ID.</param>
     * <return>HTTP Response containing user details.</return>
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
