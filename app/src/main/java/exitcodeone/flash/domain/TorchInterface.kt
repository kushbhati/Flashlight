package exitcodeone.flash.domain

import androidx.lifecycle.MutableLiveData

interface TorchInterface {
    var isTorchAvailable: MutableLiveData<Boolean>
    var isTorchOn: MutableLiveData<Boolean>

    fun turnOn()
    fun turnOff()
}