package org.nathit.cryptocurrency.home

import org.koin.androidx.viewmodel.ext.android.viewModel
import org.nathit.common.ui.base.BaseFragment
import org.nathit.cryptocurrency.home.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    override val viewModel: HomeViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_home
    override fun getViewModelBindingVariable(): Int = BR.viewModel

    //private var adapter: UserListAdapter? = null

    override fun initView() {
        onBackPress()
    }

    override fun initViewModel() {
//        viewModel.getUsersList()
//        viewModel.userListResult.observe(
//            this
//        ) {
//            setUserListAdapter(it)
//        }
    }

//    private fun setUserListAdapter(data: ArrayList<UserList>) {
//        adapter = UserListAdapter(
//            data,
//            object : UserListAdapter.OnItemClickListener {
//                override fun onItemClickListener(login: String, avatarUrl: String) {
//                    viewModel.displayUserInfo(login, avatarUrl)
//                }
//            }
//        )
//        val lm = LinearLayoutManager(requireContext())
//        binding.rcvUserHome.layoutManager = lm
//        binding.rcvUserHome.adapter = adapter
//    }
}