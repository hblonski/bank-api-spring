package com.bank

import com.bank.dto.ClientDTO
import com.google.gson.Gson
import org.springframework.http.MediaType
import org.springframework.mock.web.MockHttpServletResponse
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultMatcher
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

open class BaseTest {

    fun mockClientDTO() = ClientDTO(
        1,
        "John Doe",
        "123",
        "Fake Street",
        "Belo Horizonte",
        "Minas Gerais",
        "Brazil",
        "Professor",
        "123456789"
    )

    fun performRequest(
        mockMvc: MockMvc,
        request: MockHttpServletRequestBuilder,
        expectedStatus: ResultMatcher
    ): MockHttpServletResponse {
        return mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andReturn()
                .response
    }

    fun createPostWithJsonContent(url: String, content: Any): MockHttpServletRequestBuilder {
        return MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(Gson().toJson(content))
    }
}