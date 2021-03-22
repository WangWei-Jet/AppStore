package com.whty.zd.appstore.di.module;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;

import dagger.Module;
import dagger.Provides;
import com.whty.zd.appstore.di.scope.ContextLife;
import com.whty.zd.appstore.di.scope.PerFragment;

/**
 * @author: wangwei
 * @date: 2017/7/30 15:38
 * @desciption:
 */
@Module
public class FragmentModule {

    private Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        this.mFragment = fragment;
    }

    @Provides
    @PerFragment
    public Fragment provideFragment() {
        return mFragment;
    }

    @Provides
    @PerFragment
    public Activity provideFragmentActivity() {
        return mFragment.getActivity();
    }

    @Provides
    @PerFragment
    @ContextLife("Activity")
    public Context provideFragmentContext() {
        return mFragment.getContext();
    }
}
