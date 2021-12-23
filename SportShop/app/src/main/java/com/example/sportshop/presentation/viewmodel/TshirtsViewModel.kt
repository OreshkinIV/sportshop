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

class TshirtsViewModel(
    private val context: Context,
    private val coroutineScope: CoroutineScope
) {
    private val tshirtsDao = DatabaseProvider.provideDatabase(context).productsDao()
    private val _screenState = MutableStateFlow<ScreenState>(ScreenState.Loading)
    val screenState: StateFlow<ScreenState> = _screenState

    private var job: Job? = null

    @ExperimentalSerializationApi
    fun loadData() {
        job?.cancel()
        job = coroutineScope.launch {
            try {
                _screenState.value = ScreenState.Loading
                val tshirts = try {
                    NetworkService(context).loadTshirts().also {
                        tshirtsDao.insertAll(it)
                    }
                } catch (ex: IOException){
                    tshirtsDao.getAll()
                }
                _screenState.value = ScreenState.DataLoaded(tshirts)
            } catch(ex: Throwable) {
                _screenState.value = ScreenState.Error(context.getString(R.string.error))
            }
        }
    }
}