package com.dacha.taskmanager1.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.bottomnavigation.Task
import com.example.bottomnavigation.databinding.FragmentTaskBinding
import com.example.bottomnavigation.ui.home.HomeFragment

class TaskFragment : Fragment() {
    private  lateinit var binding: FragmentTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =FragmentTaskBinding.inflate(layoutInflater, container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAdd.setOnClickListener{
            saveTask()}
    }
    private fun saveTask(){
        if (binding.edTitle.text?.isNotEmpty() == true){
            val task = Task(
                title = binding.edTitle.text.toString(),
                desc = binding.edDesc.text.toString()
            )
            setFragmentResult(
                HomeFragment.TASK , bundleOf("key_task" to task)
            )
            findNavController().navigateUp()}
        else{binding.edTitle.error = "Input Title"}
    }



}