package com.tahirmanzoor.shopkeeper.ui.billing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tahirmanzoor.shopkeeper.R

class BillingFragment : Fragment() {

    private lateinit var billingViewModel: BillingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        billingViewModel = ViewModelProviders.of(this).get(BillingViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_billing, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)

        billingViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        return root
    }
}
