package ru.nesterov.rooms.presentation

import androidx.recyclerview.widget.DiffUtil
import ru.nesterov.rooms.domain.entities.Room

class RoomsDiffCallback: DiffUtil.ItemCallback<Room>() {
    override fun areItemsTheSame(oldItem: Room, newItem: Room): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Room, newItem: Room): Boolean =
        oldItem == newItem

}