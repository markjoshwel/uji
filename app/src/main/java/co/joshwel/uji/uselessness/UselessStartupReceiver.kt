package co.joshwel.uji.uselessness

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log


private const val TAG = "UselessStartupReceiver"


class UselessStartupReceiver : BroadcastReceiver() {
    // TODO
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BOOT_COMPLETED) {
            Log.d(TAG, "we got a boot completed broadcast")
        }
    }
}
