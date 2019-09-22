package com.bank.data.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity
@Table(name = "ACCOUNT", uniqueConstraints = [UniqueConstraint(columnNames = ["number"])])
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long? = null,

    @Column(nullable = false)
    val number: String,

    @Column
    val balance: Double? = null,

    @Column(nullable = false)
    val bank: Int
)