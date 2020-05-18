package com.example.appforros.ui.plan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlanViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PlanViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("显示建模的地图");
    }

    public LiveData<String> getText() {
        return mText;
    }
}