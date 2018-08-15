package com.acrs.userapp.ui.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.acrs.userapp.R;
import com.acrs.userapp.databinding.ActivityLoginBinding;
import com.acrs.userapp.ui.base.BaseActivity;
import com.acrs.userapp.ui.dashboard.DashboardActivty;
import com.acrs.userapp.ui.register.RegisterActivity;

import java.util.HashMap;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements LoginView, View.OnClickListener {

    @Inject

    Login_i_presenter<LoginView> presenter;
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
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
    public void onClick(View v) {
        if (v.getId() == binding.login.getId()) {
            loginClick();

        }
        if (v.getId() == binding.register.getId()) {

            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void initialize() {

        binding.login.setOnClickListener(this);
        binding.register.setOnClickListener(this);

    }

    @Override
    public void loginClick() {
        String name = binding.name.getText().toString();
        String password = binding.password.getText().toString();
        boolean check = true;
        if (name != null && name.length() < 3) {
            binding.name.setError("Invalid name");
            check = false;
        }
        if (password != null && password.length() < 3) {
            binding.password.setError("Invalid password");
            check = false;

        }
        if (check) {
            progresShow(true);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(LoginWebApi.LoginParams.NAME, name);
            hashMap.put(LoginWebApi.LoginParams.PASSWRD, password);
            presenter.loginApiCall(hashMap);

        }

    }

    @Override
    public void register() {

        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);


    }


    @Override
    public void onFailerApi() {
        progresShow(false);
    }

    @Override
    public void onSuccessApi() {
        progresShow(false);
        SnakBarCallback("Login Success", new Callback() {
            @Override
            public void back() {

                Intent intent = new Intent(LoginActivity.this, DashboardActivty.class);
                startActivity(intent);
                finish();

            }
        });


    }
}
