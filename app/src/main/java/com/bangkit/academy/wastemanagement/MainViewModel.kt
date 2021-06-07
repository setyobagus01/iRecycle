package com.bangkit.academy.wastemanagement

import androidx.lifecycle.*
import com.bangkit.academy.wastemanagement.core.domain.usecase.WasteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.File
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(wasteUseCase: WasteUseCase): ViewModel() {
    private var _file = MutableLiveData<File>()
    private val file: LiveData<File> get() = _file

    fun getFile(file: File) {
        this._file.value = file
    }


    val predict = Transformations.switchMap(file){ pic ->
        wasteUseCase.getPrediction(pic).asLiveData()
    }

}