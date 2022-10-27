package org.nathit.cryptocurrency.splashscreen

import org.koin.androidx.viewmodel.ext.android.viewModel
import org.nathit.common.ui.base.BaseFragment
import org.nathit.cryptocurrency.splashscreen.databinding.FragmentSplashscreenBinding

class SplashScreenFragment : BaseFragment<SplashScreenViewModel, FragmentSplashscreenBinding>() {

    override val viewModel: SplashScreenViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_splashscreen
    override fun getViewModelBindingVariable(): Int = BR.viewModel

    override fun initView() {
        onBackPress()
    }

    override fun initViewModel() {
        viewModel.displayHome()
    }
}