package com.shields.streamsms.service

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat

class PermissionHelper {

    fun requestPermissionIfNeeded(activity: Activity, permission: String) {
        if (ContextCompat.checkSelfPermission(activity,
                permission)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    permission)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {
                ActivityCompat.requestPermissions(activity,
                        Array(1) { Manifest.permission.READ_CONTACTS},
                        MY_PERMISSIONS_READ_SMS)
            }
        }
    }

    companion object Permissions {
        const val MY_PERMISSIONS_READ_SMS = 1
    }
}