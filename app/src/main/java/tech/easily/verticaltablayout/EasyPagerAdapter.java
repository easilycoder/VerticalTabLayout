package tech.easily.verticaltablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.TextUtils;

/**
 * Created by lemon on 07/01/2018.
 */

public class EasyPagerAdapter extends FragmentPagerAdapter {

    private String key;

    public EasyPagerAdapter(FragmentManager fm, String key) {
        super(fm);
        this.key = key;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        Bundle bundle = new Bundle();
        bundle.putInt("KEY", position);
        if (TextUtils.equals(key, "recycler")) {
            fragment = new EasyRecyclerFragment();
        } else {
            fragment = new EasySimpleFragment();
        }
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
