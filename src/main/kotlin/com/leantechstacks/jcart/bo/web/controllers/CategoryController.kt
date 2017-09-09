package com.leantechstacks.jcart.bo.web.controllers

import com.leantechstacks.jcart.bo.entities.Category
import com.leantechstacks.jcart.bo.repositories.CategoryRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CategoryController(private val categoryRepository: CategoryRepository) {
    @GetMapping("/categories")
    fun listCategories(): List<Category> {
        return categoryRepository.findAll()
    }
}
