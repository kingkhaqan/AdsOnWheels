package com.example.zeesh.aowprototype

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.content_user_profile.*

class UserProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        actionBar?.setDisplayShowHomeEnabled(true)


//        val data = mutableListOf<Any>()
//        data.add("PERSONAL INFO")
//        data.add(UserProfileValue("Nauman Ali", "Name"))
//        data.add(UserProfileValue("naumanasghar@gmail.com", "Email"))
//        data.add(UserProfileValue("090078601", "Phone"))
//        data.add("BRAND DETAILS")
//        data.add(UserProfileValue("MICROSOFT", "Brand"))
//        data.add(UserProfileValue("Bill Gates", "Owner"))
//        data.add(UserProfileValue("New York", "Location"))
//        user_profile_recyclerview.layoutManager = LinearLayoutManager(this)
//        user_profile_recyclerview.adapter = UserProfileAdapter(this, data)
    }

//    data class UserProfileValue(val title: String, val subtitle: String)
//
//    class UserProfileAdapter(val context: Context, val dataset: MutableList<Any>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//        override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
//            if (holder==null){
//
//            }
//            else if (holder is UserProfileTitleVH){
//                holder.bind(dataset[position] as String)
//            }
//            else if (holder is UserProfileValueVH){
//                val value = dataset[position] as UserProfileValue
//                holder.bind(value)
//                holder.itemView.setOnClickListener {
//                    val builder = AlertDialog.Builder(context)
//                    val view = LayoutInflater.from(context).inflate(R.layout.popup_user_profile_change_value, null, false)
//                    val lableTIL = view?.findViewById<TextInputLayout>(R.id.pv_usr_prfl_chng_vl_lable)
////                    val editText = view?.findViewById<EditText>(R.id.pv_usr_prfl_chng_vl_et)
//                    lableTIL?.hint = value.subtitle
//                    lableTIL?.editText?.setText(value.title)
//
//                    builder.setView(view)
//                    builder.setPositiveButton("CHANGE", {di, id->})
//                    builder.setNegativeButton("CANCEL", {di, id->
//                        di.dismiss()
//                    })
//                    builder.show()
//                }
//            }
//        }
//        override fun getItemCount() = dataset.size
//        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
//            val inflator = LayoutInflater.from(context)
//            when(viewType){
//                VIEW_TYPE_USER_PROFILE_TITLE->{
//                    return UserProfileTitleVH(inflator.inflate(R.layout.item_view_user_profile_title, parent, false))
//                }
//                VIEW_TYPE_USER_PROFILE_VALUE->{
//                    return UserProfileValueVH(inflator.inflate(R.layout.item_view_user_profile_value, parent, false))
//                }
//                VIEW_TYPE_ERROR->{}
//            }
//            return null
//        }
//        override fun getItemViewType(position: Int): Int {
//            val item = dataset[position]
//            if (item is String)
//                return VIEW_TYPE_USER_PROFILE_TITLE
//            else if (item is UserProfileValue)
//                return VIEW_TYPE_USER_PROFILE_VALUE
//            else return VIEW_TYPE_ERROR
//        }
//    }
//
//    class UserProfileTitleVH(v: View): RecyclerView.ViewHolder(v){
//        val titleTV: TextView?
//        init {
//            titleTV = v.findViewById(R.id.iv_usr_prfl_ttl_tv_title)
//        }
//        fun bind(title: String){
//            titleTV?.text = title
//        }
//    }
//    class UserProfileValueVH(v: View?): RecyclerView.ViewHolder(v){
//        val titleTV: TextView?
//        val subtitleTV: TextView?
//        init {
//            titleTV = v?.findViewById(R.id.iv_usr_prfl_vl_title)
//            subtitleTV = v?.findViewById(R.id.iv_usr_prfl_vl_subtitle)
//        }
//        fun bind(value: UserProfileValue){
//            titleTV?.text = value.title
//            subtitleTV?.text = value.subtitle
//        }
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        when(item?.itemId){
//            android.R.id.home-> {
//                finish()
//                true
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }
}
