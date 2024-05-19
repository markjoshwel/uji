package co.joshwel.uji

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import co.joshwel.uji.NotificationMailmanInterface.Companion.buildNotificationStatic
import co.joshwel.uji.uselessness.UselessAnnouncementReceiver


private const val TAG = "NotificationMailman"
private val channel = NotificationChannel(
    UjiCommons.CHANNEL_ID,
    UjiCommons.CHANNEL_NAME,
    NotificationManager.IMPORTANCE_HIGH,
).apply {
    description = UjiCommons.CHANNEL_DESCRIPTION
}


interface NotificationMailmanInterface {
    fun areNotificationsEnabled(): Boolean
    fun requestPermission(activity: MainActivity)
    fun buildNotification(message: String): Notification
    fun sendNotification(notification: Notification): Boolean

    companion object {
        fun buildNotificationStatic(context: Context, message: String): Notification {
            val notificationIntent = Intent(context, UselessAnnouncementReceiver::class.java)

            val notificationPendingIntent = PendingIntent.getActivity(
                context,
                UjiCommons.NOTIFICATION_REQUEST_CODE,
                notificationIntent,
                PendingIntent.FLAG_IMMUTABLE
            )

            val builder = NotificationCompat.Builder(context, UjiCommons.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                // .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle(UjiCommons.NOTIFICATION_TITLE).setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            builder.setContentIntent(notificationPendingIntent)

            return builder.build()
        }
    }
}

class NotificationMailman(private val context: Context) : NotificationMailmanInterface {
    private var notificationManager: NotificationManager? = null

    init {
        notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager!!.createNotificationChannel(channel)
    }

    override fun areNotificationsEnabled(): Boolean {
        return notificationManager!!.areNotificationsEnabled()
    }

    override fun requestPermission(activity: MainActivity) {
        if (!areNotificationsEnabled()) {
            Log.d(TAG, "requesting for perms")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    UjiCommons.NOTIFICATION_REQUEST_CODE
                )
            }
        } else {
            Log.d(TAG, "not doing anything, perms already granted")
        }
    }

    override fun buildNotification(message: String): Notification {
        return buildNotificationStatic(context, message)
    }

    override fun sendNotification(notification: Notification): Boolean {
        if (!areNotificationsEnabled()) {
            return false
        }

        with(NotificationManagerCompat.from(context)) {
            if (ActivityCompat.checkSelfPermission(
                    context, Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return false
            }

            notify(UjiCommons.NOTIFICATION_ID, notification)
        }

        return true
    }
}
