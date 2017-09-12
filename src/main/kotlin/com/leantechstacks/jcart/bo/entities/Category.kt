package com.leantechstacks.jcart.bo.entities

import javax.persistence.*


@Entity
@Table(name = "categories")
class Category()
{
    @Id
    @SequenceGenerator(name = "cat_generator", sequenceName = "cat_sequence", initialValue = 100)
    @GeneratedValue(generator = "cat_generator")
    var id: Long = 0

    @Column(nullable = false)
    var name: String = ""

    @Column
    var description: String? = null

    @Column
    var disabled: Boolean = false

    constructor(id: Long) :this() {
        this.id = id
    }

    constructor(id: Long, name: String, description: String, disabled: Boolean) :this() {
        this.id = id
        this.name = name
        this.description = description
        this.disabled = disabled
    }
}
