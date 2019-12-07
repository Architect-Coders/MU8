package com.architect.coders.mu8.utils

import android.app.Application
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

class PermissionsChecker(private val application: Application, private val permission: String) {
    fun check(): Boolean = ContextCompat.checkSelfPermission(
        application,
        permission
    ) == PackageManager.PERMISSION_GRANTED
}