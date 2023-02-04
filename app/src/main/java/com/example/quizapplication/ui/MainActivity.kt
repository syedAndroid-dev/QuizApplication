package com.example.quizapplication.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.quizapplication.R
import com.example.quizapplication.adapter.QuizAdapter
import com.example.quizapplication.databinding.ActivityMainBinding
import com.example.quizapplication.model.Data
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val quizAdapter: QuizAdapter by lazy {
        QuizAdapter(
            quizList = mutableListOf()
        )
    }

    val quizViewModel : MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding
        setContentView(binding.root)

        setUpUi()
        setUpObserver()
        setCounDown()
    }

    private fun setUpUi() {
        binding.uiRvQuiz.apply {
            adapter = quizAdapter
        }

    }

    private fun setUpObserver() {
        quizViewModel.quizDataList.observe(this){
            setQuizToUi(it)
        }
    }

    private fun setQuizToUi(it: List<Data>?) {
        it?.let { it1 -> quizAdapter.DisplayQuizToUi(it1) }
        object :CountDownTimer(30000,1000){
            @SuppressLint("SetTextI18n")
            override fun onTick(time: Long) {
                binding.uiTvSubTitle.setText("${it?.size} Questions . Quiz Timer ${time/1000}")

            }

            override fun onFinish() {
                binding.uiTvSubTitle.setText("${it?.size} Questions . Quiz Time Over")
            }

        }.start()
    }

    private fun setCounDown() {

    }
}