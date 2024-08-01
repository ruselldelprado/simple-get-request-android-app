package dev.rusell.`rick-and-morty`.model.repository

import dev.rusell.`rick-and-morty`.model.Character
import dev.rusell.`rick-and-morty`.model.api.RetrofitInstance

class ApiRepository {
    private val characterService = RetrofitInstance.getCharacterService

    suspend fun getCharacter(): Character {
        return characterService.getCharacters()
    }
}