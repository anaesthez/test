package ru.nesterov.rooms.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayoutMediator
import ru.nesterov.rooms.R
import ru.nesterov.rooms.databinding.RoomItemBinding
import ru.nesterov.rooms.domain.entities.Room

class RoomsAdapter : ListAdapter<Room, RoomsViewHolder>(RoomsDiffCallback()) {

    private lateinit var context: Context
    var onItemClickListener: ((Room) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomsViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = RoomItemBinding.inflate(inflater, parent, false)
        return RoomsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RoomsViewHolder, position: Int) {
        val element = getItem(position)
        with(holder.binding) {
            nameTextView.text = element.name
            priceTextView.text = context.getString(R.string.price_text, element.price)
            priceForItTextView.text = element.pricePer
            setupViewpager(element.imageUrls)
            setupPeculiarities(element.peculiarities)
            setupClickListener(element)
        }
    }

    private fun RoomItemBinding.setupPeculiarities(peculiarities: List<String>) {
        val textViews = listOf(firstPeculiarity, secondPeculiarity)
        textViews.forEachIndexed { index, textView ->
            textView.text = peculiarities[index]
        }
    }

    private fun RoomItemBinding.setupViewpager(urls: List<String>) {
        viewPager.apply {
            clipChildren = false
            clipToPadding = false
            offscreenPageLimit = 3
            (getChildAt(0) as RecyclerView).overScrollMode =
                RecyclerView.OVER_SCROLL_NEVER
        }
        viewPager.adapter = RoomsPagerAdapter(urls)
        TabLayoutMediator(tabLayout, viewPager) { _, _ ->

        }.attach()
    }

    private fun RoomItemBinding.setupClickListener(room: Room) {
        chooseRoomButton.setOnClickListener {
            onItemClickListener?.invoke(room)
        }
    }
}