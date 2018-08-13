package com.acrs.userapp.ui.dashboard;

import android.os.Bundle;
import android.view.View;

import com.acrs.userapp.R;
import com.acrs.userapp.ui.base.BaseActivity;

import javax.inject.Inject;

public class DashboardActivty extends BaseActivity implements DashboardView,View.OnClickListener {


    @Inject
    Dashboard_i_presenter<DashboardView> presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
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



    }

    @Override
    public void onClick(View v) {

    }
}
