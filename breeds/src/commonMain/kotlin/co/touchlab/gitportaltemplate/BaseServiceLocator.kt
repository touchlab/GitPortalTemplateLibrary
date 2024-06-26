package co.touchlab.gitportaltemplate

import app.cash.sqldelight.db.SqlDriver
import co.touchlab.gitportaltemplate.ktor.DogApi
import co.touchlab.gitportaltemplate.ktor.DogApiImpl
import co.touchlab.gitportaltemplate.repository.BreedRepository
import com.russhwolf.settings.Settings
import io.ktor.client.engine.HttpClientEngine
import kotlinx.coroutines.Dispatchers
import kotlinx.datetime.Clock

internal const val SETTINGS_KEY = "GitPortalTemplateSettings"
internal const val DB_NAME = "GitPortalTemplateDb"

internal abstract class BaseServiceLocator(private val analyticsHandle: AnalyticsHandle) : ServiceLocator {

    override val breedRepository: BreedRepository by lazy {
        BreedRepository(
            dbHelper = databaseHelper,
            settings = settings,
            dogApi = dogApi,
            clock = Clock.System,
            breedAnalytics = breedAnalytics
        )
    }

    override val appAnalytics: AppAnalytics
        get() = analyticsHandle.appAnalytics

    override val breedAnalytics: BreedAnalytics
        get() = analyticsHandle.breedAnalytics

    override val httpClientAnalytics: HttpClientAnalytics
        get() = analyticsHandle.httpClientAnalytics

    private val databaseHelper: DatabaseHelper by lazy {
        DatabaseHelper(
            sqlDriver = sqlDriver,
            backgroundDispatcher = Dispatchers.Default,
            breedAnalytics = breedAnalytics
        )
    }

    private val dogApi: DogApi by lazy {
        DogApiImpl(engine = clientEngine, httpClientAnalytics = httpClientAnalytics, breedAnalytics = breedAnalytics)
    }

    protected abstract val sqlDriver: SqlDriver
    protected abstract val settings: Settings
    protected abstract val clientEngine: HttpClientEngine
}
