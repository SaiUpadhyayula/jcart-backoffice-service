package com.leantechstacks.jcart.bo.web.controllers

import com.leantechstacks.jcart.bo.entities.Category
import com.leantechstacks.jcart.bo.repositories.CategoryRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CategoryControllerTest {

    @InjectMocks
    lateinit var categoryController:CategoryController

    @Mock
    lateinit var categoryRepository: CategoryRepository

    @Test
    fun should_return_categories() {
        `when`(categoryRepository.findAll())
            .thenReturn(listOf(
                    Category(1,"Cards","Cards", false))
            )
        val categories: List<Category> = categoryController.listCategories()
        assertNotNull(categories)
        assertEquals(1, categories.size)
    }
}
