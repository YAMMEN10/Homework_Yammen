package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.model.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.model.NumberModel;

public class Presenter {
    private NumberView number_view;

    public Presenter(NumberView number_view) {
        this.number_view = number_view;
    }

    public void getNumberResult() {
        DataBase data_base = new DataBase();
        NumberModel number_model = data_base.getNumbers();
        String result = number_model.applyOperation("*");
        number_view.onGetResult(result);
    }
}
