package com.acrs.userapp.ui.medicine.medicine_list;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.acrs.userapp.R;
import com.acrs.userapp.databinding.ActivityMedicineListBinding;
import com.acrs.userapp.ui.base.BaseActivity;

import java.util.ArrayList;

import javax.inject.Inject;

public class MedicineListActvity extends BaseActivity implements MedicineListView, SwipeRefreshLayout.OnRefreshListener, MedicineAdapter.OnAdapterListener {


    @Inject
    MedicineList_i_presenter<MedicineListView> presenter;
    ActivityMedicineListBinding binding;
    private boolean refreshclick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_medicine_list);
        getActivityComponent().inject(this);
        presenter.onAttach(this);
        initialize();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }

    @Override
    public void initialize() {
        binding.swipeRefresh.setOnRefreshListener(this);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        MedicineAdapter listAdapter = new MedicineAdapter(new ArrayList<MedicineListModel>(), this);
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

        presenter.medicineListApi();
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
    public void adapterItemClick(MedicineListModel item) {

    }
}
