package com.tttlive.basic.simpletimer.ui

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.tttlive.basic.simpletimer.R
import com.tttlive.basic.simpletimer.ui.dummy.DummyContent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CourseItemFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        testJson()
    }

    private fun testJson() {
        var dataList: MutableList<String> = mutableListOf()
        var x: Int = 0
        while (x < 1000) {
            var str: String =
                "{\"id\":$x,\"name\":\"name\",\"sex\":0,\"age\":20,\"address\":\"北京市昌平区回龙观\",\"phone\":\"15112345678\",\"email\":\"aa@bb.com\"}"
            dataList.add(str)
            x = x + 1
        }
        val gson: Gson = Gson()
        var time: Long = System.currentTimeMillis()
        Log.e("time", "gson start item=$time")
        for (item in dataList) {
            gson.fromJson(item, TestBean::class.java)
        }
        time = System.currentTimeMillis()
        Log.e("time", "gson end item=$time")
    }
}
