package com.demoqa.api.tests;

import com.demoqa.api.apiobjects.AccountApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * <summary>
 * Unit tests for AccountApi methods.
 * </summary>
 */
public class AccountApiUnitTest {

    /**
     * <summary>
     * Tests if createUser returns a non-null Response.
     * </summary>
     */
    @Test
    public void testCreateUserReturnsResponse() {
        AccountApi api = new AccountApi();
        // Use dummy data for test; in real unit tests, mock the HTTP call
        Response response = api.createUser("testUser", "Senha@123");
        Assert.assertNotNull(response, "Response should not be null");
    }

    /**
     * <summary>
     * Tests if generateToken returns a non-null Response.
     * </summary>
     */
    @Test
    public void testGenerateTokenReturnsResponse() {
        AccountApi api = new AccountApi();
        Response response = api.generateToken("testUser", "Senha@123");
        Assert.assertNotNull(response, "Response should not be null");
    }

    /**
     * <summary>
     * Tests if authorized returns a non-null Response.
     * </summary>
     */
    @Test
    public void testAuthorizedReturnsResponse() {
        AccountApi api = new AccountApi();
        Response response = api.authorized("dummyToken");
        Assert.assertNotNull(response, "Response should not be null");
    }

    /**
     * <summary>
     * Tests if getUser returns a non-null Response.
     * </summary>
     */
    @Test
    public void testGetUserReturnsResponse() {
        AccountApi api = new AccountApi();
        Response response = api.getUser("dummyUserId");
        Assert.assertNotNull(response, "Response should not be null");
    }
}
