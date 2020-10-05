package com.example.geocall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.view.isVisible
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import kotlinx.android.synthetic.main.activity_welcome_pages.*
import me.relex.circleindicator.CircleIndicator3

class WelcomePages : AppCompatActivity() {

    private var titlesList = mutableListOf<String>()
    private var detailsList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()
    private var btnGotIt : Button ?= null
    private var indicator : CircleIndicator3 ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_pages)

        postToList()

        view_pager2.adapter = ViewPagerAdapter(titlesList, detailsList, imagesList)
        btnGotIt = findViewById<Button>(R.id.btn_gotit)

        indicator = findViewById<CircleIndicator3>(R.id.indicator)
        this.indicator?.setViewPager(view_pager2)

        setCurrentOnboardingIndicator(0)

        view_pager2.registerOnPageChangeCallback(object: OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentOnboardingIndicator(position)
            }
        })

        val gotIt = findViewById<Button>(R.id.btn_gotit)
        gotIt.setOnClickListener{
            val intent = Intent(this, HomePage::class.java)
            //val msg = intent.putExtra("name", username.text.toString())
            startActivity(intent)
        }
    }

    private fun addToList(title: String, details: String, image:Int) {
        titlesList.add(title)
        detailsList.add(details)
        imagesList.add(image)
    }

    private fun postToList() {
        addToList("Welcome",
            "Swipe to get started!",
            R.drawable.geocall_embossed)
        addToList("All-in-One Hotline Service",
            "GeoCall compiles different hotline services like police stations, hospitals, suicide and crisis intervention," +
                    " and many more that are near your location.\n\nYou can also add personal emergency contacts later on in Settings.",
            R.drawable.i_phone)
        addToList("Geographically-based",
            "Based on your location, GeoCall can look through the database for the nearest appropriate hotline services which" +
                    "you can choose from.\n\nYou also set the application to automatically call the nearest station instead in Settings.",
            R.drawable.geographically_based)
        addToList("Shake to Activate",
            "In the event of emergencies, GeoCall can be set to be activated through shaking the phone. Upon activation," +
                    " GeoCall lists the numbers of nearby stations in a numerical order from which you can choose from.",
            R.drawable.shake_to_activate)
    }

    private fun setCurrentOnboardingIndicator(index: Int) {
        if (index == view_pager2.adapter?.itemCount?.minus(1)) {
            btnGotIt?.visibility = View.VISIBLE
        } else {
            btnGotIt?.visibility = View.INVISIBLE
        }
    }
}