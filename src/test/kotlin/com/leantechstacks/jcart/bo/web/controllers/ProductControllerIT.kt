package com.leantechstacks.jcart.bo.web.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.leantechstacks.jcart.bo.entities.Category
import com.leantechstacks.jcart.bo.entities.Product
import com.leantechstacks.jcart.bo.entities.Vendor
import com.leantechstacks.jcart.bo.repositories.ProductRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.math.BigDecimal

@RunWith(SpringRunner::class)
@WebMvcTest(controllers = arrayOf(ProductController::class))
class ProductControllerTest {

    @MockBean
    lateinit var productRepository: ProductRepository

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `should return product list when there are products`() {
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

    @Test
    fun `should throw error when new product doesn't have product name`() {
        val product = Product(0,"","New Product1", BigDecimal.TEN,
                Vendor(1, "Vendor1"), Category(2))
        val productJSON = ObjectMapper().writeValueAsString(product)
        `when`(productRepository.save(product)).thenReturn(product)

        mockMvc.perform(
            post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productJSON)
            )
            .andExpect(status().isBadRequest)
    }


    @Test
    fun `should throw error when new product price is less than zero`() {
        val product = Product(0,"NewProduct","New Product1", -BigDecimal.TEN,
                Vendor(1, "Vendor1"), Category(2))
        val productJSON = ObjectMapper().writeValueAsString(product)
        `when`(productRepository.save(product)).thenReturn(product)

        mockMvc.perform(
            post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productJSON)
            )
            .andExpect(status().isBadRequest)
    }

    @Test
    fun `should throw error when new product vendor id is not set`() {
        val product = Product(0,"NewProduct","New Product1", BigDecimal.TEN,
                Vendor(0, "Vendor1"), Category(2))
        val productJSON = ObjectMapper().writeValueAsString(product)
        `when`(productRepository.save(product)).thenReturn(product)

        mockMvc.perform(
            post("/products")
               .contentType(MediaType.APPLICATION_JSON)
               .content(productJSON)
            )
            .andExpect(status().isBadRequest)
    }


    @Test
    fun `should saved product when valid product data is given to save`() {
        val product = Product(0,"Product1","New Product1", BigDecimal.TEN,
                        Vendor(1, "Vendor1"), Category(2))
        val productJSON = ObjectMapper().writeValueAsString(product)
        `when`(productRepository.save(Matchers.any(Product::class.java))).thenReturn(product)

        mockMvc.perform(
            post("/products")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(productJSON)
            )
            .andExpect(status().isOk)
            // .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.name").value("Product1"))
            .andExpect(jsonPath("$.description").value("New Product1"))
            .andExpect(jsonPath("$.price").value(BigDecimal.TEN))
            .andExpect(jsonPath("$.vendor.id").value(1))
            .andExpect(jsonPath("$.category.id").value(2))
    }
}
