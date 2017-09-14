package com.leantechstacks.jcart.bo.web.model

import com.leantechstacks.jcart.bo.entities.Category
import com.leantechstacks.jcart.bo.entities.Product
import com.leantechstacks.jcart.bo.entities.Vendor
import java.math.BigDecimal

data class ProductModel (
        var id: Long = 0,
        var name: String = "",
        var description: String? = null,
        var price: BigDecimal = BigDecimal.ZERO,
        var vendor: Vendor = Vendor(),
        var categoryId: Long = 0
) {
    constructor(productEntity: Product) : this(productEntity.id,
            productEntity.name,
            productEntity.description,
            productEntity.price,
            productEntity.vendor,
            productEntity.category.id)

    fun toEntity(): Product {
        return Product(id,
                name,
                description.orEmpty(),
                price,
                vendor,
                Category(categoryId))
    }
}
