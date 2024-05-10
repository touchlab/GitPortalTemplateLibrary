package co.touchlab.gitportaltemplate.ktor

import co.touchlab.gitportaltemplate.response.BreedResult

internal interface DogApi {
    suspend fun getJsonFromApi(): BreedResult
}
