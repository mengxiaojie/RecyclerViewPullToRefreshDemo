# RecyclerViewPullToRefreshDemo

用于recyclerView的下拉刷新和上拉加载

 <com.jingchen.pulltorefresh.PullToRefreshLayout
        android:id="@+id/activity_main_pull_to_refresh"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <!--recyclerView全部替换为该自定义的PullAbleRecyclerView-->
        <com.jingchen.pulltorefresh.PullAbleRecyclerView  
            android:paddingRight="10dp"
            android:paddingLeft="10dp"
            android:id="@+id/activity_main_recycler"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
           />
  </com.jingchen.pulltorefresh.PullToRefreshLayout>

实现接口PullToRefreshLayout.OnPullListener

PullToRefreshLayout pullToRefreshLayout = (PullToRefreshLayout) findViewById(R.id.activity_main_pull_to_refresh);

pullToRefreshLayout.setOnPullListener(this);//设置监听（pullToRefreshLayout为包裹recyclerView的view）

    /** 下拉刷新
     *
     * @param pullToRefreshLayout
     */
    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        Toast.makeText(this, "下拉刷新", Toast.LENGTH_SHORT).show();
        httpGetMessage(0, 15);//网络请求的方法
    }


    /**
     * 上拉加载
     *
     * @param pullToRefreshLayout
     */
    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        Toast.makeText(this, "上拉加载", Toast.LENGTH_SHORT).show();
        httpGetMessage(1, 15);httpGetMessage(0, 15);//网络请求的方法
    }
