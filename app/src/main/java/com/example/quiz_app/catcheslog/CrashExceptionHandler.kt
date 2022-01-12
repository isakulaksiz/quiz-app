package com.example.quiz_app.catcheslog

import android.content.Context
import android.content.Intent
import android.os.Process
import java.io.PrintWriter
import java.io.StringWriter
import java.text.SimpleDateFormat
import java.util.*
import kotlin.system.exitProcess

class CrashExceptionHandler(context: Context, c: Class<*>) : Thread.UncaughtExceptionHandler{
    private val myContext: Context = context
    private val myActivityClass: Class<*> = c

    override fun uncaughtException(thread: Thread, e: Throwable) {
        val stackTrace = StringWriter()
        e.printStackTrace(PrintWriter(stackTrace))


        val fileOperations = FileOperations(myContext)
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val curDate = sdf.format(Date())
        fileOperations.writeCrashLogFile("Date: " + curDate + "Error :" + e.localizedMessage + "E.Message :" + e.stackTraceToString())
        fileOperations.writeCrashLogFile("\n")

        val intent = Intent(myContext, myActivityClass)
        val s: String = stackTrace.toString()
        myContext.startActivity(intent)

        Process.killProcess(Process.myPid())
        exitProcess(0)
    }
}