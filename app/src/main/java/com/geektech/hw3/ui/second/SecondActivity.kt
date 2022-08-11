package com.geektech.hw3.ui.second

import com.geektech.hw3.R
import com.geektech.hw3.base.BaseActivity
import com.geektech.hw3.databinding.ActivitySecondBinding


class SecondActivity : BaseActivity<ActivitySecondBinding>(ActivitySecondBinding::inflate) {
    private var selectedList: ArrayList<Int> = arrayListOf()
    private lateinit var adapter: SecondAdapter

    override fun initView() {
        adapter = SecondAdapter()
        binding.rvSelectedImg.adapter = adapter
        getImage()
    }

    private fun getImage() {
        selectedList =
            (intent.getIntegerArrayListExtra(getString(R.string.selectKey)) as ArrayList<Int>)
        adapter.setSelectList(selectedList)
    }
}