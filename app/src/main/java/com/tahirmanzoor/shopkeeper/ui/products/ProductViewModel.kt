package com.tahirmanzoor.shopkeeper.ui.products

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.tahirmanzoor.shopkeeper.data.database.ShopKeeperDatabase
import com.tahirmanzoor.shopkeeper.data.entity.Product
import com.tahirmanzoor.shopkeeper.data.repo.ProductRepo
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {

    private val productRepo: ProductRepo =
        ProductRepo(ShopKeeperDatabase.getInstance(application).productDAO)

    val allProducts: LiveData<List<Product>>

    init {
        allProducts = productRepo.allProducts
//        insert(Product(
//            0,
//            "Sample Product",
//            "Manufacturer",
//            "00AABBCC44",
//            "100ml",
//            mfg = Date(),
//            exp = Date()
//        ))
    }

    fun insert(product: Product) = viewModelScope.launch {
        productRepo.insert(product)
    }

    fun update(product: Product) = viewModelScope.launch {
        productRepo.update(product)
    }

    fun delete(product: Product) = viewModelScope.launch {
        productRepo.delete(product)
    }
}