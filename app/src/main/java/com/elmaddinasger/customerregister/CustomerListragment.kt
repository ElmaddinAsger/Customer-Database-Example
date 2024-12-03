package com.elmaddinasger.customerregister

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.elmaddinasger.customerregister.databinding.FragmentCustomerListragmentBinding

class CustomerListragment : Fragment() {

    private lateinit var binding : FragmentCustomerListragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCustomerListragmentBinding.inflate(inflater,container,false)
        return binding.root
         }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAddCountry.setOnClickListener {
            findNavController().navigate(R.id.action_customerListragment_to_addCountryFragment)
        }
        binding.btnAddCustomer.setOnClickListener {
            findNavController().navigate(R.id.action_customerListragment_to_addCustomerFragment)
        }
    }


}