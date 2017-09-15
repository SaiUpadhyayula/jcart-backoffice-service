package com.leantechstacks.jcart.bo.repositories

import com.leantechstacks.jcart.bo.entities.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long> {
    fun findByCategoryId(categoryId: Long): List<Product>
}
