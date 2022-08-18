package com.example.finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.finalproject.databinding.FragmentAdminLoginBinding



class admin_loginFragment : Fragment() {


    private var _binding: FragmentAdminLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAdminLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.adminregister.setOnClickListener {
            findNavController().navigate(R.id.action_adminloginFragment_to_adminregisterFragment)
        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}