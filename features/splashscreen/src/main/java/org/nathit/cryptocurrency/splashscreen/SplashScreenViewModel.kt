package org.nathit.cryptocurrency.splashscreen

import NavigationCommand
import org.nathit.common.ui.base.BaseViewModel

class SplashScreenViewModel(
) : BaseViewModel() {


    fun displayHome() {
        navigate(
            NavigationCommand.To(
                SplashScreenFragmentDirections.actionSplashScreenFragmentToNavHome()
            )
        )
    }
}