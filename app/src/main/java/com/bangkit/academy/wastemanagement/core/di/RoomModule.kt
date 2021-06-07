package com.bangkit.academy.wastemanagement.core.di

import android.content.Context
import androidx.room.Room
import com.bangkit.academy.wastemanagement.core.data.source.local.room.WasteDao
import com.bangkit.academy.wastemanagement.core.data.source.local.room.WasteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideWasteDb(@ApplicationContext context: Context): WasteDatabase {
        return Room.databaseBuilder(
            context,
            WasteDatabase::class.java,
            WasteDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideWasteDao(wasteDatabase: WasteDatabase): WasteDao {
        return wasteDatabase.wasteDao()
    }
}