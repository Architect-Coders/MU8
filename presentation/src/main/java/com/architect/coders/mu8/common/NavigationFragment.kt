package com.architect.coders.mu8.common

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.architect.codes.mu8.common.Scope

abstract class NavigationFragment(private val action: Int? = null) : Fragment(), Scope by Scope.Implementation() {

    private lateinit var callback: OnBackPressedCallback

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        callback = requireActivity().onBackPressedDispatcher.addCallback(this, true) { onNavigateBack() }
    }

    private fun onNavigateBack() {
        if (action == null) {
            activity?.finish()
            return
        }
        NavHostFragment.findNavController(this).navigate(action)
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        callback.remove()
    }
}
