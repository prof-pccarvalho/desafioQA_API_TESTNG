package com.demoqa.api.tests;

import com.demoqa.api.apiobjects.AccountApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * <summary>
 * Classe de testes para operações de usuário.
 * </summary>
 */
public class AccountApiUnitTest {

    /**
     * <summary>
     * Testa se a criação de usuário retorna uma resposta não nula.
     * </summary>
     */
    @Test
    public void testCreateUserReturnsResponse() {
        AccountApi api = new AccountApi();
        // Usar dados fictícios para teste; em testes unitários reais, simular a chamada HTTP
        Response response = api.createUser("testUser", "Senha@123");
        Assert.assertNotNull(response, "A resposta não deve ser nula");
    }

    /**
     * <summary>
     * Testa a geração de token para usuário válido.
     * </summary>
     */
    @Test
    public void testGenerateTokenReturnsResponse() {
        AccountApi api = new AccountApi();
        Response response = api.generateToken("testUser", "Senha@123");
        Assert.assertNotNull(response, "A resposta não deve ser nula");
    }

    /**
     * <summary>
     * Testa se a autorização retorna uma resposta não nula.
     * </summary>
     */
    @Test
    public void testAuthorizedReturnsResponse() {
        AccountApi api = new AccountApi();
        Response response = api.authorized("dummyToken");
        Assert.assertNotNull(response, "A resposta não deve ser nula");
    }

    /**
     * <summary>
     * Testa se a chamada de usuário retorna uma resposta não nula.
     * </summary>
     */
    @Test
    public void testGetUserReturnsResponse() {
        AccountApi api = new AccountApi();
        Response response = api.getUser("dummyUserId");
        Assert.assertNotNull(response, "A resposta não deve ser nula");
    }
}
