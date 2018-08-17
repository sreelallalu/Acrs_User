package com.acrs.userapp.ui.buddy.buddy_list;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.acrs.userapp.R;
import com.acrs.userapp.databinding.ActivityBuddyListBinding;
import com.acrs.userapp.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

public class BuddyListActvity extends BaseActivity implements BuddyListView,SwipeRefreshLayout.OnRefreshListener, BuddyListAdapter.OnAdapterListener{


    ActivityBuddyListBinding binding;
    private boolean refreshclick;
    @Inject
    BuddyList_i_presenter<BuddyListView> presenter;
    private BuddyListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_buddy_list);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_buddy_list);
        getActivityComponent().inject(this);
        presenter.onAttach(this);
        initialize();

    }

    @Override
    public void initialize() {
        binding.swipeRefresh.setOnRefreshListener(this);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        listAdapter = new BuddyListAdapter(new ArrayList<BuddyListModel>(), this);
        binding.recycler.setAdapter(listAdapter);
        refreshData();
    }

    @Override
    public void refreshData() {
        if (refreshclick) {
            binding.progressBar.setVisibility(View.GONE);
        } else {
            binding.progressBar.setVisibility(View.VISIBLE);
        }
        refreshclick = false;


        HashMap<String,String> hashMap=new HashMap<>();

        presenter.buddyList(hashMap);
    }

    @Override
    public void onFailerApi() {
        binding.swipeRefresh.setRefreshing(false);
        binding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onSuccessApi(List<BuddyListModel> list) {
        if (list != null && list.size() == 0) {
            super.SnakBarString("Buddy list items empty");
        }
        binding.swipeRefresh.setRefreshing(false);
        binding.progressBar.setVisibility(View.GONE);
        listAdapter.setList(list != null ? list.size() > 0 ? list : new ArrayList<BuddyListModel>() : new ArrayList<BuddyListModel>());
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.swipeRefresh.setRefreshing(true);
                refreshclick = true;
                refreshData();

            }
        }, 1000);
    }

    @Override
    public void adapterItemClick(BuddyListModel item) {

    }
}
