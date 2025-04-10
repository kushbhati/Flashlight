package exitcodeone.flash.pages

import cafe.adriel.voyager.core.model.ScreenModel
import exitcodeone.flash.domain.DependencyLibrary

class TorchScreenModel : ScreenModel {
    private val torch = DependencyLibrary.torch

    val isTorchAvailable = torch.isTorchAvailable
    val isTorchOn = torch.isTorchOn

    fun toggleTorch() {
        if (torch.isTorchOn.value != false) torch.turnOff() else torch.turnOn()
    }
}
