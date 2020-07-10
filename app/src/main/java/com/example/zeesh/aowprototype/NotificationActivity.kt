package com.example.zeesh.aowprototype

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.TaskStackBuilder
import android.support.v7.app.NotificationCompat
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

//        actionBar?.setDisplayShowHomeEnabled(true)
        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val data = mutableListOf<DoubleValueCard>()
        data.add(DoubleValueCard("Requested for an Ad Campaign for Microsoft" , "Bill Gates", "2 hours ago"))
        notification_recyclerview.layoutManager = LinearLayoutManager(this)
        notification_recyclerview.adapter = NotificationAdapter(this, data)

//        (supportActionBar as Toolbar)?.setNavigationIcon(R.drawable.ic_attach_file_black_24dp)

//        val notifications = mutableListOf<NotificationItem>()
//        notifications.add(NotificationItem("Plz deposit advance on these details to start your campeign", System.currentTimeMillis(), "1002"))
//
//        notifications.add(NotificationItem("You have requested for an Ad Campeign.", System.currentTimeMillis(), "1001") )
//        notifications.add(NotificationItem("Your request has been seen by Admin. You'll be notified soon", System.currentTimeMillis(), "1003"))
//        notification_recyclerview.layoutManager = LinearLayoutManager(this)
//        notification_recyclerview.adapter = NotificationAdapter(this, notifications)
//        notification_recyclerview.adapter.notifyDataSetChanged()

    }

    class NotificationAdapter(val context: Context, val dataset: MutableList<DoubleValueCard>): RecyclerView.Adapter<DoubleValueViewHolder>() {
        override fun getItemCount() = dataset.size
        override fun onBindViewHolder(holder: DoubleValueViewHolder?, position: Int) {
            holder?.bind(dataset[position])
            holder?.itemView?.setOnClickListener {
                context.startActivity(Intent(context, ConfirmCompaignActivity::class.java))
            }
        }
        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DoubleValueViewHolder {
            return DoubleValueViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view_double_value, parent, false))
        }
    }

    private fun getParentActivityIntentImplement(): Intent?{
        val parentIntent = getIntent()
        val parentClass = parentIntent.getStringExtra(PARENT_CLASS_NAME_EXTRA)
        try {
            val className = "com.example.zeesh.aowprototype.DashboardActivity"
            val intent = Intent(this, Class.forName(className))
            Toast.makeText(this, "class found: $parentClass", Toast.LENGTH_SHORT).show()

            return intent
        }
        catch (e: Exception){

            Toast.makeText(this, "class not found: $parentClass", Toast.LENGTH_SHORT).show()

            return null
        }
    }
    override fun getParentActivityIntent(): Intent? {
        return getParentActivityIntentImplement()
    }

    override fun getSupportParentActivityIntent(): Intent? {
        return getParentActivityIntentImplement()
    }

//    data class NotificationItem(val title: String, val time: Long, val notificationId: String)
//    class NotificationAdapter(val context: Context, val dataset: MutableList<NotificationItem>): RecyclerView.Adapter<NotificationViewHolder>() {
//        override fun onBindViewHolder(holder: NotificationViewHolder?, position: Int) {
//            holder?.bind(dataset[position])
//            holder?.itemView?.findViewById<CardView>(R.id.iv_notifications_card_notification)?.setOnClickListener {
//
//                context.startActivity(Intent(context, ConfirmCompaignActivity::class.java))
//            }
//        }
//
//        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NotificationViewHolder {
//            val view = LayoutInflater.from(context).inflate(R.layout.item_view_notification, parent, false)
//            return NotificationViewHolder(view)
//        }
//
//        override fun getItemCount() = dataset.size
//    }
//
//    class NotificationViewHolder(v: View?): RecyclerView.ViewHolder(v){
//        val titleTV: TextView?
//        val subtitleTV: TextView?
//        init {
//            titleTV = v?.findViewById(R.id.iv_notification_title)
//            subtitleTV = v?.findViewById(R.id.iv_notification_subtitle)
//        }
//
//        fun bind(notificatio: NotificationItem){
//            titleTV?.text = notificatio.title
//            subtitleTV?.text = getTimeString(notificatio.time)
//        }
//
//        fun getTimeString(time: Long): String{
//            return "Two hours ago"
//        }
//    }

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


