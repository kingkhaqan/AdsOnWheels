package com.example.zeesh.aowprototype

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_pending_campaign.*

class CampaignListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_campaign_list)


        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.logo_apple)
        val bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.logo_google)
        val bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.logo_microsoft)

        recyclerview.layoutManager = LinearLayoutManager(this)
        val data = mutableListOf<ImageCard>()
        data.add(ImageCard(getResizedBitmap(bitmap, AD_CARD_IMAGE_SIZE), false, DoubleValueCard("Apple", "Steve Jobs", "2 weeks ago")))
        data.add(ImageCard(getResizedBitmap(bitmap1, AD_CARD_IMAGE_SIZE), false, DoubleValueCard("Google", "Williams", "3 weeks ago")))
        data.add(ImageCard(getResizedBitmap(bitmap2, AD_CARD_IMAGE_SIZE), false, DoubleValueCard("Microsoft", "Bill Gates", "2 months ago")))
        recyclerview.adapter = CampaignCardAdapter(this, data)

    }

    class CampaignCardAdapter(val context: Context, val dataset: MutableList<ImageCard>): RecyclerView.Adapter<ImageCardViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ImageCardViewHolder {
            return ImageCardViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view_image_card, parent, false))
        }
        override fun onBindViewHolder(holder: ImageCardViewHolder?, position: Int) {
            holder?.bind(dataset[position])
            holder?.itemView?.setOnClickListener {
                context.startActivity(Intent(context, PendingCampaignActivity::class.java))
            }
        }
        override fun getItemCount() = dataset.size
    }
}
