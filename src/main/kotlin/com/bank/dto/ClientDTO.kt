package com.bank.dto

import javax.validation.constraints.NotBlank

data class ClientDTO(
    var id: Long? = null,

    @field:NotBlank(message = "Name cannot be empty!")
    var name: String,

    @field:NotBlank(message = "Document number cannot be empty!")
    var documentNumber: String,

    @field:NotBlank(message = "Address cannot be empty!")
    var address: String,

    @field:NotBlank(message = "City cannot be empty!")
    var city: String,

    @field:NotBlank(message = "State cannot be empty!")
    var state: String,

    @field:NotBlank(message = "Country cannot be empty!")
    var country: String,

    @field:NotBlank(message = "Profession cannot be empty!")
    var profession: String,

    @field:NotBlank(message = "Phone cannot be empty!")
    var phone: String
)