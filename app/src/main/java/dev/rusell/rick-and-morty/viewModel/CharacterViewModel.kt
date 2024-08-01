package dev.rusell.`rick-and-morty`.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.rusell.`rick-and-morty`.model.Character
import dev.rusell.`rick-and-morty`.model.repository.ApiRepository
import kotlinx.coroutines.launch

class CharacterViewModel:ViewModel()  {
    private val repository = ApiRepository()

    private val _characters = MutableLiveData<Character>()
    val characters: LiveData<Character> = _characters

    fun fetchCharacter() {
        viewModelScope.launch {
            try {
                val chara = repository.getCharacter()
                _characters.value = chara
            }catch (e: Exception) {
                Log.d("Repo", "fetchCharacter exception${e.message}")
            }
        }
    }

}