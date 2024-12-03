package com.elmaddinasger.customerregister.dbCountry

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CountryEntity::class], version = 1)
abstract class CountryDatabase: RoomDatabase() {
    abstract fun countryDao() : CountryDao

    companion object {
        @Volatile
        private var INSTANCE: CountryDatabase? = null

        fun getDatabase (context: Context) : CountryDatabase {

            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CountryDatabase::class.java,"CountryDatabase"
                ).build()
                INSTANCE = instance
                instance
            }

        }
    }
}