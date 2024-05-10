package co.touchlab.gitportaltemplate

import co.touchlab.gitportaltemplate.repository.BreedRepository

internal interface ServiceLocator {
    val breedRepository: BreedRepository
    val appAnalytics: AppAnalytics
    val breedAnalytics: BreedAnalytics
    val httpClientAnalytics: HttpClientAnalytics
}
