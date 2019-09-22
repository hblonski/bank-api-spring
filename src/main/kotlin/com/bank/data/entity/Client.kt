package com.bank.data.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity
@Table(name = "CLIENT", uniqueConstraints = [UniqueConstraint(columnNames = ["document_number"])])
data class Client(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long? = null,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val documentNumber: String,

    @Column(nullable = false)
    val address: String,

    @Column(nullable = false)
    val city: String,

    @Column(nullable = false)
    val state: String,

    @Column(nullable = false)
    val country: String,

    @Column(nullable = false)
    val profession: String,

    @Column(nullable = false)
    val phone: String,

    @OneToOne
    val account: Account? = null
)