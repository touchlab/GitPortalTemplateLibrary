package co.touchlab.gitportaltemplate.sqldelight

import app.cash.sqldelight.Transacter
import app.cash.sqldelight.TransactionWithoutReturn
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

internal suspend fun Transacter.transactionWithContext(
    coroutineContext: CoroutineContext,
    noEnclosing: Boolean = false,
    body: TransactionWithoutReturn.() -> Unit
) {
    withContext(coroutineContext) {
        this@transactionWithContext.transaction(noEnclosing) {
            body()
        }
    }
}
