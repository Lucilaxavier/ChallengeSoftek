package com.softtek.challenge.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AvaliacaoLocal::class, DiarioLocal::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun avaliacaoDao(): AvaliacaoDao
    abstract fun diarioDao(): DiarioDao
}
