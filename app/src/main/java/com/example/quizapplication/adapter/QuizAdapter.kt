package com.example.quizapplication.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapplication.R
import com.example.quizapplication.model.Data
import com.example.quizapplication.model.Option


class QuizAdapter(private val quizList: MutableList<Data>) :
    RecyclerView.Adapter<QuizAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.questionlist, parent, false)
        return ViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return quizList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quizPosition = quizList[position]
        Log.d("option", quizPosition.options.toString())
        holder.uiTvQuestionId.text = quizPosition._id .toString()
        holder.uiTvQuestionTitle.text = quizPosition.text.toString()

//        val optionList = mutableListOf<Option>(
//            Option(
//                optionId = "1",
//                text = "syed",
//                answer = true
//            )
//        )
        Log.d("dataitems", quizPosition.options.toString())
        holder.uiRvQuiz.apply {
            adapter = quizPosition.options?.let {
                OptionAdapter(
                    it.toMutableList()

                )
            }
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val uiTvQuestionId = itemView.findViewById<TextView>(R.id.uiTvQuestionId)
        val uiTvQuestionTitle = itemView.findViewById<TextView>(R.id.uiTvQuestionTitle)
        val uiRvQuiz = itemView.findViewById<RecyclerView>(R.id.uiRvQuizList)

    }

    @SuppressLint("NotifyDataSetChanged")
    fun DisplayQuizToUi(quizItems: List<Data>) {
        quizList.clear()
        quizList.addAll(quizItems)
        notifyDataSetChanged()
    }

}