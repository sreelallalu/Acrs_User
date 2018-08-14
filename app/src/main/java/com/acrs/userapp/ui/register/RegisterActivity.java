package com.acrs.userapp.ui.register;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;

import com.acrs.userapp.R;
import com.acrs.userapp.databinding.ActivityRegisterBinding;
import com.acrs.userapp.ui.base.BaseActivity;
import com.acrs.userapp.ui.dashboard.DashboardActivty;

import java.util.HashMap;

import javax.inject.Inject;

public class RegisterActivity extends BaseActivity implements RegisterView, View.OnClickListener {


    @Inject
    Register_i_presenter<RegisterView> presenter;

    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        getActivityComponent().inject(this);
        presenter.onAttach(this);
        initialize();
    }

    @Override
    public void initialize() {
        binding.register.setOnClickListener(this);
    }

    @Override
    public void register() {

        String name = binding.name.getText().toString();
        String mobile = binding.mobile.getText().toString();
        String email = binding.email.getText().toString();
        String password = binding.password.getText().toString();
        boolean check = true;

        if (name != null && name.length() < 33) {
            check = false;
              binding.name.setError("Invalid name");
        }
        if (mobile != null && mobile.length() < 10) {
            check = false;
            binding.mobile.setError("Invalid mobile");

        }
        if (email != null && !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            check = false;
            binding.email.setError("Invalid email");

        }
        if (email != null && password.length() < 3) {
            check = false;
            binding.password.setError("Invalid password");

        }
        if(check)
        {

            binding.name.setError(null);
            binding.mobile.setError(null);
            binding.email.setError(null);
            binding.password.setError(null);
            super.progresShow(true);
            HashMap<String,String> hashMap=new HashMap<>();
            hashMap.put(RegisterWebApi.RegisterParms.NAME,name);
            hashMap.put(RegisterWebApi.RegisterParms.EMAIL,email);
            hashMap.put(RegisterWebApi.RegisterParms.PASSWORD,password);
            hashMap.put(RegisterWebApi.RegisterParms.MOBILE,mobile);

            presenter.register(hashMap);

        }


    }

    @Override
    public void onFailerApi() {
        super.progresShow(false);
    }

    @Override
    public void onSuccessApi() {
        super.progresShow(false);
        SnakBarCallback("Registration Success", new Callback() {
            @Override
            public void back() {
                Intent intent=new Intent(RegisterActivity.this, DashboardActivty.class);
                startActivity(intent);
                finish();

            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == binding.register.getId()) {
            register();
        }

    }
}
