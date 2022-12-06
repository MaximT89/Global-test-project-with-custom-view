package com.max.secondworld.globaltestprojectwithcustomview.ui.custom_view

import android.content.Context
import androidx.core.content.ContextCompat
import com.max.secondworld.globaltestprojectwithcustomview.R

object GradientCreator {

    // -1000 .. -30
    fun getColdMax(context: Context): IntArray = intArrayOf(
        ContextCompat.getColor(context, R.color.medium_slate_blue),
        ContextCompat.getColor(context, R.color.blue),
        ContextCompat.getColor(context, R.color.dark_blue)
    )


    // -29 .. -10
    fun getCold(context: Context) : IntArray = intArrayOf(
    ContextCompat.getColor(context, R.color.light_sky_blue),
    ContextCompat.getColor(context, R.color.medium_slate_blue),
    ContextCompat.getColor(context, R.color.blue)
    )

    // -9 .. +2
    fun getZero(context: Context): IntArray = intArrayOf(
        ContextCompat.getColor(context, R.color.aqua),
        ContextCompat.getColor(context, R.color.light_sky_blue),
        ContextCompat.getColor(context, R.color.medium_slate_blue)
    )

    // +2 .. +10
    fun getNormal(context: Context): IntArray = intArrayOf(
        ContextCompat.getColor(context, R.color.dark_khaki),
        ContextCompat.getColor(context, R.color.khaki),
        ContextCompat.getColor(context, R.color.aqua)
    )

    // +11 .. +25
    fun getWarm(context: Context): IntArray = intArrayOf(
        ContextCompat.getColor(context, R.color.dark_orange),
        ContextCompat.getColor(context, R.color.yellow),
        ContextCompat.getColor(context, R.color.dark_khaki)
    )

    // +26 .. +1000
    fun getHot(context: Context): IntArray = intArrayOf(
        ContextCompat.getColor(context, R.color.dark_red),
        ContextCompat.getColor(context, R.color.orange_red),
        ContextCompat.getColor(context, R.color.dark_orange)
    )
}