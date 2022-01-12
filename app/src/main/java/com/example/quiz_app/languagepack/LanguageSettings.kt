package com.example.quiz_app.languagepack

import android.content.Context
import android.content.SharedPreferences
import java.util.*

class LanguageSettings(val context:Context) {
    private var sharedPreferences: SharedPreferences =
        context.getSharedPreferences("lang", Context.MODE_PRIVATE)

    fun getLanguage(): String? {
        return sharedPreferences.getString("lang", "en")
    }

    fun updateLanguages(language: String){
        val locale = Locale(language)
        Locale.setDefault(locale)
        val resources = context.resources
        val configuration = resources.configuration
        configuration.setLocale(locale)
        resources.updateConfiguration(configuration, resources.displayMetrics)
        val editor = sharedPreferences.edit()
        editor.putString("lang", language)
        editor.apply()
    }
}