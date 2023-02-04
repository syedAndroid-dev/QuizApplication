package com.example.quizapplication.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapplication.R
import com.example.quizapplication.model.Option

class OptionAdapter(private val optionList:MutableList<Option>):RecyclerView.Adapter<OptionAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val uiRbOption = itemView.findViewById<RadioButton>(R.id.uiRbOption1)

    }

    private var selecterPosition = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.options_list,parent,false
        )
        return  ViewHolder(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val optionPosition = optionList[position]

        holder.uiRbOption.text = optionPosition.text

        holder.uiRbOption.isChecked = (holder.position == selecterPosition)
        holder.uiRbOption.setOnClickListener {
            selecterPosition = position
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return optionList.size
    }
}