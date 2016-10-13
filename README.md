Readme
======
本开源项目是各种自定义进度条——ProgressBar。  
工程下的ProgressBar是进度条源码，app是demo演示

用法
---
Android Studio：

1. 在工程根目录build.gradle的仓库里，添加jitpack仓库地址
```
allprojects {
    repositories {

        // +++添加jitpack仓库地址
        maven {url "https://jitpack.io"}
```
2. 在module的build.gradle里，添加依赖
```
dependencies {
    // +++添加依赖
    compile 'com.github.zjun615:ProgressBar:v1.1'
```

---
##目录
* [更新](#更新)
* [1-圆形圆点进度条](#1-圆形圆点进度条)
 * [1_1-三种显示模式](#1_1-三种显示模式)
 * [1_2-使用](#1_2-使用)
 * [1_3-原理分析](#1_3-原理分析)
 

##更新
v1.1：优化百分比的显示，使其苗条点  
    ![苗条点的百分比](img/you004.png)  
v1：圆形圆点进度条


##1-圆形圆点进度条
###1_1-三种显示模式

![三种显示模式](https://github.com/zjun615/ProgressBar/blob/master/img/03.png "三种显示模式")

  模拟加载动画：
  
![模拟加载动画](https://github.com/zjun615/ProgressBar/blob/master/img/04.gif)

###1_2-使用
上面三种显示模式分别对应着如下布局：
```xml
<!--先在基布局中添加命名空间：xmlns:zjun="http://schemas.android.com/apk/res-auto"-->
<RelativeLayout
    xmlns:zjun="http://schemas.android.com/apk/res-auto"
    ...
    >
    
<!--默认显示-->
<com.zjun.progressbar.CircleDotProgressBar
    android:id="@+id/bar_percent"
    android:layout_width="200dp"
    android:layout_height="100dp"
    android:layout_margin="10dp"
    android:background="#94aac1"
    />
    
<!--空显示-->
<com.zjun.progressbar.CircleDotProgressBar
    android:id="@+id/bar_null"
    android:layout_width="200dp"
    android:layout_height="200dp"
    android:layout_below="@+id/bar_percent"
    android:layout_margin="10dp"
    android:background="#94aac1"
    zjun:dotColor="@android:color/holo_green_dark"
    zjun:dotBgColor="@android:color/holo_red_light"
    zjun:showMode="NULL"
    />
    
<!--全显示-->
<com.zjun.progressbar.CircleDotProgressBar
    android:id="@+id/bar_all"
    android:layout_width="200dp"
    android:layout_height="200dp"
    android:layout_below="@+id/bar_null"
    android:layout_margin="10dp"
    android:background="#94aac1"
    zjun:showMode="ALL"
    zjun:percentTextSize="70sp"
    zjun:unitText="分"
    zjun:unitTextAlignMode="CN"
    zjun:unitTextSize="20sp"
    zjun:buttonTextSize="20sp"
    zjun:buttonTopOffset="20dp"
    />
```
###1_3-原理分析
  [参考CSDN博客](http://blog.csdn.net/a10615/article/details/52658927)
  

---
[回到顶部](#readme)
