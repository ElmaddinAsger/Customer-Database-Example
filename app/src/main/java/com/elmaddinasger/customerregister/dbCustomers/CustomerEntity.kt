package com.elmaddinasger.customerregister.dbCustomers

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.elmaddinasger.customerregister.ColumnRename
import com.elmaddinasger.customerregister.dbCountry.CountryEntity

@Entity(tableName = "CustomersTable",
    foreignKeys = [
        ForeignKey(
            entity = CountryEntity::class,
            parentColumns = ["countryId"],
            childColumns = ["countryId"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class CustomerEntity(
    @PrimaryKey(autoGenerate = true)
    val customerId: Long,
    val customerName: String,
    val countryId: Long?,
    val birthDay: String? = null
)
