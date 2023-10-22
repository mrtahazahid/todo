package com.tahazahid.todo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tahazahid.todo.databinding.BuyListItemBinding
import com.tahazahid.todo.models.BuyListResponseItem

class SellListAdapter(private val data : List<BuyListResponseItem>) : RecyclerView.Adapter<SellListAdapter.UserViewHolder>() {

    inner class UserViewHolder(val binding: BuyListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: BuyListResponseItem){
            binding.buyListItem = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater =LayoutInflater.from(parent.context)
        val listItemBinding = BuyListItemBinding.inflate(inflater,parent,false)
        return UserViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}