package com.bank.controller

import com.bank.BaseTest
import com.bank.controller.exception.ControllerExceptionHandler
import com.bank.dto.ClientDTO
import com.bank.service.ClientService
import com.google.gson.Gson
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import kotlin.test.assertEquals

@AutoConfigureMockMvc
class ClientControllerTest : BaseTest() {

    @MockK
    private lateinit var clientService: ClientService

    @InjectMockKs
    private lateinit var clientController: ClientController

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Before
    fun init() {
        clientController = ClientController()
        MockKAnnotations.init(this)
        mockMvc = MockMvcBuilders.standaloneSetup(clientController)
                .setControllerAdvice(ControllerExceptionHandler())
                .build()
    }

    @Test
    fun should_returnClientData_when_clientCreated() {
        val saved = mockClientDTO()
        every {
            clientService.create(any())
        } returns saved
        val response =
                performRequest(mockMvc, createPostWithJsonContent(URL_CREATE, mockClientDTO()), status().isCreated)
        assertEquals(saved, Gson().fromJson(response.contentAsString, ClientDTO::class.java))
    }

    @Test
    fun should_returnErrorMessage_when_validationErrorsCreateClient() {
        val client = mockClientDTO()
        client.name = ""
        val response =
                performRequest(mockMvc, createPostWithJsonContent(URL_CREATE, client), status().isBadRequest)
        assertEquals("Name cannot be empty!", response.contentAsString)
    }

    companion object {
        private const val BASE_URL = "/client"
        private const val URL_CREATE = "$BASE_URL/create"
    }
}