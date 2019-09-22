package com.bank.service

import com.bank.dto.ClientDTO

interface ClientService {
    fun create(client: ClientDTO): ClientDTO
}