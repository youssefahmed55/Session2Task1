package com.example.session2task1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.PostModelItem
import com.example.domain.usecase.GetDataFromRemote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getDataFromRemote: GetDataFromRemote) : ViewModel() {

    private val _postModelsState =  MutableStateFlow<List<PostModelItem>>(emptyList())
    val postModelsState = _postModelsState.asStateFlow()


    init {
        getPosts()
    }

    private fun getPosts(){
        viewModelScope.launch {
            _postModelsState.update { getDataFromRemote() }
        }

    }
}