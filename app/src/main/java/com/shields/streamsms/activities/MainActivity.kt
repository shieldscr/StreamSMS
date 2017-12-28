package com.shields.streamsms.activities

import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.shields.streamsms.application.StreamSMSApplication
import com.shields.streamsms.service.PermissionHelper.Permissions
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var mainActivityImpl: MainActivityImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        StreamSMSApplication.applicationComponent.inject(this)

        mainActivityImpl.onCreate(savedInstanceState, this)
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {
        when (requestCode) {
            Permissions.MY_PERMISSIONS_READ_SMS -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mainActivityImpl.listenForSMS()
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return
            }
        }// other 'case' lines to check for other
        // permissions this app might request
    }
}
