package com.elmaddinasger.customerregister

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.elmaddinasger.customerregister.databinding.FragmentAddCountryBinding
import com.elmaddinasger.customerregister.databinding.FragmentCustomerListragmentBinding
import com.elmaddinasger.customerregister.dbCountry.CountryDatabase
import com.elmaddinasger.customerregister.dbCountry.CountryEntity
import com.elmaddinasger.customerregister.dbCustomers.CustomerDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddCountryFragment : Fragment() {

    private lateinit var binding: FragmentAddCountryBinding
    private lateinit var countryDao: CustomerDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddCountryBinding.inflate(inflater,container,false)
        countryDao = CustomerDatabase.getDatabase(requireContext())
        return binding.root
          }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            addCountry()
        }
    }





    private fun addCountry () {
        val countryName = binding.inpedtCountryName.text.toString()
        val countryCode = binding.inpedtCountryCode.text.toString()

        if (countryCode.isNotEmpty() && countryName.isNotEmpty()) {
            val countryCodeInt = countryCode.toInt()
            CoroutineScope(Dispatchers.IO).launch {
                val entity = CountryEntity(0,countryName,countryCodeInt)
                countryDao.countryDao().insert(entity)
                withContext(Dispatchers.Main){
                    Toast.makeText(requireContext(),"Country Saved",Toast.LENGTH_SHORT).show()
                    binding.inpedtCountryName.setText("")
                    binding.inpedtCountryCode.setText("")
                    findNavController().popBackStack()
                }
            }
        }
    }



}