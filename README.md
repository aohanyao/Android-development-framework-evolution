# Android development framework evolution
从实现最简单的需求开始，不断的对代码结构进行优化、封装，最终形成一套属于自己的快速开发框架。

# 前言
UI方面主要以Design包为基准，网络及异步操作选用RxJava2+Retrofit，现阶段开发语言使用Java，在慢慢的演进中逐步替换为Kotlin，以Google Sample的标准MVP模式为基准，逐渐演进成为自己的MVP变种，然后做各种各样的底层封装，写少的代码实现相同的功能，最后进行模块代码和Freemarker进行代码外的封装，生成大部分代码，最终只关注与业务层面和UI效果的处理。

目标是：

>写得少，错的少！

举个🌰:
就我们平常要写的一个数据列表，只需要二十分钟毫无压力。主要使用模板代码生成 Activity、activity_layout、Presenter、Bean、Param、Adapter、list_item_layout、包含刷新、加载更多、点击事件的配置，而我们要做的只有以下几件事：
> 1. bean的字段填充
> 2. list_item_layout布局编写
> 3. Adapter设置数据和事件
> 4. Presenter返回网络请求数据
> 5. Activity中做点击事件后的回调处理

以上，是写一个列表要做的事情，看上去比较抽象，后面会录制一个视频，这样比较直观。

**注意注意，本系列会进行极致封装，会导致整个框架底层极度耦合，引入需要谨慎**
**注意注意，本系列会进行极致封装，会导致整个框架底层极度耦合，引入需要谨慎**
**注意注意，本系列会进行极致封装，会导致整个框架底层极度耦合，引入需要谨慎**

# 基础

## 技术选型
- Design
- RxJavva2
- Retrofit2
- MVP
- Kotlin

## 技术基础文章
RxJava2入门文章请看[这可能是最好的RxJava 2.x 教程（完结版）](https://www.jianshu.com/p/0cd258eecf60)

# 本系列文章
- [ ] Android 之路  - 序章
- [ ] Android 之路 (1) - RxJava2+Retrofit实现简单登陆
- [ ] Android 之路 (2) -  对登陆进行 MVP 改造
- [ ] Android 之路 (3) - 对Retrofit的封装
- [ ] Android 之路 (4) - 对RxJava2的简单封装
- [ ] Android 之路 (5) - 对Dialog的简单封装
- [ ] Android 之路 (6) - 关于Toast和Log
- [ ] Android 之路 (7) - 对BaseActivity的简单封装

# 番外文章
## Android Studio 笔记
- [x] [AndroidStudio笔记（1）快捷键](http://fullscreendeveloper.cn/articles/2018/09/10/1536590832437.html)
- [x] [AndroidStudio笔记（2）插件介绍](http://fullscreendeveloper.cn/articles/2018/09/11/1536678117082.html)
- [x] [AndroidStudio笔记（3）提升效率的 Live Templates ](http://fullscreendeveloper.cn/articles/2018/09/12/1536765324727.html)
- [x] [AndroidStudio笔记（4）编码效率+1 的 File Templates ](http://fullscreendeveloper.cn/articles/2018/09/13/1536850894421.html)
- [ ] AndroidStudio笔记（5）懒人养成的Code Templates
- [ ] AndroidStudio笔记（6）开发一个属于自己的插件
- [ ] [AndroidStudio笔记（7）字符串格式](http://fullscreendeveloper.cn/articles/2018/09/25/1537868394945.html)

## Gradle系列课程
- [x] [Gradle 使用技巧 - 构建变种](http://fullscreendeveloper.cn/articles/2018/03/02/1519975134176.html)
- [x] [Gradle之强制依赖某个第三方库 ](http://fullscreendeveloper.cn/articles/2018/03/02/1519975134000.html)
- [x] [Gradle使用技巧(一)](http://fullscreendeveloper.cn/articles/2018/08/29/1535528412249.html)
- [x] [Gradle 使用技巧(二) - SO/NDK过滤 ](http://fullscreendeveloper.cn/articles/2018/08/29/1535529222971.html)
- [x] [Gradle 使用技巧(三)  - dependencies 的类型与区别](http://fullscreendeveloper.cn/articles/2018/08/29/1535529293811.html)
- [x] [Gradle 使用技巧(四)  - 如何定位和解决依赖冲突](http://fullscreendeveloper.cn/articles/2018/08/29/1535529405791.html)
- [x] [Gradle 使用技巧(五) - AAR](http://fullscreendeveloper.cn/articles/2018/08/29/1535529472067.html)
- [x] [Gradle 使用技巧(六) - 使用统一的Gradle管理 ](http://fullscreendeveloper.cn/articles/2018/08/29/1535529528287.html)
- [x] [Gradle 使用技巧(七) - 10分钟将快速开源 Jitpack 与增加中文注释](http://fullscreendeveloper.cn/articles/2018/09/03/1535976021124.html)
- [ ] Gradle 使用技巧(八) - 常用task详讲
- [ ]  Gradle 使用技巧(九) - 快速NDK
- [ ] Gradle 使用技巧(十) - 加速编译、减少内存消耗
- [ ] Gradle 使用技巧(十一) - 快速编译从Github上面down下来的项目
- [ ] Gradle 使用技巧(十二) - Res文件夹过滤


## 自定义View

- [x] [Material Design系列 - 自定义Behavior实现伸缩标题栏](http://fullscreendeveloper.cn/articles/2018/09/04/1536071602996.html)
- [ ]  [Material Design系列- CollapsingToolbarLayout 和AppBarLayout](http://fullscreendeveloper.cn/articles/2018/08/30/1535643303186.html)
- [ ] Material Design系列 - 自定义Behavior实现支付宝标题栏
- [x] [自定义View - 简单的TextView封装](http://fullscreendeveloper.cn/articles/2018/08/30/1535558839110.html)
- [ ] 自定义View之DifferentViewPagerIndicator
- [ ] 自定义View实现流程图
- [x] [Android初级进阶之自定义酷炫菜单 ](http://fullscreendeveloper.cn/articles/2016/08/26/1519975131343.html)
- [x] [Android初级进阶之自定义View之SafeVeiw](http://fullscreendeveloper.cn/articles/2016/08/22/1519975130052.html)
- [x] [Android初级进阶之自定义果冻视图(BouncingJellyView)(二) ](http://fullscreendeveloper.cn/articles/2018/03/02/1519975130751.html)
- [x] [Android初级进阶之自定义时钟(一) ](http://fullscreendeveloper.cn/articles/2016/08/09/1519975130255.html)
- [x] [Android初级进阶之自定义时钟(二)](http://fullscreendeveloper.cn/articles/2016/08/09/1519975130505.html)
- [x] [Android初级进阶之自定义果冻视图 ](http://fullscreendeveloper.cn/articles/2016/09/05/1519975131096.html)
- [x] [PageTransformer实现一个层叠的卡片](http://fullscreendeveloper.cn/articles/2018/03/02/1519975134703.html)
- [x] [水平循环滑动的View(HorizontalLoopView)](http://fullscreendeveloper.cn/articles/2018/03/02/1519975135238.html)
- [x] [自定义View -简单的 SwitchView](http://fullscreendeveloper.cn/articles/2018/09/09/1536492310203.html)


## Android开发中的代码片段
- [x] [Android 开发中的代码片段（1）](http://fullscreendeveloper.cn/articles/2018/09/09/1536492082162.html)
- [x] [Android 开发中的代码片段（2）复制对象之间的属性值](http://fullscreendeveloper.cn/articles/2018/09/09/1536492205566.html)
- [x] [ Android 开发中的代码片段（3）地图操作相关](http://fullscreendeveloper.cn/articles/2018/09/15/1537024433520.html)

## Android小技巧
- [x] [Android小技巧之来不及解释了快上车--EventBus3 ](http://fullscreendeveloper.cn/articles/2016/08/10/1519975132224.html)
- [x] [Android小技巧之不缓存的ViewPager ](http://fullscreendeveloper.cn/articles/2016/08/09/1519975131631.html)
- [x] [Android小技巧之最快速简单的悬浮TAB ](http://fullscreendeveloper.cn/articles/2016/08/22/1519975132044.html)
- [x] [Android开发小技巧之不再使用原生的WebView了 ](http://fullscreendeveloper.cn/articles/2016/09/22/1519975132398.html)
- [x] [Android开发小技巧之商品属性筛选与商品筛选 ](http://fullscreendeveloper.cn/articles/2016/09/12/1519975132580.html)
- [x] [Android小技巧之无限循环的ViewPager ](http://fullscreendeveloper.cn/articles/2016/08/25/1519975131863.html)
## kotlin系列
- [x] [Kotlin从入门到夺门而出(1) - 开坑篇](http://fullscreendeveloper.cn/articles/2018/09/05/1536160481345.html)
- [x] [Kotlin从入门到夺门而出(2) - Kotlin与Java语法区别](http://fullscreendeveloper.cn/articles/2018/09/19/1537368221930.html)
- [ ] Kotlin从入门到夺门而出(3) - HelloWorld
- [ ] 泛型多指定


## 面试题库
- [x] [Android面试题库 - Service（一） - 基础](http://fullscreendeveloper.cn/articles/2018/09/07/1536332462383.html)
- [x] [Android面试题库 - Activity（一） - 基础](http://fullscreendeveloper.cn/articles/2018/09/01/1535816739894.html)
- [x] Android面试题库 - Boradcast Receiver（一） - 基础
- [x] [Android面试题库 - Fragment（一） - 基础](http://fullscreendeveloper.cn/articles/2018/09/02/1535901570200.html)

## python系列
- [x] [python语法](http://fullscreendeveloper.cn/articles/2018/09/17/1537193474653.html)
## Java系列


## 服务端系列
- [x] [Centos安装Shadowsocks与配置 ](http://fullscreendeveloper.cn/articles/2018/03/02/1519975133482.html)
- [x] [Tomcat的安装与配置](http://fullscreendeveloper.cn/articles/2018/03/02/1519975134529.html)
- [x] [Linux-JDK安装与配置环境搭建 ](http://fullscreendeveloper.cn/articles/2018/03/02/1519975134347.html)
- [x] [Centos 6下MySQL安装与配置 ](http://fullscreendeveloper.cn/articles/2018/03/02/1519975133116.html)
- [x] [Centos下 Nginx安装与配置 ](http://fullscreendeveloper.cn/articles/2018/03/02/1519975133297.html)

## 其它文章
- [x] [常用正则表达式](http://fullscreendeveloper.cn/articles/2018/09/18/1537281359392.html)
- [x] [Http响应码含义
](http://fullscreendeveloper.cn/articles/2018/05/22/1526967033410.html)
