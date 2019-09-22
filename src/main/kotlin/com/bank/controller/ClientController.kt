package com.bank.controller

import com.bank.dto.ClientDTO
import com.bank.service.ClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("client")
class ClientController {

    @Autowired
    private lateinit var clientService: ClientService

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody client: ClientDTO): ClientDTO {
        return clientService.create(client)
    }
}