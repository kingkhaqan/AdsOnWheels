package com.example.zeesh.aowprototype

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_card_start_campeign.setOnClickListener {
            startActivity(Intent(this, EstimationActivity::class.java))
        }
        main_card_driver_list.setOnClickListener {
            startActivity(Intent(this, DriverListActivity::class.java))
        }
    }
}
