package com.elmaddinasger.customerregister.dbCustomers

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameTable
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import com.elmaddinasger.customerregister.dbCountry.CountryDao
import com.elmaddinasger.customerregister.dbCountry.CountryEntity

@Database(
    entities = [CountryEntity::class,CustomerEntity::class],
    version = 2,
    autoMigrations = [AutoMigration(from = 1,to= 2)]

)
abstract class CustomerDatabase: RoomDatabase() {


    abstract fun countryDao(): CountryDao
    abstract fun customerDao(): CustomersDao

    companion object{
        @Volatile
        private var INSTANCE : CustomerDatabase? = null

        fun getDatabase(context: Context) : CustomerDatabase {

            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CustomerDatabase::class.java,
                    "CustomerDatabase"
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }
}