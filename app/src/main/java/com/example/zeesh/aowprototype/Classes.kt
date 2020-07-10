package com.example.zeesh.aowprototype

import android.graphics.Bitmap
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by zeesh on 1/19/2019.
 */


val VIEW_TYPE_IMAGE_CARD = 4665
val VIEW_TYPE_DOUBLE_VALUE_CARD = 4666
val VIEW_TYPE_TEXT_NOTE = 4667
val VIEW_TYPE_IMAGE_DOUBLE_VALUE = 4668
val VIEW_TYPE_IMAGE_SINGLE_VALUE = 4669
val VIEW_TYPE_BUTTON = 4671
val VIEW_TYPE_AMOUNT_VIEW = 4672


data class Amount(var currency: Char, var amount: Int, var decimal: Int)
data class ButtonText(val text: String="button")
class ImageSingleValue(val icon: Bitmap?=null, t: String="", o: Bitmap?=null): TextNote(t, o)
class ImageDoubleValue(val icon: Bitmap?=null, t: String="", s: String="", e: String="",  o: Bitmap? = null): DoubleValueCard(t, s, e, o)
open class DoubleValueCard(val title: String="", val subtitle: String="", val extra: String="", val optionImg: Bitmap? = null)
data class ImageCard(val bitmap: Bitmap?, val centerCrop: Boolean = false, val doubleValueCard: DoubleValueCard?)
open class TextNote(val text: String="", val optionImg: Bitmap? = null)



class AmountViewHolder(v: View): RecyclerView.ViewHolder(v)
class ImageCardViewHolder(v: View): RecyclerView.ViewHolder(v){
    val imageview: ImageView?
    val titleTextView: TextView?
    val subtitleTextView: TextView?
    val extraTextView: TextView?
    val editableImageView: ImageView?
    init {

        imageview = v.findViewById(R.id.imageview)
        titleTextView = v.findViewById(R.id.textview_title)
        subtitleTextView = v.findViewById(R.id.textview_subtitle)
        extraTextView = v.findViewById(R.id.textview_extra)
        editableImageView = v.findViewById(R.id.imagview_edit)
    }
    fun bind(imageCard: ImageCard){
        imageview?.setImageBitmap(imageCard.bitmap)
        titleTextView?.text = imageCard.doubleValueCard?.title
        subtitleTextView?.text = imageCard.doubleValueCard?.subtitle
        extraTextView?.text = imageCard.doubleValueCard?.extra
        when(imageCard.doubleValueCard?.optionImg){
            null ->{ editableImageView?.visibility = View.INVISIBLE}
            else ->{
                editableImageView?.visibility = View.VISIBLE
                editableImageView?.setImageBitmap(imageCard.doubleValueCard.optionImg)
            }
        }
        if (imageCard.centerCrop)imageview?.scaleType = ImageView.ScaleType.CENTER_CROP


    }
}
class ImageSingleValueViewHolder(v: View) : TextNoteViewHolder(v){
    val iconIV: ImageView?
//    val textTV: TextView?
    init {
        iconIV = v.findViewById(R.id.imageview_icon)
//        textTV = v.findViewById(R.id.textview_text)
    }

    fun bind(value: ImageSingleValue){
        super.bind(value)
        iconIV?.setImageBitmap(value.icon)
//        titleTV?.text = value.text

    }
}
class ImageDoubleValueViewHolder(v: View): DoubleValueViewHolder(v){
    val iconIV: ImageView?
//    val titleTV: TextView?
//    val subtitleTV: TextView?
//    val extraTV: TextView?
//    val optionIV: ImageView?
    init {
        iconIV = v.findViewById(R.id.imageview_icon)
//        titleTV = v.findViewById(R.id.textview_title)
//        subtitleTV = v.findViewById(R.id.textview_subtitle)
//        extraTV = v.findViewById(R.id.textview_extra)
//        optionIV = v.findViewById(R.id.imagview_option)
    }

    fun bind(value: ImageDoubleValue){
        iconIV?.setImageBitmap(value.icon)
        super.bind(value)
//        titleTV?.text = value.title
//        subtitleTV?.text = value.subtitle
//        extraTextView?.text = value.extra
//        when(value.optionImg){
//            null->{optionImageView?.visibility = View.INVISIBLE}
//            else->{
//                optionImageView?.visibility = View.VISIBLE
//                optionImageView?.setImageBitmap(value.optionImg)}
//        }

    }
}
open class DoubleValueViewHolder(v: View): RecyclerView.ViewHolder(v){
    val titleTV: TextView?
    val subtitleTV: TextView?
    val extraTextView: TextView?
    val optionImageView: ImageView?
    init {
        titleTV = v.findViewById(R.id.textview_title)
        subtitleTV = v.findViewById(R.id.textview_subtitle)
        extraTextView = v.findViewById(R.id.textview_extra)
        optionImageView = v.findViewById(R.id.imagview_option)
    }
    fun bind(value: DoubleValueCard){
        titleTV?.text = value.title
        subtitleTV?.text = value.subtitle
        extraTextView?.text = value.extra
        when(value.optionImg){
            null -> {optionImageView?.visibility = View.INVISIBLE}
            else -> {
                optionImageView?.visibility = View.VISIBLE
                optionImageView?.setImageBitmap(value.optionImg)
            }
        }
        optionImageView?.setOnClickListener {  }
    }
}
open class TextNoteViewHolder(v: View): RecyclerView.ViewHolder(v){
    val titleTV: TextView?
    val optionIV: ImageView?
    init {
        titleTV = v.findViewById(R.id.textview_text)
        optionIV = v.findViewById(R.id.imageview_option)
    }
    fun bind(title: TextNote){
        titleTV?.text = title.text
        if (title.optionImg==null)
            optionIV?.visibility = View.INVISIBLE
        else{
            optionIV?.setImageBitmap(title.optionImg)
            optionIV?.visibility = View.VISIBLE
        }
    }
}

class ButtonViewHolder(v: View): RecyclerView.ViewHolder(v){
    val button: Button?
    init {
        button = v.findViewById(R.id.button)
    }
    fun bind(bt: ButtonText){
        button?.text = bt.text
    }
}

class ErrorViewHolder(v: View?): RecyclerView.ViewHolder(v)