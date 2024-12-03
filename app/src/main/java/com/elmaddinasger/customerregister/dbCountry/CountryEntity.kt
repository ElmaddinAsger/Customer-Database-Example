package com.elmaddinasger.customerregister.dbCountry

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CountryTable")
data class CountryEntity(
    @PrimaryKey(autoGenerate = true)
    val countryId: Long,
    val countryName: String,
    val countryCode: Int
){
    override fun toString(): String {
        return countryName
    }
}
