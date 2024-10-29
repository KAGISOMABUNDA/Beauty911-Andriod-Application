package com.example.beauty911.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.beauty911.databinding.ViewholderCategoryBinding // Update binding import
import com.example.beauty911.Domain.CategoryModel

class CategoryAdapter(private val categories: List<CategoryModel>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        // Inflate the layout using ViewholderCategoryBinding (generated from viewholder_category.xml)
        val binding = ViewholderCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category)  // Call bind function to set the data
    }

    override fun getItemCount(): Int = categories.size

    // ViewHolder class to bind data to views
    class CategoryViewHolder(private val binding: ViewholderCategoryBinding) : RecyclerView.ViewHolder(binding.root) {

        // Bind function to bind data to the views
        fun bind(category: CategoryModel) {
            binding.titleTxt.text = category.Name  // Ensure 'Name' exists in CategoryModel
            Glide.with(binding.root.context)  // Use context from binding root
                .load(category.Picture)  // Ensure 'Picture' exists in CategoryModel
                .into(binding.img)  // Assuming 'img' is the ID of ImageView in viewholder_category.xml
        }
    }
}
