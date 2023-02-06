package com.example.quizapplication.ui


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapplication.model.Questions
import com.example.quizapplication.model.SubmittedOptions
import com.example.quizapplication.model.SubmittedQuestions
import com.example.quizapplication.repository.QuizRepository
import com.example.quizapplication.utils.CustomResponse
import kotlinx.coroutines.launch

class QuizViewModel(private val repository: QuizRepository):ViewModel() {

    private val quizDataListLd  = MutableLiveData<List<Questions>>()
    private var errorLd = MutableLiveData<String>() //Handle Error From Served
    private val loaderLd = MutableLiveData<Boolean>() //Handle Loading Event

    val error: LiveData<String> = errorLd
    val loader: LiveData<Boolean> = loaderLd
    val quizDataList:LiveData<List<Questions>> = quizDataListLd

    val savedQuestionList = arrayListOf<Questions>()
    init{
        getQuiz()
    }

    fun getQuiz(){
        viewModelScope.launch {
            when(val response = repository.quizList()){
                is CustomResponse.Success ->{
                    response.data?.let { questions->
                        savedQuestionList.addAll(questions)
                    }
                    quizDataListLd.value = savedQuestionList
                }
                is CustomResponse.Failure ->{
                    errorLd.value = response.error.message
                }
            }.also { loaderLd.value = false }
        }
    }

    fun onOptionSelected(questionId : String,optionId: String) {
        val question = savedQuestionList.find { it.question_id == questionId }
        if (question != null) {
            question.options?.forEach{ option ->
                option.isSelected = option.option_id == optionId
            }
        }
    }

    fun submittedQuestionsMapper(questions: ArrayList<Questions>): List<SubmittedQuestions> {

        return questions.map {questions ->
            SubmittedQuestions(
                question = questions.question_name,
                questionId = questions.question_id,
                options = questions.options?.map { option->
                    SubmittedOptions(
                        optionId = option.option_id ?: "",
                        optionText = option.text,
                        isSelected = option.isSelected
                    )
                } ?: arrayListOf()
            )
        }


        /*questions.forEach { question->
            submittedQuesionsList.forEach { submittedQuestions ->
                submittedQuestions.questionId = question.question_id
                submittedQuestions.question = question.question_name
                question.options?.forEach {options->
                    submittedQuestions.options?.forEach {submittedOptions->
                        submittedOptions.optionId = options.option_id.toString()
                        submittedOptions.optionText = options.text
                        submittedOptions.isSelected = options.isSelected
                    }
                }

            }
        }*/

    }


}