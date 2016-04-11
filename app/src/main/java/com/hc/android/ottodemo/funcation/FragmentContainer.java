package com.hc.android.ottodemo.funcation;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 99165 on 2016/3/30.
 */
public final class FragmentContainer {

    private static FragmentContainer fragmentContainer;
    private static Map<String, Fragment> fragmentMap = new HashMap<>();

    private FragmentContainer() {

    }

    public static FragmentContainer getFragmentContainer() {
        if (fragmentContainer == null) synchronized (FragmentContainer.class) {
            fragmentContainer = new FragmentContainer();
        }
        return fragmentContainer;
    }


    /**
     * 获得缓存的Fragemnt
     *
     * @param fragmentClass
     * @return
     */
    public static Fragment getFragment(Class<Fragment> fragmentClass) {
        return getFragment(fragmentClass.getSimpleName());
    }

    public static Fragment getFragment(String fragmentSimpleName) {
        if (!fragmentMap.containsKey(fragmentSimpleName)) {
            throw new NullPointerException("not find fragment with name: " + fragmentSimpleName);
        }
        return fragmentMap.get(fragmentSimpleName);
    }


    /**
     * 添加一个Fragment缓存
     *
     * @param fragment
     */
    public static void addFragment(Fragment fragment) {
        addFragment(fragment.getClass().getSimpleName(), fragment);
    }

    public static void addFragment(String fragmentSimple, Fragment fragment) {
        fragmentMap.put(fragmentSimple, fragment);
    }
}
