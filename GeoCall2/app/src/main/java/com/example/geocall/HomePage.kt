package com.example.geocall

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_home_page.*
import kotlinx.android.synthetic.main.fragment_home_page.*

class HomePage : AppCompatActivity() {

    val fragHomepage = HomePageFragment()
    val fragHomepageMap = HomePageMapFragment()
    private lateinit var btn_dialNearest: ImageButton

    var placesList = mutableListOf(
        PlacesListItem("HOSPITAL", "Baguio General Hospital and Medical Center", "(074) 661 7910", 16.401073, 120.595993, 3.5),
        PlacesListItem("HOSPITAL", "Notre Dame de Chartres Hospital", "(074) 619 8530", 16.415836, 120.598862, 3.0),
        PlacesListItem("HOSPITAL", "Saint Louis University Hospital of the Sacred Heart", "(074) 442 5700", 16.417212, 120.597603, 3.0)
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
            placesList = mutableListOf(
                PlacesListItem("HOSPITAL", "Baguio General Hospital and Medical Center", "(074) 661 7910", 16.401073, 120.595993, 3.5),
                PlacesListItem("HOSPITAL", "Notre Dame de Chartres Hospital", "(074) 619 8530", 16.415836, 120.598862, 3.0),
                PlacesListItem("HOSPITAL", "Saint Louis University Hospital of the Sacred Heart", "(074) 442 5700", 16.417212, 120.597603, 3.0),

                PlacesListItem("HOSPITAL", "Baguio General Hospital and Medical Center", "(074) 661 7910", 16.401073, 120.595993, 3.5),
                PlacesListItem("HOSPITAL", "Notre Dame de Chartres Hospital", "(074) 619 8530", 16.415836, 120.598862, 3.0),
                PlacesListItem("HOSPITAL", "Saint Louis University Hospital of the Sacred Heart", "(074) 442 5700", 16.417212, 120.597603, 3.0)
            )
            openDialList()
        }
        btn_fire.setOnClickListener {
            placesList = mutableListOf(
                PlacesListItem("FIRESTATION", "Baguio City Central Fire Station", "(074) 442 2222", 16.414759, 120.591726, 2.8),
                PlacesListItem("FIRESTATION", "Aurora Hill Fire Station", "(074) 661 7169", 16.426513, 120.606216, 3.0),
                PlacesListItem("FIRESTATION", "Irisan Fire Station", "(074) 442 4357", 16.423339, 120.557250, 5.0)
            )
            openDialList()
        }
        btn_police.setOnClickListener {
            placesList = mutableListOf(
                PlacesListItem("POLICESTATION", "Police Station 1", "(074) 424 2697", 16.412445, 120.579335, 2.8),
                PlacesListItem("POLICESTATION", "Police Station 6", "(074) 300 9116", 16.426227, 120.606157, 0.0),
                PlacesListItem("POLICESTATION", "Police Station 7", "(074) 443 9117", 16.414167, 120.592194, 4.0)
            )
            openDialList()
        }
        btn_crime.setOnClickListener {
            placesList = mutableListOf(
                PlacesListItem("CRIME", "Police Station 1", "(074) 424 2697", 16.412445, 120.579335, 2.8),
                PlacesListItem("CRIME", "Police Station 6", "(074) 300 9116", 16.426227, 120.606157, 0.0),
                PlacesListItem("CRIME", "Police Station 7", "(074) 443 9117", 16.414167, 120.592194, 4.0)
            )
            openDialList()
        }
        btn_naturaldisaster.setOnClickListener {
            placesList = mutableListOf(
                PlacesListItem("NATURALDISASTER", "City Disaster Risk Reduction Management Council", "(074) 442 1900", 16.414508, 120.591605, 3.5),
                PlacesListItem("NATURALDISASTER", "BB-PICAG", "(074) 442 8911", 16.411754, 120.598976, 5.0),
                PlacesListItem("NATURALDISASTER", "Bureau of Fire Protection - Baguio", "(074) 305 2669", 16.383854, 120.604171, 0.0)
            )
            openDialList()
        }
        btn_suicide.setOnClickListener {
            placesList = mutableListOf(
                PlacesListItem("SUICIDE", "Department of Social Welfare and Development - CAR", "(074) 661 0430", 16.408521, 120.600893, 3.7),
                PlacesListItem("SUICIDE", "Baguio General Hospital Mental Health Building", "(074) 661 7910", 16.400934, 120.595485, 5.0)
            )
            openDialList()
        }
        btn_childabuse.setOnClickListener {
            placesList = mutableListOf(
                PlacesListItem("CHILDABUSE", "Women and Children Protection Desk", "(02) 422 8600", 16.410907, 120.597067, 4.0),
                PlacesListItem("CHILDABUSE", "Child and Family Service Philippines", "(074) 442 3800", 16.424738, 120.588999, 4.9),
                PlacesListItem("CHILDABUSE", "Police Station 7", "(074) 443 9117", 16.414167, 120.592194, 4.0)
            )
            openDialList()
        }
        btn_pregnancy.setOnClickListener {
            placesList = mutableListOf(
                PlacesListItem("PREGNANCY", "Our Lady of Lourdes Birthing Clinic - MCP", "(02) 446 2017", 16.410822, 120.581801, 0.0),
                PlacesListItem("PREGNANCY", "Notre Dame de Chartres Hospital", "(074) 619 8530", 16.415836, 120.598862, 3.0),
                PlacesListItem("PREGNANCY", "Baguio General Hospital and Medical Center", "(074) 661 7910", 16.401073, 120.595993, 3.5)
            )
            openDialList()
        }
        btn_direction.setOnClickListener {
            placesList = mutableListOf(
                PlacesListItem("DIRECTIONS", "Tourist Police Unit", "(074) 424 0718", 16.411258, 120.592731, 0.0),
                PlacesListItem("DIRECTIONS", "Department of Tourism - Cordillera Administrative Region", "(074) 442 7014", 16.406690, 120.598067, 3.4),
                PlacesListItem("DIRECTIONS", "Baguio City Tourism & Special Events Office", "(074) 442 1006", 16.408179, 120.595390, 0.0)
            )
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

        btn_dialNearest = findViewById<ImageButton>(R.id.btn_dialnearest)
        btn_dialNearest.setOnClickListener{
            val intentCall = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + placesList[0].contact.toString()))
            startActivity(intentCall)
        }
    }
}