package com.leantechstacks.jcart.bo.web.controllers

import com.leantechstacks.jcart.bo.entities.Category
import com.leantechstacks.jcart.bo.repositories.CategoryRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@WebMvcTest(controllers = arrayOf(CategoryController::class))
class CategoryControllerTest {

    @MockBean
    lateinit var categoryRepository:CategoryRepository

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `should return category list when there are categories`() {
        `when`(categoryRepository.findAll())
                .thenReturn(arrayListOf(
                        Category(1, "Cards","Cards", false))
                )
        mockMvc.perform(get("/categories"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.size()").value(1))
    }
}
