package com.bangkit.academy.wastemanagement.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bangkit.academy.wastemanagement.core.domain.usecase.WasteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(wasteUseCase: WasteUseCase) : ViewModel() {
    val waste = wasteUseCase.getWaste().asLiveData()
}