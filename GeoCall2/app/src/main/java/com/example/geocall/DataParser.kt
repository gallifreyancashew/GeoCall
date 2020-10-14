package com.example.geocall

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class DataParser {
    private fun getNearbyPlace(googlePlaceJSON: JSONObject): HashMap<String, String> {
        val googlePlaceMap: HashMap<String, String> = HashMap<String, String>()
        var nameOfPlace: String = "-NA-"
        var vicinity: String = "-NA-"
        var latitude: String = ""
        var longitude: String = ""
        var reference: String = ""

        try {
            if (!googlePlaceJSON.isNull("name")) {
                nameOfPlace = googlePlaceJSON.getString("name")
            }
            if (!googlePlaceJSON.isNull("vicinity")) {
                vicinity = googlePlaceJSON.getString("vicinity")
            }
            latitude = googlePlaceJSON.getJSONObject("geometry").getJSONObject("location").getString("lat");
            longitude = googlePlaceJSON.getJSONObject("geometry").getJSONObject("location").getString("lng");
            reference = googlePlaceJSON.getString("reference")

            googlePlaceMap.put("place_name", nameOfPlace)
            googlePlaceMap.put("vicinity", vicinity)
            googlePlaceMap.put("lat", latitude)
            googlePlaceMap.put("lng", longitude)
            googlePlaceMap.put("reference", reference)
        } catch (e: JSONException) {

        }

        return googlePlaceMap
    }

    private fun getNearbyPlaces(jsonArray: JSONArray): List<HashMap<String, String>> {
        val counter: Int = jsonArray.length()

        val nearbyPlacesList: MutableList<HashMap<String, String>> = ArrayList<HashMap<String, String>>()
        var nearbyPlaceMap: HashMap<String, String>? = null

        for (i in 0 until counter) {
            try {
                nearbyPlaceMap = getNearbyPlace(jsonArray.get(i) as JSONObject)
                nearbyPlacesList.add(nearbyPlaceMap)
            } catch (e: JSONException) {

            }
        }

        return nearbyPlacesList
    }

    fun parse(jsonData: String): List<HashMap<String, String>> {
        var jsonArray: JSONArray? = null
        var jsonObject: JSONObject

        try {
            jsonObject = JSONObject(jsonData)
            jsonArray = jsonObject.getJSONArray("results")
        } catch (e: JSONException) {

        }

        return getNearbyPlaces(jsonArray!!)
    }
}