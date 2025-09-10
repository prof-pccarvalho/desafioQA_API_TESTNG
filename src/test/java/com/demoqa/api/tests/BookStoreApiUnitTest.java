package com.demoqa.api.tests;

import com.demoqa.api.apiobjects.BookStoreApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * <summary>
 * Unit tests for BookStoreApi methods.
 * </summary>
 */
public class BookStoreApiUnitTest {

    /**
     * <summary>
     * Tests if listBooks returns a non-null Response.
     * </summary>
     */
    @Test
    public void testListBooksReturnsResponse() {
        BookStoreApi api = new BookStoreApi();
        Response response = api.listBooks();
        Assert.assertNotNull(response, "Response should not be null");
    }

    /**
     * <summary>
     * Tests if reserveBooks returns a non-null Response.
     * </summary>
     */
    @Test
    public void testReserveBooksReturnsResponse() {
        BookStoreApi api = new BookStoreApi();
        String[] isbns = {"1234567890", "0987654321"};
        Response response = api.reserveBooks("dummyUserId", "dummyToken", isbns);
        Assert.assertNotNull(response, "Response should not be null");
    }
}
