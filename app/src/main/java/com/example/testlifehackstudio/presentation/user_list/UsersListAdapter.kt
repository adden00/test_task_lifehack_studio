package com.example.testlifehackstudio.presentation.user_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.UsersListModelItemDomain
import com.example.testlifehackstudio.R
import com.example.testlifehackstudio.common.constants.Constants.BASE_URL
import com.example.testlifehackstudio.databinding.UsersListItemBinding

class UsersListAdapter: ListAdapter<UsersListModelItemDomain, UsersListAdapter.ItemHolder>(object : DiffUtil.ItemCallback<UsersListModelItemDomain>() {
    override fun areItemsTheSame(
        oldItem: UsersListModelItemDomain,
        newItem: UsersListModelItemDomain
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: UsersListModelItemDomain,
        newItem: UsersListModelItemDomain
    ): Boolean {
        return oldItem == newItem
    }

}) {
    class ItemHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun setData(item: UsersListModelItemDomain) {
            val binding = UsersListItemBinding.bind(view)
            binding.tvName.text = item.name
            Glide.with(binding.root.context).load("$BASE_URL${item.img}").centerCrop().into(binding.imUserImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.users_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setData(getItem(position))
    }
}