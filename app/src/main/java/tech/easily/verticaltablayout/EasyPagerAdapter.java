package tech.easily.verticaltablayout;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
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
