package com.tahirmanzoor.shopkeeper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class NewProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_product)

        val productName: TextInputEditText = findViewById(R.id.editText_productName)
        val bundle = intent.extras
        if (bundle != null) {
            productName.append(bundle.getLong("productId").toString())
        }
    }

}
