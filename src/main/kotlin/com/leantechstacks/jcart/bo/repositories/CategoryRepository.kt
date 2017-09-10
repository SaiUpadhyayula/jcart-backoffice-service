package com.leantechstacks.jcart.bo.repositories

import com.leantechstacks.jcart.bo.entities.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Long>
