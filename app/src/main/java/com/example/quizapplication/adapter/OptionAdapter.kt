package com.example.quizapplication.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapplication.R
import com.example.quizapplication.model.Options

class OptionAdapter(
    private val optionList: MutableList<Options>,
    private val onOptionSelected: (String) -> Unit,
) : RecyclerView.Adapter<OptionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.options_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {
        val optionPosition = optionList[position]
        holder.uiRbOption.text = optionPosition.text
        holder.uiRbOption.isChecked = optionPosition.isSelected == true
    }

    override fun getItemCount(): Int {
        return optionList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val uiRbOption: RadioButton = itemView.findViewById(R.id.uiRbOption)
        init {
            uiRbOption.setOnClickListener {
                onOptionSelected(optionList[adapterPosition].option_id ?: "")
                notifyDataSetChanged()
            }
        }
    }
}