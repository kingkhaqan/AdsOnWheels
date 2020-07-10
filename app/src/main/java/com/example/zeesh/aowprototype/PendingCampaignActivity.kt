package com.example.zeesh.aowprototype

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_pending_campaign.*

class PendingCampaignActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pending_campaign)

        val forwardArrow = BitmapFactory.decodeResource(resources, R.drawable.ic_arrow_forward_black_24dp)

        val data = mutableListOf<Any>()
        data.add(TextNote("The requested ad is pending"))
        data.add(ImageSingleValue(null, "USER INFO", forwardArrow))
        data.add(ImageSingleValue(BitmapFactory.decodeResource(resources, R.drawable.ic_branding_watermark_black_24dp), "BRAND DETAILS", forwardArrow))
        data.add(ImageSingleValue(BitmapFactory.decodeResource(resources, R.drawable.ic_local_taxi_black_24dp), "CAMPAIGN DETAILS", forwardArrow))
        data.add(ImageSingleValue(BitmapFactory.decodeResource(resources, R.drawable.ic_branding_watermark_black_24dp), "VARIFICATION", forwardArrow))
        data.add(ImageSingleValue(BitmapFactory.decodeResource(resources, R.drawable.ic_person_blue_24dp), "DRIVERS LIST", forwardArrow))

       }

    class PendingCampaignActivityAdapter(val context: Context, val dataset: MutableList<Any>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
            val inflater = LayoutInflater.from(context)
            when(viewType){
                VIEW_TYPE_TEXT_NOTE->{inflater.inflate(R.layout.item_view_text_note, parent, false)}
                VIEW_TYPE_IMAGE_SINGLE_VALUE->{inflater.inflate(R.layout.item_view_image_single_value, parent, false)}
            }
            return ErrorViewHolder(null)
        }
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
            when{
                holder == null->{}
                holder is TextNoteViewHolder->{
                    holder.bind(dataset[position] as TextNote)
                }
                holder is ImageSingleValueViewHolder->{
                    holder.bind(dataset[position] as ImageSingleValue)
                }
            }
        }
        override fun getItemCount() = dataset.size
        override fun getItemViewType(position: Int): Int {
            val item = dataset[position]
            when{
                item is TextNote-> return VIEW_TYPE_TEXT_NOTE
                item is ImageSingleValue-> return VIEW_TYPE_IMAGE_SINGLE_VALUE
            }
            return VIEW_TYPE_ERROR
        }
    }


}
