package exitcodeone.flash

import android.app.Application
import exitcodeone.flash.domain.DependencyLibrary

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        DependencyLibrary.appContext = applicationContext
    }
}