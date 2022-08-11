package com.geektech.hw3.ui.main

import android.content.Intent
import com.geektech.hw3.R
import com.geektech.hw3.base.BaseActivity
import com.geektech.hw3.databinding.ActivityMainBinding
import com.geektech.hw3.ext.showToast
import com.geektech.hw3.ui.second.SecondActivity


class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate),
    MainAdapter.SelectListener {
    private lateinit var adapter: MainAdapter
    private var list: ArrayList<Int> = arrayListOf()
    private var selectedList: ArrayList<Int> = arrayListOf()

    override fun initListener() {
        binding.btnForward.setOnClickListener {
            if (selectedList.isEmpty()) {
                showToast(getString(R.string.emptyList))

            } else {
                resetSelected()
                openActivity()
                selectedList.clear()
            }
        }
    }

    private fun openActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putIntegerArrayListExtra(getString(R.string.selectKey), selectedList)
        startActivity(intent)
    }

    private fun resetSelected() {
        for (i in 0..list.lastIndex) {
            adapter.notifyItemChanged(i)
        }
    }

    override fun initView() {
        adapter = MainAdapter(this)
        binding.rvImage.adapter = adapter
        adapter.setImgList(list)
        initList()
    }

    private fun initList() {
        list.add(R.drawable.img)
        list.add(R.drawable.img_1)
        list.add(R.drawable.img_2)
        list.add(R.drawable.img_2)
        list.add(R.drawable.img)
        list.add(R.drawable.img_1)
        list.add(R.drawable.img_2)
        list.add(R.drawable.img)
        list.add(R.drawable.img_1)
        list.add(R.drawable.img_2)
        list.add(R.drawable.img)
        list.add(R.drawable.img_1)
        list.add(R.drawable.img_2)
        list.add(R.drawable.img)
        list.add(R.drawable.img_1)
    }

    override fun select(selectImg: Int) {
        selectedList.add(selectImg)
    }
}