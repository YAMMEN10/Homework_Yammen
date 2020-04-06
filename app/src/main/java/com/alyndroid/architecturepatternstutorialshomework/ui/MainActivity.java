package com.alyndroid.architecturepatternstutorialshomework.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.databinding.ActivityMainBinding;
import com.alyndroid.architecturepatternstutorialshomework.model.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.model.NumberModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NumberView {
    private ActivityMainBinding activity_main_binding;
    private Presenter presenter;
    private NumberViewModel number_view_model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity_main_binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activity_main_binding.getRoot();
        setContentView(view);

        this.activity_main_binding.plusButton.setOnClickListener(this);
        this.activity_main_binding.mulButton.setOnClickListener(this);
        this.activity_main_binding.divButton.setOnClickListener(this);

        this.presenter = new Presenter(this);
        this.number_view_model = ViewModelProviders.of(this).get(NumberViewModel.class);
        this.number_view_model.getMutable_live_data().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                activity_main_binding.divResultTextView.setText(s);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // MVC Architecture Design Pattern
            case R.id.plus_button:
                NumberModel number_model = new DataBase().getNumbers();
                String plus_result = number_model.applyOperation("+");
                this.activity_main_binding.plusResultTextView.setText(plus_result);
                break;

            // MVP Architecture Design Pattern
            case R.id.mul_button:
                this.presenter.getNumberResult();
                break;
            // MVVM Architecture Design Pattern
            case R.id.div_button:
                number_view_model.getNumberResult();

        }
    }

    @Override
    public void onGetResult(String result) {
        this.activity_main_binding.mulResultTextView.setText(result);
    }
}
