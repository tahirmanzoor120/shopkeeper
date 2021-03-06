package com.tahirmanzoor.shopkeeper.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tahirmanzoor.shopkeeper.data.entity.Product

@Dao
interface ProductDAO {

    @Query("SELECT * FROM products")
    fun getAllProducts(): LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(product: Product)

    @Delete
    suspend fun delete(product: Product)

    @Update
    suspend fun update(product: Product)

}