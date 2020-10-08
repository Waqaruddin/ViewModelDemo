package com.example.viewmodeldemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_adapter_view_model.view.*

class AdapterViewModel(var context: Context, var mList:ArrayList<User2>): RecyclerView.Adapter<AdapterViewModel.MyViewHolder>(){

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(user:User2){
            itemView.text_view_names.text = user.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.row_adapter_view_model, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var user = mList[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setData(l:ArrayList<User2>){
        mList = l
        notifyDataSetChanged()
    }
}