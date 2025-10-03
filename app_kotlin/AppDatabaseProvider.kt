package com.softtek.challenge.data

import android.content.Context
import androidx.room.Room

object AppDatabaseProvider {
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "challenge_db"
            ).build()
        }
        return INSTANCE!!
    }
}
