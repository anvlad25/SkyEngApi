package com.example.skyengapi.ui

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.RemoteViews
import com.example.skyengapi.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


class MyWidget : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray?
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        val scope = CoroutineScope(Dispatchers.IO)
        RemoteViews(context.packageName, R.layout.my_widget).apply {
            scope.launch {
                val pic =
                    getBitmapFromURL("https://storage.googleapis.com/gweb-uniblog-publish-prod/images/Android_symbol_green_2.max-500x500.png")
                setImageViewBitmap(R.id.widgetImage, pic)
                appWidgetManager.updateAppWidget(appWidgetIds, this@apply)
            }
        }
    }

    private fun getBitmapFromURL(src: String?): Bitmap? {
        return try {
            val url = URL(src)
            val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()
            val input: InputStream = connection.inputStream
            BitmapFactory.decodeStream(input)
        } catch (e: IOException) {
            null
        }
    }
}