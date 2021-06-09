package com.bangkit.academy.wastemanagement.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bangkit.academy.wastemanagement.core.domain.model.Predict
import com.bangkit.academy.wastemanagement.core.domain.usecase.WasteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(private val wasteUseCase: WasteUseCase) : ViewModel() {

    val history = wasteUseCase.getPredictionHistory().asLiveData()

    fun deleteHistory(prediction: Predict) {
        wasteUseCase.deletePredictionHistory(prediction)
    }

}