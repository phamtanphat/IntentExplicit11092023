package com.example.intentexplicit11092023

import android.annotation.SuppressLint
import android.content.Context

class DrawableUtil {

    companion object {
        @SuppressLint("DiscouragedApi")
        fun randomImageResource(nameImageResource: String, context: Context): Int {
            return context.resources.getIdentifier(
                nameImageResource,
                "drawable",
                context.packageName
            )
        }
    }
}