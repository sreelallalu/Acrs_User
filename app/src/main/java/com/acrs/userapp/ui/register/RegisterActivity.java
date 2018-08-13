package com.acrs.userapp.ui.register;

import android.os.Bundle;
import android.view.View;

import com.acrs.userapp.R;
import com.acrs.userapp.ui.base.BaseActivity;

import javax.inject.Inject;

public class RegisterActivity extends BaseActivity implements RegisterView ,View.OnClickListener{


    @Inject
    Register_i_presenter<RegisterView> presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getActivityComponent().inject(this);
        presenter.onAttach(this);
        initialize();
    }

    @Override
    public void initialize() {

    }

    @Override
    public void onClick(View v) {

    }
}
