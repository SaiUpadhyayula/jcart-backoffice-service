package com.leantechstacks.jcart.bo.entities

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "products")
class Product()
{
    @Id
    @SequenceGenerator(name = "product_generator", sequenceName = "product_sequence", initialValue = 100)
    @GeneratedValue(generator = "product_generator")
    var id: Long = 0

    @Column(nullable = false)
    var name: String = ""

    @Column
    var description: String? = null

    @Column
    var price: BigDecimal = BigDecimal.ZERO

    @ManyToOne
    @JoinColumn(name="vendor_id")
    var vendor:Vendor = Vendor()

    @ManyToOne
    @JoinColumn(name="cat_id")
    var category:Category = Category()

    constructor(id: Long, name: String, description: String, price: BigDecimal) :this() {
        this.id = id
        this.name = name
        this.description = description
        this.price = price
    }

    constructor(id: Long, name: String, description: String, price: BigDecimal,
                vendor: Vendor, category: Category)
            :this(id, name, description, price) {
        this.vendor = vendor
        this.category = category
    }
}
