package dev.taah.stardew.net

/**
 * @author Taah
 * @project stardew-server
 * @since 1:34 AM [12-08-2023]
 *
 */
class Time {
    companion object {
        private val timeInit = System.nanoTime()
        fun now(): Double {
            return ((System.nanoTime() - timeInit) * (1.0 / 1_000_000_000.0))
        }
    }
}