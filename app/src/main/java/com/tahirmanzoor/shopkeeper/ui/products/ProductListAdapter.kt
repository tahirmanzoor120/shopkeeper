package com.tahirmanzoor.shopkeeper.ui.products

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tahirmanzoor.shopkeeper.R
import com.tahirmanzoor.shopkeeper.data.entity.Product

class ProductListAdapter internal constructor(context: Context) :
    RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var products = emptyList<Product>() // Cached copy of products

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productTitle: TextView = itemView.findViewById(R.id.product_card_title)
        val purchasePrice: TextView = itemView.findViewById(R.id.product_card_purchase_price)
        val salePrice: TextView = itemView.findViewById(R.id.product_card_sale_price)
        val quantity: TextView = itemView.findViewById(R.id.product_card_quantity)
        val stockValue: TextView = itemView.findViewById(R.id.product_card_stock_value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val productView = inflater.inflate(R.layout.product_card_view, parent, false)
        return ProductViewHolder(productView)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val context = holder.itemView.context
        val product = products[position]
        val stockValue = product.quantity.toDouble() * product.purchasePrice.toDouble()
        val purchasePrice = product.purchasePrice.toDouble()
        val salePrice = product.salePrice.toDouble()
        val stockQuantity = product.quantity.toInt()
        val builderTitle = StringBuilder()

        builderTitle.append(product.productName).append(" (")
            .append(product.manufacturer).append(") ")
            .append(product.packing)

        holder.productTitle.text = builderTitle.toString()
        holder.purchasePrice.text = roundToTwoDecimalPlaces(context, purchasePrice)
        holder.salePrice.text = roundToTwoDecimalPlaces(context, salePrice)
        holder.quantity.text = stockQuantity.toString()
        holder.stockValue.text = roundToTwoDecimalPlaces(context, stockValue)

    }

    internal fun setProducts(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }

    internal fun roundToTwoDecimalPlaces(context: Context, double: Double): String {
        return context.getString(R.string.round_to_two_decimal_places).format(double)
    }
}