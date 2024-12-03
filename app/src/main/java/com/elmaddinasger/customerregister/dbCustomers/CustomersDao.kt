package com.elmaddinasger.customerregister.dbCustomers

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CustomersDao {
    @Query("SELECT * FROM customerstable")
    fun getAll(): List<CustomerEntity>

    @Insert
    fun insert(customer: CustomerEntity) : Long
}