package co.touchlab.gitportaltemplate

import co.touchlab.gitportaltemplate.db.GitPortalTemplateDb
import co.touchlab.gitportaltemplate.repository.BreedRepository
import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import io.ktor.client.engine.*
import io.ktor.client.engine.darwin.*
import platform.Foundation.NSUserDefaults

fun breedStartup(analyticsHandle: AnalyticsHandle): BreedRepository {
    val locator = IOSServiceLocator(NSUserDefaults(suiteName = SETTINGS_KEY), analyticsHandle = analyticsHandle)
    return locator.breedRepository
}

internal class IOSServiceLocator(
    userDefaults: NSUserDefaults,
    analyticsHandle: AnalyticsHandle
) : BaseServiceLocator(analyticsHandle) {

    override val sqlDriver: SqlDriver by lazy {
        NativeSqliteDriver(GitPortalTemplateDb.Schema, DB_NAME)
    }

    override val settings: Settings by lazy { NSUserDefaultsSettings(userDefaults) }

    override val clientEngine: HttpClientEngine by lazy { Darwin.create() }
}
