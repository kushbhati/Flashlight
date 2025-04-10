package exitcodeone.flash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cafe.adriel.voyager.navigator.Navigator
import exitcodeone.flash.pages.TorchPage
import exitcodeone.flash.ui.theme.FlashlightTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlashlightTheme {
                Navigator(TorchPage())
            }
        }
    }
}