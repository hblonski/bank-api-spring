package com.bank.service

import com.bank.BaseTest
import com.bank.data.entity.Client
import com.bank.data.repository.ClientRepository
import com.bank.mapper.ClientDTOToClientMapper
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class ClientServiceImplTest : BaseTest() {

    @MockK
    private lateinit var clientRepository: ClientRepository

    @InjectMockKs
    private lateinit var clientServiceImpl: ClientServiceImpl

    @Before
    fun init() {
        clientServiceImpl = ClientServiceImpl()
        MockKAnnotations.init(this)
    }

    @Test
    fun should_returnClientInfo_when_clientCreated() {
        val mockClientDTO = mockClientDTO()
        every {
            clientRepository.save(any<Client>())
        } returns ClientDTOToClientMapper().map(mockClientDTO)

        val result = clientServiceImpl.create(mockClientDTO)
        assertEquals(result, mockClientDTO)
    }
}