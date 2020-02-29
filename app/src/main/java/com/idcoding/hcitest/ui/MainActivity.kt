package com.idcoding.hcitest.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.idcoding.hcitest.R
import com.idcoding.hcitest.data.DataCallback
import com.idcoding.hcitest.data.model.ItemsModel
import com.idcoding.hcitest.ui.adapter.MainPageAdapter
import com.idcoding.hcitest.ui.browser.BrowserApp
import com.idcoding.hcitest.utils.GridHelper
import kotlinx.android.synthetic.main.activity_main.*
import com.idcoding.hcitest.data.ViewHelper as ViewHelper1

/*
*  By Adya Bukhari
*  29 February, 2020
*  Email : Bukhariadbuk@gmail.com
*/

class MainActivity : AppCompatActivity(), ViewHelper1 {

    private lateinit var itemList: MutableList<ItemsModel>
    private lateinit var adapter: MainPageAdapter
    private val mDataImpl = DataImpl(this@MainActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
    }

    private fun initData(){
        showProgress()
        mDataImpl.getData(callback = object: DataCallback{

            override fun onSuccess(data: MutableList<ItemsModel>) {
                hideProgress()
                itemList = mutableListOf()
                itemList.clear()
                itemList.addAll(data)

                adapter = MainPageAdapter(this@MainActivity, itemList
                ) { item: ItemsModel -> onItemClicked(item) }

                val layoutManager = GridLayoutManager(this@MainActivity, 3)
                layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return if(adapter.getItemViewType(position) == MainPageAdapter.LIST_TYPE){
                            3
                        }else {
                            1
                        }
                    }
                }

                rvProduct.setHasFixedSize(true)
                adapter.notifyDataSetChanged()
                rvProduct.layoutManager = layoutManager
                rvProduct.addItemDecoration(GridHelper(0,3))
                rvProduct.adapter = adapter
            }

            override fun onError(message: String) {
                hideProgress()
                Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun onItemClicked(item: ItemsModel){
        val intent = Intent(this, BrowserApp::class.java)
        intent.putExtra("link", item.link)
        startActivity(intent)
    }

    override fun showProgress() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_bar.visibility = View.GONE
    }
}
