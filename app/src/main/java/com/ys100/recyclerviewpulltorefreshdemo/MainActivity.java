package com.ys100.recyclerviewpulltorefreshdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.jingchen.pulltorefresh.PullAbleRecyclerView;
import com.jingchen.pulltorefresh.PullToRefreshLayout;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements PullToRefreshLayout.OnPullListener {

    private PullAbleRecyclerView mRecycler;
    private PullToRefreshLayout pullToRefreshLayout;

    private RecyclerViewAdapter mAdapter;

    private AppContext mApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mApp = (AppContext) getApplication();
        mRecycler = (PullAbleRecyclerView) findViewById(R.id.activity_main_recycler);

        pullToRefreshLayout = (PullToRefreshLayout) findViewById(R.id.activity_main_pull_to_refresh);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(manager);
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strings.add("meng");
        }

        mAdapter = new RecyclerViewAdapter(this, strings);
        mRecycler.setAdapter(mAdapter);

        pullToRefreshLayout.setOnPullListener(this);//设置监听


    }


    /**
     * 下拉刷新
     *
     * @param pullToRefreshLayout
     */
    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        Toast.makeText(this, "下拉刷新", Toast.LENGTH_SHORT).show();
        httpGetMessage(0, 15);
    }


    /**
     * 上拉加载
     *
     * @param pullToRefreshLayout
     */
    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        Toast.makeText(this, "上拉加载", Toast.LENGTH_SHORT).show();
        httpGetMessage(1, 15);
    }


    public void httpGetMessage(final Object pageNum, final Object pageSize) {

        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap.put("token", "");
        dataMap.put("pageNum", pageNum);
        dataMap.put("pageSize", pageSize);
        JSONObject obj = new JSONObject(dataMap);
        String url = "http://show.ys100.com/" + "dataApi.php" + "?mod=10&act=1&data=" + obj.toString();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pullToRefreshLayout.refreshFinish(PullToRefreshLayout.SUCCEED);//刷新成功后调用
                pullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.SUCCEED);//加载成功后调用
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        stringRequest.setTag(this);
        mApp.mRequestQueue.add(stringRequest);
    }
}
