package com.example.beauty911.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.beauty911.Activity.DetailActivity
import com.example.beauty911.Domain.DoctorsModel
import com.example.beauty911.databinding.ViewholderTopDoctor2Binding
import com.example.beauty911.databinding.ViewholderTopDoctorBinding

class TopDoctorAdapter2(val items: MutableList<DoctorsModel>) :
    RecyclerView.Adapter<TopDoctorAdapter2.Viewholder>() {

    private var context: Context? = null

    class Viewholder(val binding: ViewholderTopDoctor2Binding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        // Correctly get the LayoutInflater from the parent context
        context = parent.context
        val binding = ViewholderTopDoctor2Binding.inflate(LayoutInflater.from(context), parent, false)
        return Viewholder(binding) // Return Viewholder instead of calling onCreateViewHolder again
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val doctor = items[position]

        // Bind data to the view
        holder.binding.nameTxt.text = doctor.Name
        holder.binding.specialTxt.text = doctor.Special
        holder.binding.scoreTxt.text = doctor.Rating.toString()
        holder.binding.ratingBar2.rating=items[position].Rating.toFloat()
        holder.binding.scoreTxt.text=items[position].Rating.toString()
        holder.binding.degreeTxt.text="Professional Doctor"


        // Use Glide to load the image
        Glide.with(holder.itemView.context)
            .load(doctor.Picture)
            .apply(RequestOptions().transform(CenterCrop())) // Fix for Glide usage
            .into(holder.binding.img)

        holder.binding.makeBtn.setOnClickListener{
            val intent= Intent(context,DetailActivity::class.java)
            intent.putExtra("object",items[position])
            context?.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = items.size
}