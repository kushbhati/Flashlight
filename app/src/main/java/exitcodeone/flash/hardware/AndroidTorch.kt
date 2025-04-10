package exitcodeone.flash.hardware

import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.hardware.camera2.CameraManager.TorchCallback
import androidx.lifecycle.MutableLiveData
import exitcodeone.flash.domain.TorchInterface

class AndroidTorch(private val cameraManager: CameraManager) : TorchInterface {
    override var isTorchAvailable = MutableLiveData(false)
    override var isTorchOn = MutableLiveData(false)

    val torchCameraId = run {
        val cameraIds = cameraManager.cameraIdList
        val cameraIdsWithFlash = cameraIds.filter {
            cameraManager.getCameraCharacteristics(it).get(CameraCharacteristics.FLASH_INFO_AVAILABLE) == true
        }

        if (cameraIdsWithFlash.isEmpty()) {
            isTorchAvailable.postValue(false)
            ""
        } else {
            isTorchAvailable.postValue(true)
            cameraIdsWithFlash[0]
        }
    }

    override fun turnOn() {
        if (isTorchAvailable.value == true)
            cameraManager.setTorchMode(torchCameraId, true)
    }

    override fun turnOff() {
        if (isTorchAvailable.value == true)
            cameraManager.setTorchMode(torchCameraId, false)
    }

    init {
        cameraManager.registerTorchCallback(object : TorchCallback() {
            override fun onTorchModeChanged(cameraId: String, enabled: Boolean) {
                isTorchOn.postValue(enabled)
            }
        }, null)
    }
}