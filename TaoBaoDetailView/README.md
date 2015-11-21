TaoBaoDetailView
================

淘宝宝贝(商品)详情页View(--继续拖动,查看图文详情--)

#### 程序截图：

![http://img.my.csdn.net/uploads/201501/23/1421976457_7683.jpg](http://img.my.csdn.net/uploads/201501/23/1421976457_7683.jpg)
![http://img.my.csdn.net/uploads/201501/23/1421976457_1539.jpg](http://img.my.csdn.net/uploads/201501/23/1421976457_1539.jpg)
![http://img.my.csdn.net/uploads/201501/23/1421976458_8961.jpg](http://img.my.csdn.net/uploads/201501/23/1421976458_8961.jpg)
![http://img.my.csdn.net/uploads/201501/23/1421981509_8851.jpg](http://img.my.csdn.net/uploads/201501/23/1421981509_8851.jpg)

#### 使用说明：

1:需要指定TBLayout的orientation为vertical,并且在TBLayout中添加两个childView,id分别为header和footer;childView可以为任意的View,不一定必须是ScrollView.

<com.taobao.detailview.TBLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/tblayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#646464"
    android:orientation="vertical" >

    <ScrollView
        android:id="@id/header"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#449cfd" >

        <include layout="@layout/page1_scrollview" />
    </ScrollView>

    <ScrollView
        android:id="@id/footer"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#f97171" >

        <include layout="@layout/page2_scrollview" />
    </ScrollView>

</com.taobao.detailview.TBLayout>

2:实现OnPullListener进行事件监听,OnPullListener有两个方法,分别是向上滑动到达第一页底部和向下滑动到达第二页顶部,并且这两个方法有返回值,headerFootReached返回true表示'手指向上滑动时到达第一页底部',footerHeadReached返回true表示'手指向下滑动时到达第二页顶部';在使用的时候需要根据实际情况进行判断然后返回值.(Demo里面有两个例子,分别是ScrollView+ScrollView和ScrollView+ListView)
	
	
	public interface OnPullListener {
		// 手指向上滑动时到达第一页底部
		public boolean headerFootReached(MotionEvent event);

		// 手指向下滑动时到达第二页顶部
		public boolean footerHeadReached(MotionEvent event);
	}
