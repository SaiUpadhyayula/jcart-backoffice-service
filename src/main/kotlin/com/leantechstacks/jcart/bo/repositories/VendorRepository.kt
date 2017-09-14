package com.leantechstacks.jcart.bo.repositories

import com.leantechstacks.jcart.bo.entities.Vendor
import org.springframework.data.jpa.repository.JpaRepository

interface VendorRepository : JpaRepository<Vendor, Long>
