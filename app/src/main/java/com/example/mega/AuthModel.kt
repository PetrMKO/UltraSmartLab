package com.example.mega

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.mega.MainScreen
sealed interface AuthUIState {
    data class Success(val bookSearch: String) : AuthUIState
    object Error : AuthUIState
    object Empty : AuthUIState
}
//class AuthModel : ViewModel(){
//    var authUiState: AuthUIState by mutableStateOf(AuthUIState.Empty)
//        private set
//
//    companion object {
//        val Factory: ViewModelProvider.Factory = viewModelFactory {
//            initializer {
//                val application = (this[APPLICATION_KEY] as ViewModel)
//                val booksRepository = application.container.booksRepository
//                BooksViewModel(booksRepository = booksRepository)
//            }
//        }
//    }
//}