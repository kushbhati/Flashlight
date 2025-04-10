package exitcodeone.flash.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen

class TorchPage : Screen {
    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { TorchScreenModel() }

        Scaffold {
            Column(
                modifier = Modifier.padding(it).fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        screenModel.toggleTorch()
                    }
                ) {
                    Text(
                        text = if (screenModel.isTorchOn.observeAsState(false).value == true)
                            "Turn off"
                        else "Turn on"
                    )
                }

            }
        }
    }
}