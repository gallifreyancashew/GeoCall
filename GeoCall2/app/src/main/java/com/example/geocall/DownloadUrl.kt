package com.example.geocall

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.nio.Buffer

class DownloadUrl {
    fun ReadURL(placeURL: String): String {
        var data: String = ""
        var inputStream: InputStream? = null
        var httpURLConnection: HttpURLConnection? = null

        try {
            val url = URL(placeURL)
            httpURLConnection = url.openConnection() as HttpURLConnection
            httpURLConnection.connect()

            inputStream = httpURLConnection.inputStream
            val bufferedReader = BufferedReader(InputStreamReader(inputStream))
            val stringBuffer = StringBuffer()

            val line: String = ""
            while ((line == bufferedReader.readLine()) != null) {
                stringBuffer.append(line)
            }

            data = stringBuffer.toString()
            bufferedReader.close()
        } catch (e: MalformedURLException) {

        } catch (e: IOException) {

        } finally {
            inputStream?.close()
            httpURLConnection?.disconnect()
        }

        return data

    }
}