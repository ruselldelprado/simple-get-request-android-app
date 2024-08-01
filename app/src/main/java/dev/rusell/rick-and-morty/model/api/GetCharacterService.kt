package dev.rusell.`rick-and-morty`.model.api

import dev.rusell.`rick-and-morty`.model.Character
import retrofit2.http.GET

interface GetCharacterService {
    @GET("character")
    suspend fun getCharacters(): Character
}