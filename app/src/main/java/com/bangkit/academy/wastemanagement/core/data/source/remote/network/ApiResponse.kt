package com.bangkit.academy.wastemanagement.core.data.source.remote.network

sealed class ApiResponse<out R> {
    data class Success<out T>(val data: T): ApiResponse<T>()
    data class Error(val exception: String): ApiResponse<Nothing>()
    object Empty: ApiResponse<Nothing>()
}
