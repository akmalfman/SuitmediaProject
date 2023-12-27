package com.akmj.suitmediaproject.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.akmj.suitmediaproject.data.remote.response.DataItem
import com.akmj.suitmediaproject.databinding.ItemRowUserBinding
import com.bumptech.glide.Glide

class UserAdapter(private val onUserItemClickListener: OnUserItemClickListener) : PagingDataAdapter<DataItem, UserAdapter.MyUserHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyUserHolder {
        val binding = ItemRowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyUserHolder(binding)
    }

    override fun onBindViewHolder(holder: MyUserHolder, position: Int) {
        val review = getItem(position)
        if (review != null) {
            holder.bind(review)
            holder.itemView.setOnClickListener {
               "${review.firstName} ${review.lastName}".let { it1 -> onUserItemClickListener.onUserItemClicked(it1) }
            }
        }

    }

    class MyUserHolder(private val binding: ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: DataItem) {
            binding.tvItemName.text = "${user.firstName} ${user.lastName}"
            binding.tvItemEmail.text = "${user.email}"
            Glide.with(binding.root.context)
                .load(user.avatar) // URL Gambar
                .into(binding.imgItemAvatar)
        }
    }

    interface OnUserItemClickListener {
        fun onUserItemClicked(username: String)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataItem>() {
            override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}