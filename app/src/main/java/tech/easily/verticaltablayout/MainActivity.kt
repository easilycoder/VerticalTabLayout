package tech.easily.verticaltablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = ViewPager2FragmentStateAdapter(this, getFragmentList())
        // 设置Fragment切换的Adapter
        viewPager2.adapter = adapter
        // 垂直方向滚动ViewPager2
        viewPager2.orientation = ViewPager2.ORIENTATION_VERTICAL
        // 禁止预加载
        viewPager2.offscreenPageLimit = ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT
        // TabLayout和ViewPager2绑定同时设置Tab标题
        tabLayout.setupWithViewPager2(viewPager2, getTabTitleList())
    }

    fun getFragmentList(): List<Fragment> {
        val fragments: MutableList<Fragment> = ArrayList()
        fragments.add(TestFragment())
        fragments.add(TestFragment())
        return fragments
    }

    fun getTabTitleList(): List<String> {
        val fragments: MutableList<String> = ArrayList()
        fragments.add("页面 1")
        fragments.add("页面 2")
        return fragments
    }
}
