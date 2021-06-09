package com.bangkit.academy.wastemanagement.detailresult

import androidx.lifecycle.*
import com.bangkit.academy.wastemanagement.core.domain.model.Predict
import com.bangkit.academy.wastemanagement.core.domain.usecase.WasteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailResultViewModel @Inject constructor(private val wasteUseCase: WasteUseCase): ViewModel(){
    private var _wasteType = MutableLiveData<String>()
    private val wasteType: LiveData<String> get() = _wasteType

    fun getWasteType(wasteType: String) {
        this._wasteType.value = wasteType
    }

    val waste = Transformations.switchMap(wasteType) { wasteType ->
        wasteUseCase.getWasteByType(wasteType).asLiveData()
    }


    fun savedToHistory(prediction: Predict, imageUrl: String) {
        wasteUseCase.setImagePrediction(prediction, imageUrl, true)
    }

}