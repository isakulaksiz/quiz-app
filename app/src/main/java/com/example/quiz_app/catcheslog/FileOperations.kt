package com.example.quiz_app.catcheslog

import android.content.Context
import android.util.Log
import java.io.File

class FileOperations(private val context: Context) {

    fun writeCrashLogFile(error: String){
        //TODO: fix path
        val directory = File(context.getExternalFilesDir(null)?.absolutePath + "/Android/data/isa/quiz-app/files/")

        if(!directory.isDirectory)
            Log.e("CRASH-FILE","Directory already created!")
        else{
            directory.mkdir()
            Log.e("CRASH-FILE", "Directory created!")
        }
        val crashLog = "crash_log.txt"
        val file = File(context.getExternalFilesDir(null)?.absolutePath, crashLog)
        file.appendText(error + System.lineSeparator())
    }
}
