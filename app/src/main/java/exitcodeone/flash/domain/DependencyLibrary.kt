package exitcodeone.flash.domain

import android.content.Context
import android.hardware.camera2.CameraManager
import exitcodeone.flash.hardware.AndroidTorch

object DependencyLibrary {
    lateinit var appContext: Context

    private val cameraManager: CameraManager by lazy {
        appContext.getSystemService(Context.CAMERA_SERVICE) as CameraManager
    }

    val torch: TorchInterface by lazy { AndroidTorch(cameraManager) }
}