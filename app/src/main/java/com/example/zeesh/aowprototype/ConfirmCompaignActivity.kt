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
import kotlinx.android.synthetic.main.activity_confirm_compaign.*

class ConfirmCompaignActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_compaign)

        recyclerview.layoutManager = LinearLayoutManager(this)
//        val data = mutableListOf<Any>()
//        data.add(EstimationCard(5, "01/20/2019", "01/31/2019", "Lahore", Amount('$', 210, 54)))
//        data.add(getResizedBitmap(BitmapFactory.decodeResource(resources, R.drawable.image_receipt), AD_CARD_IMAGE_SIZE))
//        data.add("Check Profile")
//        data.add("Confirm")
//        recyclerview.adapter = CampaignConfirmAdapter(this, data)

        val data = mutableListOf<Any>()
        data.add(ImageCard(getResizedBitmap(BitmapFactory.decodeResource(resources, R.drawable.image_receipt), AD_CARD_IMAGE_SIZE), true, DoubleValueCard("Apple", "Steve Jobs")))
        data.add(TextNote("First, head back to the Sound & notification settings screen. Next, scroll to the bottom and tap App notifications, then tap on the app for which you want to adjust notification settings."))
        data.add(DoubleValueCard("15", "Cars"))
        data.add(DoubleValueCard("01/20/2019", "From"))
        data.add(DoubleValueCard("01/31/2019", "To"))
        data.add(DoubleValueCard("Lahore", "City"))
        data.add(DoubleValueCard("J.", "Brand"))
        data.add(ImageDoubleValue(BitmapFactory.decodeResource(resources, R.drawable.ic_person_blue_24dp), "Steve Jobs","User"))
        data.add(ButtonText("Add in Pending"))

        recyclerview.adapter = RecyclerViewAdapter(this, data)
    }


    class ConfirmCampaignAdapter(val context: Context, val dataset: MutableList<Any>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun getItemCount() = dataset.size
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
            when{
                holder is ImageCardViewHolder->{holder.bind(dataset[position] as ImageCard)}
                holder is TextNoteViewHolder->{holder.bind(dataset[position] as TextNote)}
                holder is DoubleValueViewHolder->{holder.bind(dataset[position] as DoubleValueCard)}
                holder is ImageDoubleValueViewHolder->{holder.bind(dataset[position] as ImageDoubleValue)}
                holder is ButtonViewHolder->{holder.bind(dataset[position] as ButtonText)
                holder.itemView.setOnClickListener {
                    context.startActivity(Intent(context, PendingCampaignActivity::class.java))
                }}
            }
        }
        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
            val inflater = LayoutInflater.from(context)
            when(viewType){
                VIEW_TYPE_IMAGE_CARD->{return ImageCardViewHolder(inflater.inflate(R.layout.item_view_image_card, parent, false))}
                VIEW_TYPE_TEXT_NOTE->{return ImageCardViewHolder(inflater.inflate(R.layout.item_view_text_note, parent, false))}
                VIEW_TYPE_DOUBLE_VALUE_CARD->{return ImageCardViewHolder(inflater.inflate(R.layout.item_view_double_value, parent, false))}
                VIEW_TYPE_IMAGE_DOUBLE_VALUE->{return ImageCardViewHolder(inflater.inflate(R.layout.item_view_image_doubl_value, parent, false))}
                VIEW_TYPE_BUTTON->{return ImageCardViewHolder(inflater.inflate(R.layout.item_view_button, parent, false))}
            }

            return ErrorViewHolder(null)
        }
        override fun getItemViewType(position: Int): Int {
            val dataObj = dataset[position]
            when{
                dataObj is ImageCard-> return VIEW_TYPE_IMAGE_CARD
                dataObj is TextNote-> return VIEW_TYPE_TEXT_NOTE
                dataObj is DoubleValueCard-> return VIEW_TYPE_DOUBLE_VALUE_CARD
                dataObj is ImageDoubleValue-> return VIEW_TYPE_IMAGE_DOUBLE_VALUE
                dataObj is ButtonText-> return VIEW_TYPE_BUTTON
                else -> return VIEW_TYPE_ERROR
            }
        }
    }
}
