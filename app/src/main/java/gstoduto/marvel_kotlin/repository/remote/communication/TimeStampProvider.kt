package gstoduto.marvel_kotlin.repository.remote.communication

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Wrapper to provide the current time stamp.
 */
@Singleton
class TimeStampProvider @Inject constructor() {
    /**
     * Get current time stamp
     *
     * @return - string value of the current time stamp.
     */
    val timeStamp: String
        get() = System.currentTimeMillis().toString()
}