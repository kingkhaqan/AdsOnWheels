package com.example.zeesh.aowprototype

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_estimation.*

class EstimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        actionBar?.setDisplayHomeAsUpEnabled(true)

        setContentView(R.layout.activity_estimation)


        estimation_submit.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setView(LayoutInflater.from(this).inflate(R.layout.estimation_confirm, null, false))

            builder.setPositiveButton("CONFIRM", {id, di->
//                startActivity(Intent(this, DashboardActivity::class.java))
                finish()
            })
            builder.setNegativeButton("Cancel", {di, id->
                di.dismiss()
            })
            builder.show()
        }


        estimation_btn_from.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val v = LayoutInflater.from(this).inflate(R.layout.popup_datepicker, null, false)
            val picker = v.findViewById<DatePicker>(R.id.popup_datepicker)

            builder.setView(v)
            builder.setPositiveButton("ok", {di, id->
                val dateString = "${picker.month}/${picker.dayOfMonth}/${picker.year}"
                estimation_btn_from.text = dateString
            })
            builder.setNegativeButton("cancel" , {di, id->
                di.dismiss()
            })
            builder.show()
        }

        estimation_btn_to.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val v = LayoutInflater.from(this).inflate(R.layout.popup_datepicker, null, false)
            val picker = v.findViewById<DatePicker>(R.id.popup_datepicker)

            builder.setView(v)
            builder.setPositiveButton("ok", {di, id->
                val dateString = "${picker.month}/${picker.dayOfMonth}/${picker.year}"
                estimation_btn_to.text = dateString
            })
            builder.setNegativeButton("cancel" , {di, id->
                di.dismiss()
            })
            builder.show()
        }

    }

    fun dialogBuilder(context: Context, layout: Int): AlertDialog.Builder{
        val builder = AlertDialog.Builder(this)
        builder.setView(LayoutInflater.from(this).inflate(layout, null, false))

        return builder
    }
}
