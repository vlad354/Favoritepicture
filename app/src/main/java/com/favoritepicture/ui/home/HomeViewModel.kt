package com.favoritepicture.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.favoritepicture.network.PicsumApi
import com.favoritepicture.network.PicsumPageData
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _allPicture = MutableLiveData<List<PicsumPageData>>()
    val allPicture: LiveData<List<PicsumPageData>>
        get() = _allPicture


    init {
        getPicsumPage()
    }

    private fun getPicsumPage() {
        viewModelScope.launch {
            try {
                _allPicture.value = PicsumApi.retrofitService.getPageOne()
            } catch (e: Exception) {
            }
    }}

}