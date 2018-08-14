package com.acrs.userapp.ui.dashboard;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.acrs.userapp.R;
import com.acrs.userapp.databinding.ActivityDashboardBinding;
import com.acrs.userapp.ui.base.BaseActivity;
import com.acrs.userapp.ui.buddy.buddy_list.BuddyListActvity;
import com.acrs.userapp.ui.emergency.EmergencyActvity;
import com.acrs.userapp.ui.medicine.medicine_list.MedicineListActvity;
import com.acrs.userapp.ui.notification.NotificationActivtiy;

import javax.inject.Inject;

public class DashboardActivty extends BaseActivity implements DashboardView, View.OnClickListener {


    @Inject
    Dashboard_i_presenter<DashboardView> presenter;
    ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_dashboard);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
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
     binding.buddy.setOnClickListener(this);
     binding.notification.setOnClickListener(this);
     binding.emergency.setOnClickListener(this);
     binding.medicine.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == binding.buddy.getId()) {

            Intent intent=new Intent(this, BuddyListActvity.class);
            startActivity(intent);
        }
        if (v.getId() == binding.emergency.getId()) {
            Intent intent=new Intent(this, EmergencyActvity.class);
            startActivity(intent);
        }
        if (v.getId() == binding.medicine.getId()) {
            Intent intent=new Intent(this, MedicineListActvity.class);
            startActivity(intent);
        }
        if (v.getId() == binding.notification.getId()) {
            Intent intent=new Intent(this, NotificationActivtiy.class);
            startActivity(intent);
        }
    }
}
