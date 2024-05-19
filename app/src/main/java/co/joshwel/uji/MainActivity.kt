package co.joshwel.uji

import android.Manifest
import android.app.NotificationManager
import android.content.Context
import android.os.Build
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
import androidx.core.app.ActivityCompat
import co.joshwel.uji.ui.theme.UjiTheme

const val REQUEST_CODE_NOTIFICATION_PERMISSION = 123

val kaomojis = arrayOf(
    "ヾ(≧▽≦*)o",
    "φ(*￣0￣)",
    "q(≧▽≦q)",
    "ψ(｀∇´)ψ",
    "（￣︶￣）↗",
    "*^____^*",
    "(～￣▽￣)～",
    "( •̀ ω •́ )",
    "φ(゜▽゜*)♪",
    "o(*^＠^*)o",
    "O(∩_∩)O",
    "(✿◡‿◡)",
    "(*^▽^*)",
    "（*＾-＾*）",
    "(*^_^*)",
    "(❁´◡`❁)",
    "(≧∇≦)ﾉ",
    "(￣y▽￣)╭",
    "\\^o^/",
    "(*^▽^*)┛",
    "♪(^∇^*)",
    "(≧∀≦)",
    "(oﾟvﾟ)o",
    "(o≧▽≦)o",
    "(/≧▽≦)/",
    "(*︾▽︾)",
    "(≧ ▽ ≦)",
    "o(≧▽≦)o",
    "(((o(*ﾟ▽ﾟ*)o)))",
    "♪(´▽｀)",
    "( *^-^)",
    "(^v^)",
    "(o゜▽゜)o☆"
)

val messages = arrayOf(
    "wake up! 18 minutes have passed!",
    "18 minutes have passed!",
    "ah! 18 minutes have passed!!!!!!!!",
    "hey! 18 minutes have passed! did you know?",
    "hey, guess what? 18 minutes have passed!,",
    "18 minutes have passed...",
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // make scheduler and check for notification perms
        val scheduler = UselessScheduler(this)
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val areNotificationsEnabled = notificationManager.areNotificationsEnabled()
        if (!areNotificationsEnabled) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    REQUEST_CODE_NOTIFICATION_PERMISSION
                )
            }
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
        text = "Uji",
        modifier = modifier
    )
}
