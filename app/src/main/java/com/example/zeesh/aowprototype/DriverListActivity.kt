package com.example.zeesh.aowprototype

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_driver_list.*

class DriverListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_list)
        actionBar?.setHomeButtonEnabled(true)

        val data = mutableListOf<ImageCard>()
        data.add(ImageCard(null, false, DoubleValueCard("Nauman Ali", "090078601")))
        data.add(ImageCard(null, false, DoubleValueCard("Abdullah Sheikh", "541546162")))
        data.add(ImageCard(null, false, DoubleValueCard("Umair Ashraf", "1344611031")))

//        val arr = arrayListOf<Driver>()
//        arr.add(Driver("Nauman Asghar", "090078601"))
//        arr.add(Driver("Umair Ashraf", "03124589658"))
//        arr.add(Driver("Abdulllah Sheikh ", "03074517829"))
//        driver_list_recyclerview.layoutManager = LinearLayoutManager(this)
//        driver_list_recyclerview.adapter = DriverListAdapter(this, arr)
//        driver_list_recyclerview.adapter.notifyDataSetChanged()

    }




    class DriverListAdapter(val context: Context, val dataset: MutableList<ImageCard>): RecyclerView.Adapter<ImageCardViewHolder>() {
        override fun onBindViewHolder(holder: ImageCardViewHolder?, position: Int) {
            holder?.bind(dataset[position])
            holder?.itemView?.setOnClickListener {
                context.startActivity(Intent(context, UserDetailActivity::class.java))
            }
        }
        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ImageCardViewHolder {
            return ImageCardViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view_image_card, parent, false))
        }
        override fun getItemCount() = dataset.size
    }


//    data class Driver(val name: String, val phone: String)
//    class DriverListAdapter(val context: Context, val dataset: ArrayList<Driver>): RecyclerView.Adapter<DriverListViewHolder>() {
//        override fun getItemCount() = dataset.size
//
//        override fun onBindViewHolder(holder: DriverListViewHolder?, position: Int) {
//            val driver = dataset[position]
//            holder?.bind(driver)
//            holder?.itemView?.setOnClickListener {
//                context.startActivity(Intent(context, UserDetailActivity::class.java))
//            }
//        }
//
//        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DriverListViewHolder {
//            return DriverListViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view_driver_list, null, false))
//        }
//    }
//
//    class DriverListViewHolder(v: View?): RecyclerView.ViewHolder(v){
//        val name: TextView?
//        val phone: TextView?
//        init {
//            name = v?.findViewById(R.id.iv_dl_name)
//            phone = v?.findViewById(R.id.iv_dl_phone)
//        }
//        fun bind(driver: Driver){
//            name?.text = driver.name
//            phone?.text = driver.phone
//        }
//    }
}
