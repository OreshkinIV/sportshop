package com.example.sportshop.presentation.viewmodel

import android.content.Context
import com.example.sportshop.R
import com.example.sportshop.domain.network.NetworkService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi

class TshirtsViewModel(
    private val context: Context,
    private val coroutineScope: CoroutineScope
) {
    private val _screenState = MutableStateFlow<ScreenState>(ScreenState.Loading)
    val screenState: StateFlow<ScreenState> = _screenState

    private var job: Job? = null

    @ExperimentalSerializationApi
    fun loadData() {
        job?.cancel()
        job = coroutineScope.launch {
            try {
                _screenState.emit(ScreenState.Loading)
                val tshirts = NetworkService.loadTshirts()
                _screenState.emit(ScreenState.DataLoaded(tshirts))
            } catch (ex: Throwable) {
                _screenState.emit(ScreenState.Error(context.resources.getString(R.string.error)))
            }
        }
    }
}