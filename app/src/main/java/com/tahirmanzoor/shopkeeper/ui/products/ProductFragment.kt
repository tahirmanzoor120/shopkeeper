package com.tahirmanzoor.shopkeeper.ui.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tahirmanzoor.shopkeeper.R

class ProductFragment : Fragment() {

    private lateinit var productListAdapter: ProductListAdapter
    private lateinit var productViewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        productViewModel =
            ViewModelProviders.of(this).get(ProductViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_products, container, false)

        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = ProductListAdapter(context)
            }
            productListAdapter = view.adapter as ProductListAdapter
            productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
            productViewModel.allProducts.observe(viewLifecycleOwner, Observer {
                it?.let { productListAdapter.setProducts(it) }
            })
        }

        return view
    }
}
