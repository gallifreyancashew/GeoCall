package com.example.geocall

import android.os.AsyncTask
import com.google.android.gms.maps.GoogleMap
import java.io.IOException

class GetNearbyPlaces: AsyncTask<Object, String, String>() {
    private lateinit var googlePlaceData: String
    private lateinit var url: String
    private lateinit var googleMap: GoogleMap

    override fun doInBackground(vararg params: Object?): String {
        googleMap = params[0] as GoogleMap
        url = params[1] as String

        val downloadUrl = DownloadUrl()
        try {
            googlePlaceData = downloadUrl.ReadURL(url)
        } catch (e: IOException) {

        }

        return googlePlaceData
    }

    override fun onPostExecute(result: String?) {
        var nearbyPlacesList: List<HashMap<String, String>>? = null
        val dataParser = DataParser()
        nearbyPlacesList = result?.let { dataParser.parse(it) }

        if (nearbyPlacesList != null) {
            displayNearbyPlaces(nearbyPlacesList)
        }
    }

    private fun displayNearbyPlaces(nearbyPlacesList: List<HashMap<String, String>>) {
        for (i in nearbyPlacesList.indices) {
            val googleNearbyPlace: HashMap<String, String> = nearbyPlacesList.get(i)
            val nameOfPlace: String? = googleNearbyPlace.get("place_name")
            val vicinity: String? = googleNearbyPlace.get("vicinity")
            val lat: Double? = googleNearbyPlace.get("lat")?.toDouble()
            val lng: Double? = googleNearbyPlace.get("lng")?.toDouble()
        }
    }
}