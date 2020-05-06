package com.xiayiye5.recyclerviewadd.kotlin

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xiayiye5.recyclerviewadd.R
import java.util.*

/**
 * @author 下一页5（轻飞扬）
 * 创建时间：2020/5/6 14:23
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：RecyclerViewAdd
 * 文件包名：com.xiayiye5.recyclerviewadd.kotlin
 * 文件说明：
 */
class KotlinMainActivity : Activity() {

    private var rvAddNewView: RecyclerView? = null
    private val addViewed = ArrayList<String>(16)
    internal var i = 0
    private var addDataAdapter: AddDataAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvAddNewView = findViewById<RecyclerView>(R.id.rv_add_new_view)
        val linearLayoutManager = GridLayoutManager(this, 4)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rvAddNewView!!.layoutManager = linearLayoutManager
        addDataAdapter = AddDataAdapter(addViewed)
        rvAddNewView!!.addItemDecoration(RecyclerItemDecoration(20, 4))
        rvAddNewView!!.adapter = addDataAdapter
        addDataAdapter!!.setAddDataListener(object : AddDataAdapter.AddDataListener {
            override fun onAddDataListener(position: Int) {
                i++
                addViewed.add("张胜$i")
                addDataAdapter!!.notifyDataSetChanged()
            }
        })
        addDataAdapter!!.setLongClickListenerRemove(object :
            AddDataAdapter.LongClickListenerRemove {
            override fun setLongClickListener(view: View) {
                addViewed.removeAt(rvAddNewView!!.getChildLayoutPosition(view))
                addDataAdapter!!.notifyDataSetChanged()
            }
        })
    }
}
