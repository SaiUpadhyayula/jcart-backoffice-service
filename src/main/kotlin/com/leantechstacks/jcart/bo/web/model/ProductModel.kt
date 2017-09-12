package com.leantechstacks.jcart.bo.web.model

import com.leantechstacks.jcart.bo.entities.Vendor
import java.math.BigDecimal

data class ProductModel (
    var id: Long = 0,
    var name: String = "",
    var description: String? = null,
    var price: BigDecimal = BigDecimal.ZERO,
    var vendor: Vendor? = null,
    var categoryId: Long = 0
)
