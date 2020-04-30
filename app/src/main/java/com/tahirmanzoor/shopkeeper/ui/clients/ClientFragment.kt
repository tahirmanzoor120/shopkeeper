package com.tahirmanzoor.shopkeeper.ui.clients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tahirmanzoor.shopkeeper.R

class ClientFragment : Fragment() {

    private lateinit var clientViewModel: ClientViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        clientViewModel =
            ViewModelProviders.of(this).get(ClientViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_clients, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        clientViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
