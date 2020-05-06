package com.xiayiye5.recyclerviewadd.kotlin

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

import com.xiayiye5.recyclerviewadd.R

/**
 * @author DELL
 */
class AddDataAdapter(private val addViewed: List<String>) :
    RecyclerView.Adapter<AddDataAdapter.VH>() {
    private val normal = 1
    private val footerNum = 2
    private var footerView: View? = null
    private var normalView: View? = null

    internal var addDataListener: AddDataListener? = null
    internal var longClickListenerRemove: LongClickListenerRemove? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): VH {
        if (i == footerNum) {
            footerView = View.inflate(viewGroup.context, R.layout.activity_footer_view, null)
            return VH(footerView!!)
        } else {
            normalView = View.inflate(viewGroup.context, R.layout.activity_normal_view, null)
            return VH(normalView!!)
        }
    }

    override fun onBindViewHolder(vh: VH, i: Int) {
        if (addViewed.size != i) {
            vh.tvClickAddTextButton!!.text = addViewed[i]
            vh.tvClickAddTextButton!!.setOnLongClickListener { v ->
                longClickListenerRemove?.setLongClickListener(v)
                true
            }
        }
    }

    override fun getItemCount(): Int {
        return addViewed.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == addViewed.size) {
            footerNum
        } else {
            normal
        }
    }

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvClickAddTextButton: TextView? = null
        var tvAddTextButton: TextView? = null

        init {
            if (itemView === normalView) {
                tvClickAddTextButton =
                    itemView.findViewById<View>(R.id.tv_click_add_text) as TextView
            } else {
                tvAddTextButton = itemView.findViewById<View>(R.id.tv_add_text_button) as TextView
                tvAddTextButton!!.setOnClickListener {
                    Toast.makeText(itemView.context, "点击了添加按钮", Toast.LENGTH_SHORT).show()
                    addDataListener?.onAddDataListener(layoutPosition)
                }
            }
        }
    }

    fun setLongClickListenerRemove(longClickListenerRemove: LongClickListenerRemove) {
        this.longClickListenerRemove = longClickListenerRemove
    }

    fun setAddDataListener(addDataListener: AddDataListener) {
        this.addDataListener = addDataListener
    }

    interface AddDataListener {
        fun onAddDataListener(position: Int)
    }

    interface LongClickListenerRemove {
        fun setLongClickListener(view: View)
    }
}
