package com.rai.inbrazil.data.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rai.inbrazil.data.repository.ComentarioRepository

class ComentarioViewModelFactory(
    private val repository: ComentarioRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        if (modelClass.isAssignableFrom(ComentarioViewModel::class.java)) {

            @Suppress("UNCHECKED_CAST")
            return ComentarioViewModel(repository) as T
        }

        throw IllegalArgumentException("ViewModel desconhecido")
    }
}