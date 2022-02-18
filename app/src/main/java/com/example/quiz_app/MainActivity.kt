package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import com.example.quiz_app.catcheslog.CrashExceptionHandler
import com.example.quiz_app.databinding.ActivityMainBinding
import com.example.quiz_app.languagepack.LanguageSettings

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var languageSettings: LanguageSettings
    var language: String = ""
    var test: String = "quorion"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLanguage()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Thread.setDefaultUncaughtExceptionHandler(
            CrashExceptionHandler(this, MainActivity::class.java)
        )

        // main sayfasının yukarısında bildirimleri kaldır
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        binding.btnStart.setOnClickListener{
            if(binding.etName.text.toString().isEmpty())
                Toast.makeText(this, "Lütfen isim giriniz", Toast.LENGTH_SHORT).show()
            else{
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, binding.etName.text.toString())
                startActivity(intent)
                finish()
            }
        }
        binding.buttonSettings.setOnClickListener {
            val popupMenu: PopupMenu = PopupMenu(this,binding.buttonSettings,Gravity.CENTER)
            popupMenu.menuInflater.inflate(R.menu.popup_language_menu,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId){
                    R.id.btn_turkish_translate -> {
                        language = languageSettings.updateLanguages("tr").toString()
                        Toast.makeText(this@MainActivity,"Türkçe Seçildi", Toast.LENGTH_SHORT).show()
                        recreate()
                    }
                    R.id.btn_english_translate -> {
                        language = languageSettings.updateLanguages("en").toString()
                        Toast.makeText(this@MainActivity, "English choosed", Toast.LENGTH_SHORT).show()
                        recreate()
                    }
                }
                true
            })
            popupMenu.show()
        }
    }

    private fun initLanguage() {
        languageSettings = LanguageSettings(this)
        language = languageSettings.getLanguage().toString()
        languageSettings.updateLanguages(language)
    }
}
