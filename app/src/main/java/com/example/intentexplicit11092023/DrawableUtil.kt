package com.example.intentexplicit11092023

import android.annotation.SuppressLint
import android.content.Context

class DrawableUtil {

    companion object {
        @SuppressLint("DiscouragedApi")
        fun getImageResource(nameImageResource: String, context: Context): Int {
            return context.resources.getIdentifier(
                nameImageResource,
                "drawable",
                context.packageName
            )
        }
    }
}