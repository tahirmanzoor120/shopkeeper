package com.tahirmanzoor.shopkeeper.data.repo

import androidx.lifecycle.LiveData
import com.tahirmanzoor.shopkeeper.data.dao.ProductDAO
import com.tahirmanzoor.shopkeeper.data.entity.Product

class ProductRepo(private val productDAO: ProductDAO) {

    val allProducts: LiveData<List<Product>> = productDAO.getAllProducts()

    suspend fun insert(product: Product) {
        productDAO.insert(product)
    }

    suspend fun delete(product: Product) {
        productDAO.delete(product)
    }

    suspend fun update(product: Product) {
        productDAO.update(product)
    }
}