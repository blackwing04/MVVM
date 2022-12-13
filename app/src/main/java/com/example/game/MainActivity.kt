package com.example.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.game.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel =ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.tvScore.text="${"分數："}${viewModel.score}"
        binding.btLarger.setOnClickListener {
          guess(MainActivityViewModel.GuessNum.LARGER_7)
        }
        binding.btSmaller.setOnClickListener {
            guess(MainActivityViewModel.GuessNum.SMALLER_7)
        }
    }

    private fun guess(guessNum: MainActivityViewModel.GuessNum) {
        val isCorrect =viewModel.guess(guessNum)
        binding.tvScore.text="${"分數："}${viewModel.score}"
        binding.tvNum.text="${viewModel.randNum}"
        if (isCorrect) Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show()
        else Toast.makeText(this, R.string.wrong, Toast.LENGTH_SHORT).show()
    }


}