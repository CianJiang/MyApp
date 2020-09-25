package com.example.myapp;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;

public class ChronometerViewModel extends ViewModel {

    @Nullable
    private Long mStartTime;

    @Nullable
    public Long getStartTime() {
        return mStartTime;
    }

    public void setStartTime(final long startTime) {
        this.mStartTime = startTime;
    }
}
