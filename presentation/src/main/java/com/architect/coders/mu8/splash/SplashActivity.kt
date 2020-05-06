package com.architect.coders.mu8.splash

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.architect.coders.mu8.R
import com.architect.coders.mu8.categories.CategoriesActivity
import com.architect.coders.mu8.di.internal.ViewModelComponent
import com.architect.coders.mu8.di.internal.ViewModelModule
import com.architect.coders.mu8.splash.SplashViewModel.UiModel
import com.architect.coders.mu8.utils.app
import com.architect.coders.mu8.utils.getViewModel
import com.architect.coders.mu8.utils.startActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var component: ViewModelComponent
    private lateinit var tvVersion: TextView

    private val viewModel by lazy { getViewModel { component.splashViewModel } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        component = app.component.plus(ViewModelModule())

        tvVersion = findViewById(R.id.tv_version)
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
