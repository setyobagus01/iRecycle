package com.bangkit.academy.wastemanagement.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bangkit.academy.wastemanagement.core.domain.usecase.WasteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(wasteUseCase: WasteUseCase) : ViewModel() {

    val history = wasteUseCase.getPredictionHistory().asLiveData()

}