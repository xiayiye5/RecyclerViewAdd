package com.xiayiye5.recyclerviewadd.java;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xiayiye5.recyclerviewadd.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL
 * 2019年4月8日16:57:55
 */
public class JavaMainActivity extends Activity {

    private RecyclerView rvAddNewView;
    private List<String> addViewed = new ArrayList<>(16);
    int i = 0;
    private AddDataAdapter addDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvAddNewView = findViewById(R.id.rv_add_new_view);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 4);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvAddNewView.setLayoutManager(linearLayoutManager);
        addDataAdapter = new AddDataAdapter(addViewed);
        rvAddNewView.addItemDecoration(new RecyclerItemDecoration(20,4));
        rvAddNewView.setAdapter(addDataAdapter);
        addDataAdapter.setAddDataListener(new AddDataAdapter.AddDataListener() {
            @Override
            public void onAddDataListener(int position) {
                i++;
                addViewed.add("张胜" + i);
                addDataAdapter.notifyDataSetChanged();
            }
        });
        addDataAdapter.setLongClickListenerRemove(new AddDataAdapter.LongClickListenerRemove() {
            @Override
            public void setLongClickListener(View view) {
                addViewed.remove(rvAddNewView.getChildLayoutPosition(view));
                addDataAdapter.notifyDataSetChanged();
            }
        });
    }
}
