package com.tahirmanzoor.shopkeeper.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "product_id") var productId: Long = 0, // Default Value

    @ColumnInfo(name = "product_name") var productName: String,

    var manufacturer: String,

    var batch: String,

    var packing: String,

    var mfg: Date,

    var exp: Date,

    @ColumnInfo(name = "retail_price") var retailPrice: Double = 0.0,

    @ColumnInfo(name = "sale_price") var salePrice: Double = 0.0,

    @ColumnInfo(name = "purchase_price") var purchasePrice: Double = 0.0,

    var quantity: Int = 0,

    @ColumnInfo(name = "min_quantity") var minQuantity: Int = 0
)