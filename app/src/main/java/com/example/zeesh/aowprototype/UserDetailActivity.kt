package com.example.zeesh.aowprototype

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_user_detail.*
import kotlinx.android.synthetic.main.content_user_detail.*

class UserDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(android.R.drawable.arrow_up_float)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val data = mutableListOf<Any>()
        data.add(TextNote("PERSONAL INFO"))
        data.add(DoubleValueCard("Nauman Ali", "Name"))
        data.add(DoubleValueCard("naumanasghar@gmail.com", "Email"))
        data.add(DoubleValueCard("090078601", "Phone"))
        data.add(TextNote("BRAND DETAILS"))
        data.add(DoubleValueCard("MICROSOFT", "Brand"))
        data.add(DoubleValueCard("Bill Gates", "Owner"))
        data.add(DoubleValueCard("New York", "Location"))
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = UserDetalAdapter(this, data)
    }


    class UserDetalAdapter(val context: Context, val dataset: MutableList<Any>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
            if (holder==null){

            }
            else if (holder is TextNoteViewHolder){
                holder.bind(dataset[position] as TextNote)
            }
            else if (holder is DoubleValueViewHolder){
                val value = dataset[position] as DoubleValueCard
                holder.bind(value)
                holder.itemView.findViewById<CardView>(R.id.iv_usr_prfl_cardview)?.setOnClickListener {
                    val builder = AlertDialog.Builder(context)
                    val view = LayoutInflater.from(context).inflate(R.layout.popup_user_profile_change_value, null, false)
                    val lableTIL = view?.findViewById<TextInputLayout>(R.id.pv_usr_prfl_chng_vl_lable)
//                    val editText = view?.findViewById<EditText>(R.id.pv_usr_prfl_chng_vl_et)
                    lableTIL?.hint = value.subtitle
                    lableTIL?.editText?.setText(value.title)

                    builder.setView(view)
                    builder.setPositiveButton("CHANGE", {di, id->})
                    builder.setNegativeButton("CANCEL", {di, id->
                        di.dismiss()
                    })
                    builder.show()
                }
            }
        }
        override fun getItemCount() = dataset.size
        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
            val inflator = LayoutInflater.from(context)
            when(viewType){
                VIEW_TYPE_TEXT_NOTE->{
                    return TextNoteViewHolder(inflator.inflate(R.layout.item_view_text_note, parent, false))
                }
                VIEW_TYPE_DOUBLE_VALUE_CARD->{
                    return DoubleValueViewHolder(inflator.inflate(R.layout.item_view_double_value, parent, false))
                }
                VIEW_TYPE_ERROR->{}
            }
            return null
        }
        override fun getItemViewType(position: Int): Int {
            val item = dataset[position]
            if (item is TextNote)
                return VIEW_TYPE_TEXT_NOTE
            else if (item is DoubleValueCard)
                return VIEW_TYPE_DOUBLE_VALUE_CARD
            else return VIEW_TYPE_ERROR
        }
    }



    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            android.R.id.home-> {
                finish()
                true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
