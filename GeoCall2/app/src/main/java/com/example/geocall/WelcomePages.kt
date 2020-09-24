package com.example.geocall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_welcome_pages.*
import me.relex.circleindicator.CircleIndicator3

class WelcomePages : AppCompatActivity() {

    private var titlesList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_pages)

        postToList()

        view_pager2.adapter = ViewPagerAdapter(titlesList,descList,imagesList)
        view_pager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(view_pager2)
    }

    private fun addToList(title:String, description:String, image:Int) {
        titlesList.add(title)
        descList.add(description)
        imagesList.add(image)
    }

    private fun postToList() {
        addToList("Welcome to",
            "Swipe to get started!",
            R.drawable.geocall_embossed)
        addToList("All-in-One Hotline Service",
            "GeoCall compiles different hotline services like police stations, hospitals, suicide and crisis intervention, and many mor ethat are near your location.\\n\\nYou can also add personal emergency contacts later on in Settings.",
            R.drawable.iphone)
        addToList("Geographically-based",
            "Based on your location, GeoCall can look through the database for the nearest appropriate hotline services which you can choose from.\\n\\nYou also set the application to automatically call the nearest station instead in Settings.",
            R.drawable.geographically_based)
        addToList("Shake to Activate",
            "In the event of emergencies, GeoCall can be set to be activated through shaking the phone. Upon activation, GeoCall lists the numbers of nearby stations in a numerical order from which you can choose from.",
            R.drawable.shake_to_activate)
    }
}