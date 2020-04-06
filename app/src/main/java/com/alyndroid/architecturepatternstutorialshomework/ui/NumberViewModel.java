package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alyndroid.architecturepatternstutorialshomework.model.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.model.NumberModel;

public class NumberViewModel extends ViewModel {
    private MutableLiveData<String> mutable_live_data;

    public NumberViewModel() {
        this.mutable_live_data = new MutableLiveData<>();
    }

    public void getNumberResult() {
        DataBase data_base = new DataBase();
        NumberModel number_model = data_base.getNumbers();
        String result = number_model.applyOperation("/");
        this.mutable_live_data.setValue(result);
    }

    public MutableLiveData<String> getMutable_live_data() {
        return mutable_live_data;
    }
}


