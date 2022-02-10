package com.aldemir.quiz_country_kotlin.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.aldemir.quiz_country_kotlin.R
import com.aldemir.quiz_country_kotlin.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding: FragmentWelcomeBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentWelcomeBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        enterQuiz()
    }

    private fun enterQuiz() {

        binding.button.setOnClickListener {
            val username = binding.txtFieldInputName.text.toString()

            binding.run {
                if (txtFieldInputName.text.toString().isEmpty()) {
                    Toast.makeText(context, "Please enter your name", Toast.LENGTH_SHORT).show()
                } else {
                    val action = WelcomeFragmentDirections.actionWelcomeFragmentToQuizFragment(username)
                    findNavController().navigate(action)
                }
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}