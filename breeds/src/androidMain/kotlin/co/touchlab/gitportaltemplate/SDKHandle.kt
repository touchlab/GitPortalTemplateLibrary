package co.touchlab.gitportaltemplate

import co.touchlab.gitportaltemplate.repository.BreedRepository

data class SDKHandle(
    val breedRepository: BreedRepository,
    val appAnalytics: AppAnalytics,
    val breedAnalytics: BreedAnalytics
)