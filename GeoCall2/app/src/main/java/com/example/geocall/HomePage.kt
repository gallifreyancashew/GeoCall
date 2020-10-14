package com.example.geocall

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_home_page.*
import kotlinx.android.synthetic.main.fragment_home_page.*

class HomePage : AppCompatActivity() {

    val fragHomepage = HomePageFragment()
    val fragHomepageMap = HomePageMapFragment()

    var placesList = mutableListOf(
        PlacesListItem("Sample Location 1", 2154.78, 4),
        PlacesListItem("Sample Location 2", 3450.62, 3),
        PlacesListItem("Sample Location 3", 4850.51, 2),
        PlacesListItem("Sample Location 4", 5482.48, 3),
        PlacesListItem("Sample Location 5", 6780.35, 4),
        PlacesListItem("Sample Location 6", 7120.25, 3)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_frag_homepage, fragHomepageMap)
            commit()
        }
        txv_frag_homepage.text = "YOUR CURRENT LOCATION"

        btn_medical.setOnClickListener {
            openDialList()
        }
        btn_fire.setOnClickListener {
            openDialList()
        }
        btn_police.setOnClickListener {
            openDialList()
        }
        btn_crime.setOnClickListener {
            openDialList()
        }
        btn_naturaldisaster.setOnClickListener {
            openDialList()
        }
        btn_suicide.setOnClickListener {
            openDialList()
        }
        btn_childabuse.setOnClickListener {
            openDialList()
        }
        btn_pregnancy.setOnClickListener {
            openDialList()
        }
        btn_direction.setOnClickListener {
            openDialList()
        }
    }

    fun openDialList() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_frag_homepage, fragHomepage)
            commit()
        }
        supportFragmentManager.executePendingTransactions()

        val adapter = PlacesListAdapter(placesList)
        rv_placesList.adapter = adapter
        rv_placesList.layoutManager = LinearLayoutManager(this)

        txv_frag_homepage.text = "NEARBY CONTACTS"
    }
}