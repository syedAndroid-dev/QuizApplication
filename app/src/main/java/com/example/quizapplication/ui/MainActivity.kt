package com.example.quizapplication.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.example.quizapplication.adapter.QuizAdapter
import com.example.quizapplication.databinding.ActivityMainBinding
import com.example.quizapplication.model.Questions
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val quizAdapter: QuizAdapter by lazy {
        QuizAdapter(quizList = mutableListOf())
    }
    var answerList = mutableListOf<Questions>()
    private val quizViewModel : MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding
        setContentView(binding.root)
        setUpUi()
        setUpObserver()
    }

    private fun setUpUi() {
        binding.uiRvQuiz.apply {
            adapter = quizAdapter
        }
        binding.uiBtSubmit.setOnClickListener {
            onButtonClicked()
        }
    }

    private fun setUpObserver() {
        quizViewModel.quizDataList.observe(this){
            setQuizToUi(it)
        }
    }

    private fun setQuizToUi(it: List<Questions>?) {
        it?.let { it1 -> quizAdapter.displayQuizToUi(it1) }
        object :CountDownTimer(30000,1000){
            @SuppressLint("SetTextI18n")
            override fun onTick(time: Long) {
                binding.uiTvSubTitle.text = "${it?.size} Questions . Quiz Timer ${time/1000}"
            }

            override fun onFinish() {
                binding.uiTvSubTitle.text = "${it?.size} Questions . Quiz Time Over"
            }

        }.start()
    }

    private fun onButtonClicked() {
   //    quizAdapter.submittedOptions

        Toast.makeText(this,quizAdapter.submittedOptions.toString(),Toast.LENGTH_LONG).show()
    }

}