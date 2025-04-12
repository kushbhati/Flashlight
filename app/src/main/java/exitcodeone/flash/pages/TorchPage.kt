package exitcodeone.flash.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
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
                Switch(
                    checked = screenModel.isTorchOn.observeAsState().value == true,
                    onCheckedChange = {
                        screenModel.toggleTorch()
                    },
                    modifier = Modifier
                        .rotate(-90f)
                        .scale(3f)
                )
            }
        }
    }
}