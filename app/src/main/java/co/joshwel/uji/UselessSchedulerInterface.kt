package co.joshwel.uji

interface UselessSchedulerInterface {
    fun dispatch(announcement: UselessAnnouncement)
    fun destroy(announcement: UselessAnnouncement)
}
