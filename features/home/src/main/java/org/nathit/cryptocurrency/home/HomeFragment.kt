package org.nathit.cryptocurrency.home

import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.nathit.common.ui.base.BaseFragment
import org.nathit.cryptocurrency.domain.model.CryptoList
import org.nathit.cryptocurrency.home.adapter.CryptoListAdapter
import org.nathit.cryptocurrency.home.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    override val viewModel: HomeViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_home
    override fun getViewModelBindingVariable(): Int = BR.viewModel

    private var adapter: CryptoListAdapter? = null

    override fun initView() {
        onBackPress()
    }

    override fun initViewModel() {
        viewModel.getCoinsList()
        viewModel.cryptoListResult.observe(
            this
        ) {
            setCryptoListAdapter(it)
        }
    }

    private fun setCryptoListAdapter(data: ArrayList<CryptoList>) {
        adapter = CryptoListAdapter(
            requireContext(),
            data
        )
        val lm = LinearLayoutManager(requireContext())
        binding.rcvHome.layoutManager = lm
        binding.rcvHome.adapter = adapter
    }
}