package com.zhiyong.easy_note_simple.ui.home;

import android.os.Bundle;

import com.zhiyong.easy_note_simple.R;
import com.zhiyong.easy_note_simple.base.BaseDialogActivity;

public class MainActivity extends BaseDialogActivity implements MainMvpView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getmActivityComponent().inject(this);
    }
}
