package com.leantechstacks.jcart.bo.web.controllers

import com.leantechstacks.jcart.bo.entities.Product
import com.leantechstacks.jcart.bo.repositories.ProductRepository
import com.leantechstacks.jcart.bo.web.model.ProductModel
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.runners.MockitoJUnitRunner
import java.math.BigDecimal

@RunWith(MockitoJUnitRunner::class)
class ProductControllerTest {

    @InjectMocks
    lateinit var productController: ProductController

    @Mock
    lateinit var productRepository: ProductRepository

    @Test
    fun should_return_product_list() {
        `when`(productRepository.findAll())
                .thenReturn(listOf(
                    Product(1, "HBD Card", "Happy Birthday Card", BigDecimal(10)),
                    Product(2, "Sunrise Flower", "Sunrise Flower", BigDecimal(12)))
                )
        val products: List<ProductModel> = productController.listProducts()
        Assert.assertNotNull(products)
        Assert.assertEquals(2, products.size)
    }
}
