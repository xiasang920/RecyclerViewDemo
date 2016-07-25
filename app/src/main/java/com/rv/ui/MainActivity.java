package com.rv.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.rv.adapter.MyRVAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView rv;
    private MyRVAdapter adapter;
    private List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) F(R.id.toobar);
        toolbar.setTitle("RecyclerView");
        setSupportActionBar(toolbar);
        //初始化控件
        rv = (RecyclerView) F(R.id.rv);
        data = getData();  //虚拟数据源
        adapter = new MyRVAdapter(this,data);
        //设置布局管理器
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //设置item发生变化时的动画效果
        rv.setItemAnimator(new DefaultItemAnimator());
        //绑定适配器
        rv.setAdapter(adapter);


    }

    private List<String> getData() {
        data = new ArrayList<String>();
        for (int i = 0;i<30;i++){
            data.add(String.format("第%s个item",i+""));
        }
        return data;
    }

    private View F(int viewId){
       return this.findViewById(viewId);
   }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";
        switch (item.getItemId()){
            case R.id.ll_v:
                msg += "线性纵向";
                rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
                break;
            case R.id.ll_h:
                msg += "线性横向 ";
                rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
                break;
            case R.id.gv:
                msg += "网格";
                rv.setLayoutManager(new GridLayoutManager(this,3));
                break;
        }
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        return true;
    }
}
