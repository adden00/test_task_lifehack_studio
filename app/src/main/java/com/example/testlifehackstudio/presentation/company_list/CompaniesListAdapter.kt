package com.example.testlifehackstudio.presentation.company_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.CompanyListModelItem
import com.example.testlifehackstudio.R
import com.example.testlifehackstudio.common.constants.Constants.BASE_URL
import com.example.testlifehackstudio.databinding.CompaniesListItemBinding

class CompaniesListAdapter(private val listener: Listener) :
    ListAdapter<CompanyListModelItem, CompaniesListAdapter.ItemHolder>(object :
        DiffUtil.ItemCallback<CompanyListModelItem>() {
        override fun areItemsTheSame(
            oldItem: CompanyListModelItem,
            newItem: CompanyListModelItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CompanyListModelItem,
            newItem: CompanyListModelItem
        ): Boolean {
            return oldItem == newItem
        }
    }) {
    class ItemHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData(item: CompanyListModelItem, listener: Listener) {
            val binding = CompaniesListItemBinding.bind(view)
            binding.tvName.text = item.name
            Glide.with(binding.root.context).load("$BASE_URL${item.img}").centerCrop()
                .into(binding.imCompanyImage)
            view.setOnClickListener {
                listener.onItemClicked(item.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.companies_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setData(getItem(position), listener)
    }

    interface Listener {
        fun onItemClicked(id: String)
    }
}