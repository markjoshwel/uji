package co.joshwel.uji.uselessness

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log


private const val TAG = "UselessStartupReceiver"


class UselessStartupReceiver : BroadcastReceiver() {
    private var hasRun = false

    override fun onReceive(context: Context?, intent: Intent?) {
        if (context == null) {
            Log.e(TAG, "context is null")
            return
        }

        if (intent == null) {
            Log.e(TAG, "intent is null")
            return
        }

        when (intent.action) {
            Intent.ACTION_BOOT_COMPLETED -> {
                Log.d(TAG, "received ACTION_BOOT_COMPLETED")
            }

            Intent.ACTION_LOCKED_BOOT_COMPLETED -> {
                Log.d(TAG, "received ACTION_LOCKED_BOOT_COMPLETED")
            }

            else -> {
                Log.d(TAG, "unimplemented action ${intent.action} (unreachable?)")
                return
            }
        }

        // TODO
    }
}
