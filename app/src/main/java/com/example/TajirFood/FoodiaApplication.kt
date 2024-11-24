package com.example.TajirFood

import android.app.Application
import com.example.TajirFood.ui.Graph

class FoodiaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(context = this)
    }
}