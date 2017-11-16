package com.jayden.todo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.jayden.todo.R;
import com.jayden.todo.entry.Bean;
import com.wyh.slideAdapter.BottomListener;
import com.wyh.slideAdapter.HeaderBind;
import com.wyh.slideAdapter.ItemBind;
import com.wyh.slideAdapter.ItemView;
import com.wyh.slideAdapter.SlideAdapter;

import java.util.ArrayList;
import java.util.List;

public class LiftSlideActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Bean> data = new ArrayList<>();
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lift_slide);
        initView();
        initData();
        iniListView();
        setListener();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.activity_lift_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(LiftSlideActivity.this));
    }
    private void iniListView(){
        SlideAdapter.load(data) //加载数据
                .item(R.layout.silde_view_item,0,0,R.layout.right_menu,0.35f)  //指定布局
                .bind(itemBind)
                .padding(2)
                .header(R.layout.recycler_view_header,0.1f)
                .bind(new HeaderBind() {
                    @Override
                    public void onBind(ItemView itemView, int i) {
                        itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                showInfo("you click header");
                            }
                        });
                    }
                })
                .footer(R.layout.load_more_bottom,0.1f)
                .listen(new BottomListener() {
                    @Override
                    public void onBottom(ItemView itemView, SlideAdapter slideAdapter) {
                        itemView.setText(R.id.load_more_bottom,"正在加载...");
                        slideAdapter.loadMore(getMoreData());
                        itemView.setText(R.id.load_more_bottom,"加载完成");
                    }
                })
                .into(recyclerView);
    }
    private List<Bean> getMoreData(){
        List<Bean> data=new ArrayList<>();
        for (int i=0;i<20;i++){
            data.add(new Bean("this is new data"+i+"item"));
        }

        return  data;
    }


    private void initData() {

        try {
            for (int i = 0; i < 20; i++) {
                Bean bean = new Bean("第" + i + "个Item");
                data.add(bean);
            }
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //填充到recyclerView中
    }

    private void setListener() {

    }

    private ItemBind itemBind = new ItemBind<Bean>() {

        @Override
        public void onBind(ItemView itemView, Bean bean, int i) {
            itemView.setText(R.id.textView, data.get(i).getInfo())
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                        showInfo("You Click Item");
                        }
                    })
                    .setOnClickListener(R.id.right_menu_like, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            showInfo("you click right menu");
                        }
                    })
                    .setOnClickListener(R.id.textView, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            showInfo("You Click ChildView");
                        }
                    });
        }
    };




    private void showInfo(String msg){
        if (toast==null){
            toast=Toast.makeText(LiftSlideActivity.this,msg,Toast.LENGTH_SHORT);
        }else{
            toast.setText(msg);
        }
        toast.show();

    }
}
