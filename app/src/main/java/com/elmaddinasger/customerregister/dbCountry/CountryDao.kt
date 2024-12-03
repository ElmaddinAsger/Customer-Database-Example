package com.elmaddinasger.customerregister.dbCountry

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CountryDao {

    @Query("SELECT * FROM CountryTable")
    fun getAll(): List<CountryEntity>

    @Insert
    fun insert(country: CountryEntity): Long
}