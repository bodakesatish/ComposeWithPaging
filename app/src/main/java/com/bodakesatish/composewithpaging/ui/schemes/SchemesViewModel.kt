package com.bodakesatish.composewithpaging.ui.schemes

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodakesatish.composewithpaging.domain.model.Scheme
import com.bodakesatish.composewithpaging.domain.usecases.GetSchemeListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchemesViewModel @Inject constructor(
    private val getCustomerListUseCase: GetSchemeListUseCase
) : ViewModel() {

    private val tag = this.javaClass.simpleName

    private val _customerList = MutableStateFlow<List<Scheme>>(emptyList())
    val customers: StateFlow<List<Scheme>> = _customerList.asStateFlow()

    init {
        Log.d(tag, "$tag->init")
    }

    fun getCustomerList() {
        Log.d(tag, "$tag->getCustomerList")
        viewModelScope.launch(Dispatchers.IO) {
            getCustomerListUseCase.invoke().collect { list ->
                _customerList.value = list
                Log.d(tag, "In $tag $list")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(tag , "$tag->onCleared")
    }
}