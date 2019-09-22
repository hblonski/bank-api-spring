package com.bank.service

import com.bank.data.repository.ClientRepository
import com.bank.dto.ClientDTO
import com.bank.mapper.ClientDTOToClientMapper
import com.bank.mapper.ClientToClientDTOMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClientServiceImpl: ClientService {

    @Autowired
    private lateinit var clientRepository: ClientRepository

    private val clientDTOToClientMapper = ClientDTOToClientMapper()
    private val clientToClientDTOMapper = ClientToClientDTOMapper()

    override fun create(client: ClientDTO): ClientDTO {
        val saved = clientRepository.save(clientDTOToClientMapper.map(client))
        return clientToClientDTOMapper.map(saved)
    }
}