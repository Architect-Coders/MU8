package com.architect.coders.mu8.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.architect.coders.mu8.R
import com.architect.coders.mu8.StartingNavHostActivity
import com.architect.coders.mu8.utils.getViewModel

class SplashFragment : Fragment() {

    private lateinit var viewModel: SplashViewModel
    private lateinit var appVersion: TextView

    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as StartingNavHostActivity).hideToolbar()

        navController = view.findNavController()

        appVersion = view.findViewById(R.id.tv_version)
        viewModel = getViewModel { SplashViewModel() }

        viewModel.model.observe(this, Observer(::initUi))
    }

    private fun initUi(model: SplashViewModel.UiModel) {
        when (model) {
            is SplashViewModel.UiModel.GetVersion -> appVersion.text = getString(R.string.version_name, model.versionName)
            is SplashViewModel.UiModel.Navigation -> navController.navigate(R.id.action_splashFragment_to_categoriesFragment)
        }
    }
}