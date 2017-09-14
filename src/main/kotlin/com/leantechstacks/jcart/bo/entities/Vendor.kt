package com.leantechstacks.jcart.bo.entities

import javax.persistence.*

@Entity
@Table(name = "vendors")
class Vendor()
{
    @Id
    @SequenceGenerator(name = "vendor_generator", sequenceName = "vendor_sequence", initialValue = 100)
    @GeneratedValue(generator = "vendor_generator")
    var id: Long = 0

    @Column(nullable = false)
    var name: String = ""

    constructor(id: Long) :this() {
        this.id = id
    }

    constructor(id: Long, name: String) :this() {
        this.id = id
        this.name = name
    }
}
