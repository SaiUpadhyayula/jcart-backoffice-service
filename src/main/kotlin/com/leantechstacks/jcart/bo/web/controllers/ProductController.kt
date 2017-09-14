package com.leantechstacks.jcart.bo.web.controllers

import com.leantechstacks.jcart.bo.entities.Product
import com.leantechstacks.jcart.bo.exceptions.InvalidProductException
import com.leantechstacks.jcart.bo.repositories.CategoryRepository
import com.leantechstacks.jcart.bo.repositories.ProductRepository
import com.leantechstacks.jcart.bo.repositories.VendorRepository
import com.leantechstacks.jcart.bo.web.model.ProductModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
class ProductController(private val productRepository: ProductRepository,
                        private val vendorRepository: VendorRepository,
                        private val categoryRepository: CategoryRepository) {

    @GetMapping("/products")
    fun listProducts(): List<ProductModel>
    {
        return productRepository.findAll().map { p -> map(p) }
    }

    private fun map(product: Product): ProductModel
    {
        return ProductModel(
                product.id,
                product.name,
                product.description,
                product.price,
                product.vendor,
                product.category.id
        )
    }

    @PostMapping("/products")
    fun createProduct(@RequestBody product: ProductModel): ResponseEntity<ProductModel> {
        validateProduct(product)
        val productEntity = productRepository.save(product.toEntity())
        return ResponseEntity(ProductModel(productEntity), HttpStatus.CREATED)
    }

    @PutMapping("/products/{productId}")
    fun updateProduct(@RequestBody product: ProductModel, @PathVariable productId: Long): ResponseEntity<ProductModel> {
        if(productRepository.findOne(productId) == null) {
            throw InvalidProductException()
        }
        product.id = productId
        validateProduct(product)
        val productEntity = productRepository.save(product.toEntity())
        return ResponseEntity(ProductModel(productEntity), HttpStatus.OK)
    }

    private fun validateProduct(product: ProductModel)
    {
        if(product.name.trim().isEmpty() ||
           product.price < BigDecimal.ZERO ||
           vendorRepository.findOne(product.vendor.id) == null ||
           categoryRepository.findOne(product.categoryId) == null)
        {
            throw InvalidProductException()
        }
    }
}
