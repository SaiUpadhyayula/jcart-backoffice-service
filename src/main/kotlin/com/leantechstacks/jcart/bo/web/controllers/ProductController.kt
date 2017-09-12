package com.leantechstacks.jcart.bo.web.controllers

import com.leantechstacks.jcart.bo.entities.Product
import com.leantechstacks.jcart.bo.repositories.ProductRepository
import com.leantechstacks.jcart.bo.web.model.ProductModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(private val productRepository: ProductRepository) {
    @GetMapping("/products")
    fun listProducts(): List<ProductModel> {
        return productRepository.findAll().map { p -> map(p) }
    }

    private fun map(product: Product): ProductModel {
        return ProductModel(
                product.id,
                product.name,
                product.description,
                product.price,
                product.vendor,
                product.category.id
        )
    }
}