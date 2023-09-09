package ru.nesterov.hotel.presentation

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView
import ru.nesterov.hotel.databinding.CarouselItemBinding

class HotelsAdapter(private val hotelsUrls: List<String>) :
    RecyclerView.Adapter<HotelsAdapter.CarouselItemViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselItemViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = CarouselItemBinding.inflate(inflater, parent, false)

        return CarouselItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarouselItemViewHolder, position: Int) {
        val hotelUrl = hotelsUrls[position]
        with(holder.binding) {
            loadImage(hotelUrl)
        }
    }


    override fun getItemCount(): Int {
        return hotelsUrls.size
    }

    private fun CarouselItemBinding.loadImage(url: String) {
        Glide
            .with(context)
            .load(url)
            .centerCrop()
            .into(hotelImage)
    }

    class CarouselItemViewHolder(val binding: CarouselItemBinding) : RecyclerView.ViewHolder(binding.root)
}