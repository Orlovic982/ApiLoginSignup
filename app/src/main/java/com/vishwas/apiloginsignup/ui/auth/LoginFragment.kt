package com.vishwas.apiloginsignup.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.vishwas.apiloginsignup.data.network.AuthApi
import com.vishwas.apiloginsignup.data.network.Resources
import com.vishwas.apiloginsignup.data.repository.AuthRepository
import com.vishwas.apiloginsignup.databinding.FragmentLoginBinding
import com.vishwas.apiloginsignup.ui.base.BaseFragment
import kotlinx.coroutines.launch

class LoginFragment : BaseFragment<AuthViewModel, FragmentLoginBinding, AuthRepository>() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        viewmodel.loginResponse.observe(viewLifecycleOwner) {
            when (it) {
                is Resources.Success -> {
//                    Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT)
//                        .show()
                    lifecycleScope.launch() {
                        userPreferences.saveAuthToken(it.value.access_token)
                    }
                }
                is Resources.Failure -> {
                    Toast.makeText(context, "Login failure", Toast.LENGTH_SHORT)
                        .show()
                }

            }


        }




        binding.buttonLogin.setOnClickListener() {
            val email = binding.editTextEmail.text.toString().trim()
            val password = binding.editTextPassword.text.toString().trim()
            //Todo Add validiations
            viewmodel.login(email, password)

        }
    }

    override fun getViewModel() = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLoginBinding.inflate(inflater, container, false)

    override fun getFragmentRepository(): AuthRepository =
        AuthRepository(remoteDataSource.buildApi(AuthApi::class.java))


}