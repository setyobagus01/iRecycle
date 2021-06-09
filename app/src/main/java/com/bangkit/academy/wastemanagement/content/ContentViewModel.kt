package com.bangkit.academy.wastemanagement.content

import androidx.lifecycle.*
import com.bangkit.academy.wastemanagement.core.domain.usecase.WasteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContentViewModel @Inject constructor(wasteUseCase: WasteUseCase): ViewModel() {
    private var _wasteType = MutableLiveData<String>()
    private val wasteType: LiveData<String> get() = _wasteType

    fun getWasteType(wasteType: String) {
        this._wasteType.value = wasteType
    }

    val content = Transformations.switchMap(wasteType) { type ->
        wasteUseCase.getContentByType(type).asLiveData()
    }



}