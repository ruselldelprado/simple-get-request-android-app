package dev.rusell.simple_get_request.model.api

import dev.rusell.simple_get_request.model.Character
import retrofit2.http.GET

interface GetCharacterService {
    @GET("character")
    suspend fun getCharacters(): Character
}