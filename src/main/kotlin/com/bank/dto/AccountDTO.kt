package com.bank.dto

data class AccountDTO(
    var id: Long?,
    var number: String,
    var balance: Double? = null,
    var bank: Int
)