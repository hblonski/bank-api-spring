package com.bank.mapper

import com.bank.data.entity.Client
import com.bank.dto.ClientDTO

class ClientToClientDTOMapper : Mapper<Client, ClientDTO> {
    override fun map(from: Client): ClientDTO {
        return ClientDTO(
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