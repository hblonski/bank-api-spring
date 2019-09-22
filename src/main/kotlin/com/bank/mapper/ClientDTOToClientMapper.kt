package com.bank.mapper

import com.bank.data.entity.Client
import com.bank.dto.ClientDTO

class ClientDTOToClientMapper : Mapper<ClientDTO, Client> {
    override fun map(from: ClientDTO): Client {
        return Client(
            id = from.id,
            name = from.name,
            documentNumber = from.documentNumber,
            address = from.address,
            city = from.city,
            state = from.state,
            country = from.country,
            profession = from.profession,
            phone = from.phone
        )
    }
}