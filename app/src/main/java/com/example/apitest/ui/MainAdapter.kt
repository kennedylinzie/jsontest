package com.example.apitest.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.apitest.data.UserDataEntity
import com.example.apitest.databinding.ActivityMainUserItemBinding

class MainAdapter  : ListAdapter<UserDataEntity, MainAdapter.ViewHolder>(differ){
    private var onItemClickListener: OnItemClickListener? = null
    fun setOnItemClickListener(listener: OnItemClickListener) {
        onItemClickListener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ActivityMainUserItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }


    inner class ViewHolder(private val binding: ActivityMainUserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(message: UserDataEntity) = binding.apply {
            this.message = message
            imgAvatarUrl.setOnClickListener {
                onItemClickListener?.onItemClick(message)
            }
            executePendingBindings()
        }
    }

    interface OnItemClickListener {
        fun onItemClick(userData: UserDataEntity)
    }


    companion object {
        val differ = object : DiffUtil.ItemCallback<UserDataEntity>() {

            override fun areContentsTheSame(oldItem: UserDataEntity, newItem: UserDataEntity): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: UserDataEntity, newItem: UserDataEntity): Boolean {
                return oldItem.id == newItem.id
            }
        }

    }

}