package com.xiayiye5.recyclerviewadd.java;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xiayiye5.recyclerviewadd.R;

import java.util.List;

/**
 * @author DELL
 */
public class AddDataAdapter extends RecyclerView.Adapter<AddDataAdapter.VH> {
    private List<String> addViewed;
    private final int FooterNum = 2;
    private View normalView;

    AddDataAdapter(List<String> addViewed) {
        this.addViewed = addViewed;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == FooterNum) {
            View footerView = View.inflate(viewGroup.getContext(), R.layout.activity_footer_view, null);
            return new VH(footerView);
        } else {
            normalView = View.inflate(viewGroup.getContext(), R.layout.activity_normal_view, null);
            return new VH(normalView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final VH vh, final int i) {
        if (addViewed.size() != i) {
            vh.tvClickAddTextButton.setText(addViewed.get(i));
            vh.tvClickAddTextButton.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    longClickListenerRemove.setLongClickListener(v);
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return addViewed.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == addViewed.size()) {
            return FooterNum;
        } else {
            return 1;
        }
    }

    class VH extends RecyclerView.ViewHolder {
        private TextView tvClickAddTextButton;

        VH(@NonNull final View itemView) {
            super(itemView);
            if (itemView == normalView) {
                tvClickAddTextButton = (TextView) itemView.findViewById(R.id.tv_click_add_text);
            } else {
                TextView tvAddTextButton = (TextView) itemView.findViewById(R.id.tv_add_text_button);
                tvAddTextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(itemView.getContext(), "点击了添加按钮", Toast.LENGTH_SHORT).show();
                        addDataListener.onAddDataListener(getLayoutPosition());
                    }
                });
            }
        }
    }

    private AddDataListener addDataListener;
    private LongClickListenerRemove longClickListenerRemove;

    void setLongClickListenerRemove(LongClickListenerRemove longClickListenerRemove) {
        this.longClickListenerRemove = longClickListenerRemove;
    }

    void setAddDataListener(AddDataListener addDataListener) {
        this.addDataListener = addDataListener;
    }

    interface AddDataListener {
        /**
         * 添加数据的监听方法
         * @param position 添加的位置
         */
        void onAddDataListener(int position);
    }

    interface LongClickListenerRemove {
        /**
         * 长按删除的方法
         * @param view 删除的view
         */
        void setLongClickListener(View view);
    }
}
