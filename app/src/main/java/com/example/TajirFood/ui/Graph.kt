package com.example.TajirFood.ui

import android.content.Context
import com.example.TajirFood.model.DataStoreManager

object Graph {
    lateinit var dataStoreManager: DataStoreManager

    fun provide(context: Context) {
        dataStoreManager = DataStoreManager(context)
    }
}