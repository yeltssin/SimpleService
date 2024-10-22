package com.app.mobileware.serviceapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.mobileware.serviceapp.R
import com.app.mobileware.serviceapp.databinding.CategoriesItemBinding

class CategoriesAdapter(): ListAdapter<String, CategoriesAdapter.ViewHolder>(ItemDiffCallback()) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: CategoriesItemBinding =
            DataBindingUtil.inflate(inflater, R.layout.categories_item, parent, false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoriesAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: CategoriesItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(categories: String){
            binding.categoriesItemTextView.text = categories
        }
    }
}


class ItemDiffCallback : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

}