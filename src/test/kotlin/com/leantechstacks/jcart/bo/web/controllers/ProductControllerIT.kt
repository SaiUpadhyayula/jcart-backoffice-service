package com.leantechstacks.jcart.bo.web.controllers

import com.leantechstacks.jcart.bo.entities.Category
import com.leantechstacks.jcart.bo.entities.Product
import com.leantechstacks.jcart.bo.entities.Vendor
import com.leantechstacks.jcart.bo.repositories.ProductRepository
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
import java.math.BigDecimal

@RunWith(SpringRunner::class)
@WebMvcTest(controllers = arrayOf(ProductController::class))
class ProductControllerIT {

    @MockBean
    lateinit var productRepository: ProductRepository

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun should_return_product_list_when_there_are_products() {
       `when`(productRepository.findAll())
               .thenReturn(arrayListOf(
                  Product(1, "HBD Card", "Happy Birthday Card", BigDecimal.TEN,
                       vendor = Vendor(1,"Vendor1"),
                       category = Category(id=1))
               ))
       mockMvc.perform(get("/products"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("HBD Card"))
                .andExpect(jsonPath("$[0].description").value("Happy Birthday Card"))
                .andExpect(jsonPath("$[0].price").value("10"))
                .andExpect(jsonPath("$[0].vendor.id").value(1))
                .andExpect(jsonPath("$[0].vendor.name").value("Vendor1"))
                .andExpect(jsonPath("$[0].categoryId").value(1))
    }
}
