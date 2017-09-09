package com.leantechstacks.jcart.bo.web.controllers

import com.leantechstacks.jcart.bo.entities.Category
import com.leantechstacks.jcart.bo.repositories.CategoryRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@RunWith(SpringRunner::class)
@WebMvcTest(controllers = arrayOf(CategoryController::class))
class CategoryControllerIT {

    @MockBean
    lateinit var categoryRepository:CategoryRepository

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun testHelloController() {
       Mockito.`when`(categoryRepository.findAll())
               .thenReturn(arrayListOf(Category(1, "Cards","Cards", false)))
       mockMvc.perform(MockMvcRequestBuilders.get("/categories"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(1))
    }
}
