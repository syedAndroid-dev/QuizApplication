package com.example.quizapplication.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapplication.R
import com.example.quizapplication.model.Questions


class QuizAdapter(private val quizList: MutableList<Questions>) : RecyclerView.Adapter<QuizAdapter.ViewHolder>() {

    val submittedOptions = quizList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.questionlist, parent, false)
        return ViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quizPosition = quizList[position]
        with(holder) {
            uiTvQuestionId.text = quizPosition.question_id.toString()
            uiTvQuestionTitle.text = quizPosition.question_name.toString()
            uiRvQuiz.apply {
                adapter = OptionAdapter(quizPosition.options?.toMutableList() ?: mutableListOf())
            }
        }
    }

    override fun getItemCount(): Int {
        return quizList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val uiTvQuestionId: TextView = itemView.findViewById(R.id.uiTvQuestionId)
        val uiTvQuestionTitle: TextView = itemView.findViewById(R.id.uiTvQuestionTitle)
        val uiRvQuiz: RecyclerView = itemView.findViewById(R.id.uiRvQuizList)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun displayQuizToUi(quizItems: List<Questions>) {
        quizList.clear()
        quizList.addAll(quizItems)
        notifyDataSetChanged()
    }

}