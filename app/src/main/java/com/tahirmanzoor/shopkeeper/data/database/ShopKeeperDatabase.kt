package com.tahirmanzoor.shopkeeper.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tahirmanzoor.shopkeeper.data.converter.DateConverter
import com.tahirmanzoor.shopkeeper.data.dao.ProductDAO
import com.tahirmanzoor.shopkeeper.data.entity.Product

@Database(version = 1, entities = [Product::class], exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class ShopKeeperDatabase : RoomDatabase() {

    abstract val productDAO: ProductDAO

    companion object {

        @Volatile
        private var INSTANCE: ShopKeeperDatabase? = null

        fun getInstance(context: Context): ShopKeeperDatabase {
            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ShopKeeperDatabase::class.java,
                        "shopkeeper_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}