package com.example.aa.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.aa.search.App.App;
import com.example.aa.search.model.Search;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aa on 2016/3/31.
 */
public class RecyclerViewActivity extends BaseActivity {
    private String url = "http://139.129.5.0/html/site_test/form_action.php";
    //    private String url = "www.baidu.com";
    private RecyclerView recyclerView;
    private String searchvalue;
    private MyRecycleViewAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();

    }


    @Override
    public void registerListener() {
    }

    @Override
    public void findViews() {
        setContentView(R.layout.act_recycle);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    //初始化数据
    private void initData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            searchvalue = bundle.getString("searchvalue");

            App.mQueue.add(new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String s) {
                    Search search = com.alibaba.fastjson.JSONObject.parseObject(s, Search.class);
                    adapter = new MyRecycleViewAdapter();
                    recyclerView.setAdapter(adapter);
                    adapter.setData(search);
                    Log.e("sihuan", adapter.getItemCount() + "");
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    Log.e("sihuan", volleyError.toString());
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap map = new HashMap();
                    map.put("content", searchvalue);
                    return map;
                }
            });

        }

    }

    class MyRecycleViewAdapter extends RecyclerView.Adapter {
        private Search search;

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(RecyclerViewActivity.this, R.layout.item_recycler, null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            ViewHolder v = (ViewHolder) holder;
            v.title.setText(search.list.get(position).title);
            v.content.setText(search.list.get(position).content);
            v.root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(RecyclerViewActivity.this, WebViewActivity.class);
                    i.putExtra("url", search.list.get(position).url);
                    startActivity(i);
                }
            });
        }

        @Override
        public int getItemCount() {
            return search.list == null ? 0 : search.list.size();
        }

        public void setData(Search search) {
            this.search = search;
            notifyDataSetChanged();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private TextView title;
            private TextView content;
            private View root;

            public ViewHolder(View itemView) {
                super(itemView);
                root = itemView;
                title = (TextView) itemView.findViewById(R.id.title);
                content = (TextView) itemView.findViewById(R.id.content);
            }
        }

    }

}
