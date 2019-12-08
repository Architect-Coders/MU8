package com.architect.coders.mu8.splash

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.architect.coders.mu8.R
import com.architect.coders.mu8.categories.CategoriesActivity
import com.architect.coders.mu8.splash.SplashViewModel.UiModel
import com.architect.coders.mu8.utils.getViewModel
import com.architect.coders.mu8.utils.startActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var viewModel: SplashViewModel
    private lateinit var tvVersion: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        tvVersion = findViewById(R.id.tv_version)
        viewModel = getViewModel { SplashViewModel() }

        viewModel.model.observe(this, Observer(::initUi))
    }

    private fun initUi(model: UiModel) {
        when (model) {
            is UiModel.GetVersion -> tvVersion.text = getString(R.string.version_name, model.versionName)
            is UiModel.Navigation -> {
                startActivity<CategoriesActivity> {}
                finish()
            }
        }
    }
}
