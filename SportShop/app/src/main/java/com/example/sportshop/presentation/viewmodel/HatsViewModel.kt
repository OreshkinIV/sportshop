package com.example.sportshop.presentation.viewmodel

import android.content.Context
import com.example.sportshop.R
import com.example.sportshop.data.model.database.DatabaseProvider
import com.example.sportshop.domain.network.NetworkService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi
import java.io.IOException

class HatsViewModel(
    private val context: Context,
    private val coroutineScope: CoroutineScope
) {
    private val hatsDao = DatabaseProvider.provideDatabase(context).productsDao()
    private var _screenState = MutableStateFlow<ScreenState>(ScreenState.Loading)
    val screenState: StateFlow<ScreenState> = _screenState

    private var job: Job? = null

    @ExperimentalSerializationApi
    fun loadData() {
        job?.cancel()
        job = coroutineScope.launch {
            try {
                _screenState.value = ScreenState.Loading
                val hats = try {
                   NetworkService(context).loadHats().also {
                        hatsDao.insertAll(it)
                    }
                } catch (ex: IOException){
                    hatsDao.getAll()
                }
                _screenState.value = ScreenState.DataLoaded(hats)
            } catch(ex: Throwable) {
                _screenState.value = ScreenState.Error(context.getString(R.string.error))
            }
        }
    }
}