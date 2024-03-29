package com.zhiyong.easy_note_simple.base;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import com.zhiyong.easy_note_simple.MyApplication;
import com.zhiyong.easy_note_simple.R;
import com.zhiyong.easy_note_simple.injection.component.ActivityComponent;
import com.zhiyong.easy_note_simple.injection.component.DaggerActivityComponent;
import com.zhiyong.easy_note_simple.injection.module.ActivityModule;

/**
 * Created by Zhiyong on 3/28/2019.
 */

public class BaseActivity extends AppCompatActivity {
    public static final int IN_RIGHT_OUT_LEFT = 1;
    public static final int IN_LEFT_OUT_RIGHT = -1;
    public static final int WITHOUT_ANIMATION = 0;
    ActivityComponent mActivityComponent;

    public ActivityComponent getmActivityComponent(){
        if(mActivityComponent == null){
            mActivityComponent = DaggerActivityComponent.builder()
                    .applicationComponent(MyApplication.get(this).getComponent())
                    .activityModule(new ActivityModule(this))
                    .build();
        }
        return mActivityComponent;
    }

    public void replaceFragment(Fragment fragment, int containerId) {
        replaceFragment(fragment, containerId, 0, true);
    }

    public void replaceFragment(Fragment fragment, int containerId, boolean addToBackStack) {
        replaceFragment(fragment, containerId, 0, addToBackStack);
    }

    public void replaceFragment(Fragment fragment, int containerId, int customAnimations, boolean addToBackStack) {
        if (fragment != null) {
            String backStateName = fragment.getClass().getName();
            boolean fragmentPopped = getSupportFragmentManager().popBackStackImmediate(backStateName, 0);

            if (!fragmentPopped) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if (customAnimations == IN_RIGHT_OUT_LEFT) {
                    transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
                } else if (customAnimations == IN_LEFT_OUT_RIGHT) {
                    transaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
                }
                transaction.replace(containerId, fragment, fragment.getClass().getSimpleName());
                if (addToBackStack) {
                    transaction.addToBackStack(fragment.getClass().getSimpleName()).commit();
                } else {
                    transaction.commit();
                }
            }
        }
    }
}
