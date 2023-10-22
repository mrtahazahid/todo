package com.tahazahid.todo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tahazahid.todo.databinding.CallListItemBinding
import com.tahazahid.todo.models.CallListResponse
import com.tahazahid.todo.models.CallListResponseItem

class CallListAdapter(private val data : CallListResponse) : RecyclerView.Adapter<CallListAdapter.UserViewHolder>() {

    inner class UserViewHolder(val binding: CallListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: CallListResponseItem){
            binding.listItem = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater =LayoutInflater.from(parent.context)
        val listItemBinding = CallListItemBinding.inflate(inflater,parent,false)
        return UserViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}