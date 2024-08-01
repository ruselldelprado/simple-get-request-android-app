package dev.rusell.simple_get_request.model.repository

import dev.rusell.simple_get_request.model.Character
import dev.rusell.simple_get_request.model.api.RetrofitInstance

class ApiRepository {
    private val characterService = RetrofitInstance.getCharacterService

    suspend fun getCharacter(): Character {
        return characterService.getCharacters()
    }
}