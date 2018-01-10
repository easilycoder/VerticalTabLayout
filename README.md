# VerticalTabLayout & VerticalViewPager

纵向布局的TabLayout和纵向切换的ViewPager



## 实现方案

### VerticalTabLayout

参考了GitHub上这个开源项目[VerticalTabLayout](https://github.com/qstumn/VerticalTabLayout)以及官方的TabLayout的实现，大部分代码拷贝于官方的TabLayout的源码实现。作出了以下的几点修改

* 新增了`ViewPagerTabItemCreator`，支持在绑定`ViewPager`的时候使用自定义的TabItem视图。

  ```java
  public interface ViewPagerTabItemCreator {	
  	VerticalTab create(int position);
  }
  ```

  对应的使用的代码块为

  ```java
  private void populateFromPagerAdapter(ViewPagerTabItemCreator creator) {
          removeAllTabs();
          if (mPagerAdapter != null) {
              final int adapterCount = mPagerAdapter.getCount();
              for (int i = 0; i < adapterCount; i++) {
                  String title = mPagerAdapter.getPageTitle(i) == null ? "tab" + i : mPagerAdapter.getPageTitle(i).toString();
                  if(creator!=null){
                      addTab(creator.create(i), false);
                  }else {
                      addTab(newTab().setText(title),false);
                  }
              }
              if (mViewPager != null && adapterCount > 0) {
                  final int curItem = mViewPager.getCurrentItem();
                  if (curItem != getSelectedTabPosition() && curItem < getTabCount()) {
                      selectTab(getTabAt(curItem));
                  }
              }
          }
      }
  ```

* 更改了官方的TabLayou的自定义view的使用策略（官方的自定义tabiten的样式是受限制的，要有固定id的`ImageView`和固定id的`TextView`），添加了新的接口

  ```java
  public interface OnCustomTabViewRenderListener {
      /**
       * 当需要tab的item需要自定义view的时候，通过这个接口方法通知视图渲染
       *
       * @param tab
       */   
  	void onRender(VerticalTab tab);
  }
  ```

* `Tab`更换为`VerticalTab`

* 修改实现的`TabView`

除此之外，逻辑基本保持与官方的TabLayout一致

###  VerticalViewPager

垂直切换的`ViewPager`提供了两种常规方案：

* 基于`ViewPager.PageTransformer`实现。会存在嵌套recyclerview的滑动冲突问题

* 修改`ViewPager`的源码，做对应的修改。可以看这个项目[InfiniteCycleViewPager](https://github.com/Devlight/InfiniteCycleViewPager)

  ​

## 方案使用 

不管是`VerticalTabLayout`还是`VerticalViewPager`，两者的使用方法都与官方的使用API和方法一致。对于`VerticalTabLayout`存在的差异有

* 不支持在xml文件中嵌套使用`TabItem`添加tab
* `setupWithViewPager()`可以携带一个接口对象，用于自定义tab的视图
* xml中支持定义的属性不同，详情可以参考`attrs.xml`当中的定义

具体可以参考demo

## 实现效果

![](/sample.gif)