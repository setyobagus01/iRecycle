package com.bangkit.academy.wastemanagement.core.di

import com.bangkit.academy.wastemanagement.core.domain.usecase.WasteInteractor
import com.bangkit.academy.wastemanagement.core.domain.usecase.WasteUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
abstract class AppModule {
    @ViewModelScoped
    @Binds
    abstract fun provideWasteUseCase(wasteInteractor: WasteInteractor): WasteUseCase
}