package com.zhiyong.easy_note_simple.injection.component;

import com.zhiyong.easy_note_simple.ui.home.MainActivity;
import com.zhiyong.easy_note_simple.injection.PerActivity;
import com.zhiyong.easy_note_simple.injection.module.ActivityModule;

import dagger.Component;

/**
 * Created by Zhiyong on 3/28/2019.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)

public interface ActivityComponent {
    void inject(MainActivity activity);
}
