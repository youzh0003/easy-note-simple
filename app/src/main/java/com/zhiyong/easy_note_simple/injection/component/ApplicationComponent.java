package com.zhiyong.easy_note_simple.injection.component;

import android.app.Application;
import android.content.Context;

import com.zhiyong.easy_note_simple.injection.ApplicationContext;
import com.zhiyong.easy_note_simple.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Zhiyong on 3/28/2019.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class
})
public interface ApplicationComponent {
    @ApplicationContext
    Context context();

    Application application();
}
