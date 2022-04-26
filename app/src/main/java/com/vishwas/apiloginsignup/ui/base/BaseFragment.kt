package com.vishwas.apiloginsignup.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.vishwas.apiloginsignup.data.UserPreferences
import com.vishwas.apiloginsignup.data.network.RemoteDataSource
import com.vishwas.apiloginsignup.data.repository.BaseRepository

abstract class BaseFragment<VM : ViewModel, B : ViewBinding, R : BaseRepository> : Fragment() {



    protected lateinit var binding: B
    protected lateinit var viewmodel:VM
    protected val remoteDataSource=RemoteDataSource()

    protected lateinit var userPreferences: UserPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getFragmentBinding(inflater, container)
        val factory=ViewModelFactory(getFragmentRepository())
        viewmodel=ViewModelProvider(this,factory).get(getViewModel())


        userPreferences= UserPreferences(requireContext())


        return binding.root

    }

    abstract fun getViewModel(): Class<VM>

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): B

    abstract fun getFragmentRepository(): R

}