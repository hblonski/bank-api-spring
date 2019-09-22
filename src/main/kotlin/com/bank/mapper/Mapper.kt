package com.bank.mapper

interface Mapper<F, T> {
    fun map(from: F) : T
}