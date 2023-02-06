package com.example.quizapplication.ui


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapplication.model.Questions
import com.example.quizapplication.repository.QuizRepository
import com.example.quizapplication.utils.CustomResponse
import kotlinx.coroutines.launch

class MainViewModel(private val repository: QuizRepository):ViewModel() {

    private val quizDataListLd  = MutableLiveData<List<Questions>>()
    private var errorLd = MutableLiveData<String>() //Handle Error From Served
    private val loaderLd = MutableLiveData<Boolean>() //Handle Loading Event

    val error: LiveData<String> = errorLd
    val loader: LiveData<Boolean> = loaderLd
    val quizDataList:LiveData<List<Questions>> = quizDataListLd

    val allQuestionList = arrayListOf<Questions>()
    init{
        getQuiz()
    }

    fun getQuiz(){
        viewModelScope.launch {
            when(val response = repository.quizList()){
                is CustomResponse.Success ->{
                    response.data?.let { questions->
                        allQuestionList.addAll(questions)
                    }
                    quizDataListLd.value = allQuestionList
                }
                is CustomResponse.Failure ->{
                    errorLd.value = response.error.message
                }
            }.also { loaderLd.value = false }
        }
    }

    fun onOptionSelected(questionId : String,optionId: String) {
        val question = allQuestionList.find { it.question_id == questionId }
        if (question != null) {
            question.options?.forEach{ option ->
                option.isSelected = option.option_id == optionId
            }
        }
    }


}