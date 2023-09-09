package ru.nesterov.booking.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import androidx.core.widget.addTextChangedListener
import com.google.android.material.card.MaterialCardView
import com.google.android.material.shape.ShapeAppearanceModel
import ru.nesterov.booking.R
import ru.nesterov.booking.databinding.TouristDataItemBinding
import ru.nesterov.booking.databinding.TouristItemBinding
import ru.nesterov.booking.domain.entities.Tourist

class BookingExpandableListAdapter(
    private val context: Context,
    private val tourists: List<Tourist>
) : BaseExpandableListAdapter() {

    var onTextChanged: ((field: TouristField, value: String, tourist: Tourist) -> Unit)? = null

    enum class TouristField {
        NAME, SURNAME, BIRTHDAY, CITIZENSHIP, PASSPORT, VALIDITY
    }

    override fun getGroupCount(): Int = tourists.size

    override fun getChildrenCount(p0: Int): Int = CHILD_ELEMENTS_NUMBER

    override fun getGroup(position: Int): Any = tourists[position]

    override fun getChild(position: Int, p1: Int): Any = tourists[position].touristData

    override fun getGroupId(position: Int): Long = tourists[position].id

    override fun getChildId(position: Int, p1: Int): Long = tourists[position].id
    override fun hasStableIds(): Boolean = true
    override fun getGroupView(
        position: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val inflater = LayoutInflater.from(context)
        val binding = TouristDataItemBinding.inflate(inflater, parent, false)
        val parentElement = tourists[position]
        configureGroupView(binding, position, isExpanded)
        return binding.root
    }

    private fun configureGroupView(
        binding: TouristDataItemBinding,
        groupPosition: Int,
        isExpanded: Boolean
    ) {
        val tourist = tourists[groupPosition]

        binding.touristNumberTextView.text = tourist.touristNumber

        if (isAddTourist(tourist)) {
            setupAddTouristView(binding)
        } else {
            setupRegularTouristView(binding, isExpanded)
        }
    }

    private fun isAddTourist(tourist: Tourist): Boolean {
        return tourist.touristNumber == "Добавить туриста"
    }

    private fun setupAddTouristView(binding: TouristDataItemBinding) {
        binding.groupIndicator.setImageResource(R.drawable.add_icon)
        binding.touristContainer.setAllCornersRounded()
    }

    private fun setupRegularTouristView(binding: TouristDataItemBinding, isExpanded: Boolean) {
        if (isExpanded) {
            binding.groupIndicator.setImageResource(R.drawable.down_arrow)
            binding.touristContainer.setTopCornersRounded()
            binding.bottomSpace.visibility = View.GONE
        } else {
            binding.groupIndicator.setImageResource(R.drawable.up_arrow)
            binding.touristContainer.setAllCornersRounded()
            binding.bottomSpace.visibility = View.VISIBLE
        }
    }

    private fun MaterialCardView.setAllCornersRounded() {
        this.shapeAppearanceModel = ShapeAppearanceModel.builder()
            .setAllCornerSizes(15f)
            .build()
    }

    private fun MaterialCardView.setTopCornersRounded() {
        this.shapeAppearanceModel = ShapeAppearanceModel.builder()
            .setTopRightCornerSize(15f)
            .setTopLeftCornerSize(15f)
            .build()
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?,
    ): View {
        val inflater = LayoutInflater.from(context)
        val childBinding = TouristItemBinding.inflate(inflater, parent, false)
        val childElement = tourists[groupPosition].touristData

        with(childBinding) {
            nameEditText.addTextChangedListener { input ->
                onTextChanged?.invoke(TouristField.NAME, input.toString(), tourists[groupPosition])
            }
            surnameEditText.addTextChangedListener { input ->
                onTextChanged?.invoke(
                    TouristField.SURNAME,
                    input.toString(),
                    tourists[groupPosition]
                )

            }
            birthdayEditText.addTextChangedListener { input ->
                onTextChanged?.invoke(
                    TouristField.BIRTHDAY,
                    input.toString(),
                    tourists[groupPosition]
                )

            }
            citizenshipEditText.addTextChangedListener { input ->
                onTextChanged?.invoke(
                    TouristField.CITIZENSHIP,
                    input.toString(),
                    tourists[groupPosition]
                )

            }
            passportEditText.addTextChangedListener { input ->
                onTextChanged?.invoke(
                    TouristField.PASSPORT,
                    input.toString(),
                    tourists[groupPosition]
                )

            }
            passportValidityEditText.addTextChangedListener { input ->
                onTextChanged?.invoke(
                    TouristField.VALIDITY,
                    input.toString(),
                    tourists[groupPosition]
                )
            }
        }

        return childBinding.root
    }


    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        if (isLastTourist(groupPosition)) {
            return false
        }
        return true
    }

    private fun isLastTourist(position: Int): Boolean {
        return position == tourists.size - 1
    }

    companion object {

        private const val CHILD_ELEMENTS_NUMBER = 1
    }
}