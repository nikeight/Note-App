package com.plcoding.cleanarchitecturenoteapp

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import dagger.hilt.android.testing.HiltTestApplication

/**
 * Mocking our Application class as well
 * Where we provide our own defined Application Class
 */
class HiltTestRunner : AndroidJUnitRunner() {

    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        /**
         * ` HiltTestApplication::class ` is being provided by the Hilt Library only
         */
        return super.newApplication(cl, HiltTestApplication::class.java.name, context)
    }
}