package com.example.quizapplication.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapplication.R
import com.example.quizapplication.model.Questions


class QuestionsAdapter(
    private val quizList: MutableList<Questions>,
    private val onOptionSelected : (String,String) -> Unit,
) : RecyclerView.Adapter<QuestionsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.questionlist, parent, false)
        return ViewHolder(layoutInflater)
    }

    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quizPosition = quizList[position]
        with(holder) {
            uiTvQuestionTitle.text = "${quizPosition.question_id}.${quizPosition.question_name}"
            uiRvQuiz.apply {
                adapter = OptionAdapter(
                    optionList = quizPosition.options?.toMutableList() ?: mutableListOf(),
                    onOptionSelected = { optionId ->
                        onOptionSelected(quizPosition.question_id ?: "",optionId)
                        notifyDataSetChanged()
                    }
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return quizList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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