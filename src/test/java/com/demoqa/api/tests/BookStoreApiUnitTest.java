package com.demoqa.api.tests;

import com.demoqa.api.apiobjects.BookStoreApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * <summary>
 * Classe de testes para operações de livraria.
 * </summary>
 */
public class BookStoreApiUnitTest {

    /**
     * <summary>
     * Testa a listagem de livros disponíveis.
     * </summary>
     */
    @Test
    public void testListBooksReturnsResponse() {
        BookStoreApi api = new BookStoreApi();
        Response response = api.listBooks();
        Assert.assertNotNull(response, "A resposta não deve ser nula");
    }

    /**
     * <summary>
     * Testa se a listagem retorna uma resposta não nula.
     * </summary>
     */
    @Test
    public void testReserveBooksReturnsResponse() {
        BookStoreApi api = new BookStoreApi();
        String[] isbns = {"1234567890", "0987654321"};
        Response response = api.reserveBooks("dummyUserId", "dummyToken", isbns);
        Assert.assertNotNull(response, "A resposta não deve ser nula");
    }
}
