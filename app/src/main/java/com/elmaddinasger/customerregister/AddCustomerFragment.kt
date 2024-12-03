package com.elmaddinasger.customerregister

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.elmaddinasger.customerregister.databinding.FragmentAddCustomerBinding
import com.elmaddinasger.customerregister.dbCountry.CountryEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import android.R
import android.widget.Toast
import com.elmaddinasger.customerregister.dbCustomers.CustomerDatabase
import com.elmaddinasger.customerregister.dbCustomers.CustomerEntity

class   AddCustomerFragment : Fragment() {

    private lateinit var binding: FragmentAddCustomerBinding
    private lateinit var countryDao: CustomerDatabase
    private lateinit var customerDao: CustomerDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddCustomerBinding.inflate(inflater,container,false)
        countryDao = CustomerDatabase.getDatabase(requireContext())
        setSpinner()
        customerDao = CustomerDatabase.getDatabase(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            addCustomer()
        }
    }

    private fun setSpinner() {
        CoroutineScope(Dispatchers.IO).launch {
            val countryList = countryDao.countryDao().getAll()
            withContext(Dispatchers.Main){
                val spinnerAdapter = ArrayAdapter(requireContext(), R.layout.simple_spinner_item,countryList)
                spinnerAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
                binding.spnCountry.adapter = spinnerAdapter
            }
        }
    }

    private fun addCustomer() {
        val customerName = binding.inpedtCustomerName.text.toString()
        val customerCountry = binding.spnCountry.selectedItem as? CountryEntity
         if (customerName.isNotEmpty()){
             CoroutineScope(Dispatchers.IO).launch {
                val customerEntity  = CustomerEntity(0,customerName,customerCountry?.countryId)
                customerDao.customerDao().insert(customerEntity)
                 withContext(Dispatchers.Main){
                     Toast.makeText(requireContext(),"Customer Saved",Toast.LENGTH_SHORT).show()
                     binding.inpedtCustomerName.setText("")
                 }
             }
         }

    }

}