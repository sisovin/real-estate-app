package com.example.realestate.core.util

import android.content.Context

object ResourceUtil {
    fun getDrawableId(context: Context, name: String): Int {
        return context.resources.getIdentifier(name, "drawable", context.packageName)
    }
}
