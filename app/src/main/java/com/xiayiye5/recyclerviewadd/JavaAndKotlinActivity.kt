package com.xiayiye5.recyclerviewadd

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.xiayiye5.recyclerviewadd.java.JavaMainActivity
import com.xiayiye5.recyclerviewadd.kotlin.KotlinMainActivity
import kotlinx.android.synthetic.main.activity_java_kotlin.*

/*
 * Copyright (c) 2020, smuyyh@gmail.com All Rights Reserved.
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG            #
 * #                                                   #
 */

/**
 * @author 下一页5（轻飞扬）
 * 创建时间：2020/5/6 14:34
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：RecyclerViewAdd
 * 文件包名：com.xiayiye5.recyclerviewadd
 * 文件说明：Java版本和Kotlin版本选择页面
 */
class JavaAndKotlinActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java_kotlin)
        lvSelect.setOnItemClickListener { p0, p1, position, p3 ->
            when (position) {
                0 -> goToJava()
                1 -> goToKotlin()
            }
        }
    }

    private fun goToKotlin() {
        startActivity(Intent(this, KotlinMainActivity::class.java))
    }

    private fun goToJava() {
        startActivity(Intent(this, JavaMainActivity::class.java))
    }
}