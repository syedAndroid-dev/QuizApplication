package com.example.quizapplication.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapplication.R
import com.example.quizapplication.model.Options
import com.example.quizapplication.model.Questions

class OptionAdapter(
    private val optionList: MutableList<Options>,
   // private val submittedOptions: MutableList<Options>
):RecyclerView.Adapter<OptionAdapter.ViewHolder>() {

    private var selecterPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.options_list,parent,false)
        return  ViewHolder(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val optionPosition = optionList[position]
       // val submittedOptions = submittedOptions[position]
        holder.uiRbOption.text = optionPosition.text

        if(position == selecterPosition){
            holder.uiRbOption.isChecked = true
            optionPosition.answer=true
           // submittedOptions.answer = true
        }else{
            holder.uiRbOption.isChecked = false
            optionPosition.answer=false
         //   submittedOptions.answer = false
        }

        holder.uiRbOption.setOnClickListener {
            selecterPosition = position
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return optionList.size
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val uiRbOption = itemView.findViewById<RadioButton>(R.id.uiRbOption1)
    }

}