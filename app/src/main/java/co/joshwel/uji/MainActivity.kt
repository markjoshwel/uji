package co.joshwel.uji

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.joshwel.uji.ui.theme.UjiTheme
import co.joshwel.uji.uselessness.UselessAnnouncement
import co.joshwel.uji.uselessness.UselessScheduler
import java.time.LocalDateTime
import java.time.ZoneId


private const val TAG = "Uji"


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        var ujiIsEnabled = true

        // make scheduler and check for notification perms
        val scheduler = UselessScheduler(this)
        val mailman = NotificationMailman(this)
        mailman.requestPermission(this)

        if (mailman.areNotificationsEnabled()) {
            UselessAnnouncement(
                LocalDateTime.now(ZoneId.systemDefault()),
            ).apply { scheduler.dispatch(this) }
        }

        setContent {
            UjiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Text(
        text = UjiCommons.APP_NAME, modifier = modifier
    )
}
