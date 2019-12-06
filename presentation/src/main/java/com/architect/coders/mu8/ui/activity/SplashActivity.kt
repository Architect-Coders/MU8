package com.architect.coders.mu8.ui.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.architect.coders.mu8.R
import com.architect.coders.mu8.ui.viewmodel.SplashViewModel
import com.architect.coders.mu8.ui.viewmodel.SplashViewModel.UiModel
import com.architect.coders.mu8.utils.startActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var viewModel: SplashViewModel
    private lateinit var tvVersion: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        tvVersion = findViewById(R.id.tv_version)
        viewModel = ViewModelProviders.of(this)[SplashViewModel::class.java]

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
