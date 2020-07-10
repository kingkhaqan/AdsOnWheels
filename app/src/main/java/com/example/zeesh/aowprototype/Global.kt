package com.example.zeesh.aowprototype

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.graphics.Bitmap.CompressFormat
import android.graphics.BitmapFactory
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AlertDialog
import android.support.v7.widget.CardView
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.item_view_image_doubl_value.view.*
import java.io.ByteArrayOutputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.util.*


/**
 * Created by zeesh on 1/16/2019.
 */


val AD_CARD_IMAGE_SIZE = 200
val PACKAGE_NAME = "com.example.zeesh.aowprototype"
val PARENT_CLASS_NAME_EXTRA = "parentClass"

val VIEW_TYPE_USER_PROFILE_TITLE = 5462
val VIEW_TYPE_USER_PROFILE_VALUE = 5461
val VIEW_TYPE_ERROR = -1
val VIEW_TYPE_ESTIMATION_CARD = 5460
val VIEW_TYPE_CAMPAIGN_CARD = 4663
val VIEW_TYPE_BTN_CONFIRM = 4664


class RecyclerViewAdapter(val context: Context, val dataset: MutableList<Any>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount() = dataset.size
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        when{
            holder == null ->{}
            holder is ImageCardViewHolder -> {holder.bind(dataset[position] as ImageCard)}
            holder is DoubleValueViewHolder -> {holder.bind(dataset[position] as DoubleValueCard)}
            holder is TextNoteViewHolder -> {holder.bind(dataset[position] as TextNote)}
            holder is ImageDoubleValueViewHolder -> {}
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        val inflater = LayoutInflater.from(context)
        when(viewType){
            VIEW_TYPE_IMAGE_CARD->{
                return ImageCardViewHolder(inflater.inflate(R.layout.item_view_image_card, parent, false))
            }
            VIEW_TYPE_DOUBLE_VALUE_CARD->{
                return DoubleValueViewHolder(inflater.inflate(R.layout.item_view_double_value, parent, false))
            }
            VIEW_TYPE_TEXT_NOTE->{
                return TextNoteViewHolder(inflater.inflate(R.layout.item_view_text_note, parent, false))
            }
            VIEW_TYPE_IMAGE_DOUBLE_VALUE ->{
                return ImageDoubleValueViewHolder(inflater.inflate(R.layout.item_view_image_doubl_value, parent, false))
            }
            VIEW_TYPE_ERROR->{}
        }

        return null
    }
    override fun getItemViewType(position: Int): Int {
        val dataObj = dataset[position]
        when{
            dataObj is DoubleValueCard-> return VIEW_TYPE_DOUBLE_VALUE_CARD
            dataObj is ImageCard-> return VIEW_TYPE_IMAGE_CARD
            dataObj is TextNote-> return VIEW_TYPE_TEXT_NOTE
            dataObj is ImageDoubleValue -> return VIEW_TYPE_IMAGE_DOUBLE_VALUE
            else-> return VIEW_TYPE_ERROR
        }
    }
}


data class UserProfileValue(val title: String, val subtitle: String)
data class CampaignCard(val image: Bitmap, val title: String, val subtitle: String, val time: String)
data class EstimationCard(val cars: Int, val from: String, val to: String, val city: String, val amount: Amount)

//class CampaignConfirmAdapter(val context: Context, val dataset: MutableList<Any>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
//        val inflater = LayoutInflater.from(context)
//        when(viewType){
//            VIEW_TYPE_ESTIMATION_CARD->{
//                return EstimationCardViewHolder(inflater.inflate(R.layout.estimation_confirm, parent, false))
//            }
//            VIEW_TYPE_BTN_CONFIRM->{
//                return ConfirmButtonVH(inflater.inflate(R.layout.item_view_btn_confirm, parent, false))
//            }
//            VIEW_TYPE_IMAGE_CARD->{
//                return ImageCardVH(inflater.inflate(R.layout.item_view_image_card, parent, false))
//            }
//        }
//
//        return null
//
//    }
//    override fun getItemCount() = dataset.size
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
//        when{
//            holder==null->{}
//            holder is ConfirmButtonVH->{
//                val text = dataset[position] as String
//                holder.button?.text = text
//                holder.button?.setOnClickListener {
//                    context.startActivity(Intent(context, UserDetailActivity::class.java))
//                }
//            }
//            holder is ImageCardVH ->{
//                holder.imageview?.setImageBitmap(dataset[position] as Bitmap)
//            }
//            holder is EstimationCardViewHolder->{ holder.bind(dataset[position] as EstimationCard) }
////            holder is CampaignCardViewHolder->{holder.bind(dataset[position] as CampaignCard)}
//        }
//    }
//    override fun getItemViewType(position: Int): Int {
//        val dataObj = dataset[position]
//        if (dataObj is EstimationCard)
//            return VIEW_TYPE_ESTIMATION_CARD
////        else if (dataObj is CampaignCard)
////            return VIEW_TYPE_CAMPAIGN_CARD
//        else if (dataObj is String)
//            return VIEW_TYPE_BTN_CONFIRM
//        else if(dataObj is Bitmap)
//            return VIEW_TYPE_IMAGE_CARD
//        return VIEW_TYPE_ERROR
//    }
//}





class ImageCardVH(v: View?): RecyclerView.ViewHolder(v){
    val imageview: ImageView?
    init {
        imageview = v?.findViewById(R.id.imageview)
    }
}

class ConfirmButtonVH(v: View?): RecyclerView.ViewHolder(v){
    val button: Button?
    init {
        button = v?.findViewById(R.id.btn_confirm)
    }
}

class UserProfileTitleVH(v: View?): RecyclerView.ViewHolder(v){
    val titleTV: TextView?
    init {
        titleTV = v?.findViewById(R.id.iv_usr_prfl_ttl_tv_title)
    }
    fun bind(title: String){
        titleTV?.text = title
    }
}
class UserProfileValueVH(v: View?): RecyclerView.ViewHolder(v){
    val titleTV: TextView?
    val subtitleTV: TextView?
    init {
        titleTV = v?.findViewById(R.id.iv_usr_prfl_vl_title)
        subtitleTV = v?.findViewById(R.id.iv_usr_prfl_vl_subtitle)
    }
    fun bind(value: UserProfileValue){
        titleTV?.text = value.title
        subtitleTV?.text = value.subtitle
    }
}


class EstimationCardViewHolder(v: View?): RecyclerView.ViewHolder(v){
    val carsTextView: TextView?
    val fromTextView: TextView?
    val toTextView: TextView?
    val cityTextView: TextView?
    val currencyTextView: TextView?
    val amountTextView: TextView?
    val decimalTextView: TextView?

    init {
        carsTextView = v?.findViewById(R.id.textview_cars)
        fromTextView = v?.findViewById(R.id.textview_from)
        toTextView = v?.findViewById(R.id.textview_to)
        cityTextView = v?.findViewById(R.id.textview_city)
        currencyTextView = v?.findViewById(R.id.textview_currency)
        amountTextView = v?.findViewById(R.id.textview_amount)
        decimalTextView = v?.findViewById(R.id.textview_decimal)
    }

    fun bind(estimation: EstimationCard){
        carsTextView?.text = estimation.cars.toString()
        fromTextView?.text = estimation.from
        toTextView?.text = estimation.to
        cityTextView?.text = estimation.city
        currencyTextView?.text = estimation.amount.currency.toString()
        amountTextView?.text = estimation.amount.amount.toString()
        decimalTextView?.text = ".${estimation.amount.decimal}"
        val str = amountTextView?.text
        val s = str.toString()
    }
}
class CampaignCardViewHolder(v: View): RecyclerView.ViewHolder(v){
    val imageView: ImageView?
    val titleTextView: TextView?
    val subtitleTextView: TextView?
    val timeTextView: TextView?

    init {
        imageView = v.findViewById(R.id.image)
        titleTextView = v.findViewById(R.id.title)
        subtitleTextView = v.findViewById(R.id.subtitle)
        timeTextView = v.findViewById(R.id.time)

    }
    fun bind(campaign: CampaignCard){
        imageView?.setImageBitmap(campaign.image)
        titleTextView?.text = campaign.title
        subtitleTextView?.text = campaign.subtitle
        timeTextView?.text = campaign.time
    }
}

fun ShrinkBitmap(file: String, width: Int, height: Int): Bitmap {

    val bmpFactoryOptions = BitmapFactory.Options()
    bmpFactoryOptions.inJustDecodeBounds = true
    var bitmap = BitmapFactory.decodeFile(file, bmpFactoryOptions)

    val heightRatio = Math.ceil((bmpFactoryOptions.outHeight / height.toFloat()).toDouble()).toInt()
    val widthRatio = Math.ceil((bmpFactoryOptions.outWidth / width.toFloat()).toDouble()).toInt()

    if (heightRatio > 1 || widthRatio > 1) {
        if (heightRatio > widthRatio) {
            bmpFactoryOptions.inSampleSize = heightRatio
        } else {
            bmpFactoryOptions.inSampleSize = widthRatio
        }
    }

    bmpFactoryOptions.inJustDecodeBounds = false
    bitmap = BitmapFactory.decodeFile(file, bmpFactoryOptions)

    val stream = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
    val imageInByte = stream.toByteArray()
    //this gives the size of the compressed image in kb
    val lengthbmp = (imageInByte.size / 1024).toLong()

    try {
        bitmap.compress(CompressFormat.JPEG, 100, FileOutputStream("/sdcard/mediaAppPhotos/compressed_new.jpg"))
    } catch (e: FileNotFoundException) {
        // TODO Auto-generated catch block
        e.printStackTrace()
    }


    return bitmap
}

fun getResizedBitmap(image: Bitmap, maxSize: Int): Bitmap {
    var width = image.width
    var height = image.height

    val bitmapRatio = width.toFloat() / height.toFloat()
    if (bitmapRatio > 1) {
        width = maxSize
        height = (width / bitmapRatio).toInt()
    } else {
        height = maxSize
        width = (height * bitmapRatio).toInt()
    }
    return Bitmap.createScaledBitmap(image, width, height, true)
}