package com.max.secondworld.globaltestprojectwithcustomview.core.common

import android.content.Context
import androidx.annotation.StringRes
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResourceProvider @Inject constructor(@ApplicationContext private val context: Context) {

    fun string(@StringRes id: Int): String = context.getString(id)

    fun string(@StringRes id: Int, vararg args: String?): String = context.getString(id, *args)
}