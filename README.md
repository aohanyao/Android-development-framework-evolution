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

`注意注意，本系列会进行极致封装，会导致整个框架底层极度耦合，引入需要谨慎`


# 为什么会有这系列文章？
做技术做到一定的程度，总会遇到瓶颈和天花板，能突破就是海阔天空，不能突破就身(hui)死(jia)道(zhong)消(tian)。
而我又是一直在做应用层开发，对底层不是那么的了解，所以突然有一天就萌生了一个想法：将自己的经验从头到尾梳理出来，能更好的帮助自己补漏查缺，如果能够帮助到别人，顺便让自己出名那就更好了。
另外一个原因就是想通过写文章来不断的逼迫自己学习和进步。

# 都会写些什么？
> 1. 从实现最简单的需求开始，不断的对代码结构进行优化、封装，最终形成一套属于自己的快速开发框架。
> 2. 职业生涯中所遇到的一些奇葩需求及解决方案。
> 3. 各种常见、不常见的问题解决方法。
> 4. 其它一些为了偷懒延伸的一些不为人知的小技巧。
> 6. 工作之中：提高效率和摸鱼🐟的工具和技巧。
> 7. 编码之外：生活、职业、扯淡。
> 8. 代码之外的相关事宜，如BranchMode、CI等。



# 基础

## 技术选型
- Design
- RxJava2
- Retrofit2
- MVP
- Kotlin

## 技术基础文章
RxJava2入门文章请看[这可能是最好的RxJava 2.x 教程（完结版）](https://www.jianshu.com/p/0cd258eecf60)

# 本系列文章
- [x] [Android 之路 (1) - RxJava2+Retrofit实现简单登陆](http://fullscreendeveloper.cn/articles/2018/10/08/1538984930011.html)
- [x] [Android 之路 (2) - 对登陆进行 MVP 改造](http://fullscreendeveloper.cn/articles/2018/10/09/1539084359439.html)
- [x] [Android 之路 (3) - 对Retrofit的封装](http://fullscreendeveloper.cn/articles/2018/10/10/1539167974165.html)
- [x] [Android 之路 (4) - 对RxJava2的简单封装](http://fullscreendeveloper.cn/articles/2018/10/11/1539255083332.html)
- [x] [Android 之路 (5) - 对Dialog的简单封装](http://fullscreendeveloper.cn/articles/2018/10/13/1539412875888.html)
- [x] [Android 之路 (6) - 关于Toast和Log的封装](http://fullscreendeveloper.cn/articles/2018/11/07/1541580610117.html)
- [x] [Android 之路 (7) - 对BaseActivity的简单封装](http://fullscreendeveloper.cn/articles/2019/05/06/1557135966652.html)
- [x] [Android 之路 (8) - Toolbar - NavigationIcon间隙、Title居中、BackText适配](http://fullscreendeveloper.cn/articles/2019/05/17/1558090070765.html)
- [x] [Android 之路 (9) - 第一个AS工程代码模板](http://fullscreendeveloper.cn/articles/2019/05/19/1558235126435.html)
- [x] [Android 之路 (10) - 集成滑动返回(SwipeBackLayout)](http://fullscreendeveloper.cn/articles/2019/05/20/1558344854226.html)
- [x] [Android 之路 (11) - 对Toolbar的封装-实现渐变标题栏与沉浸适配](http://fullscreendeveloper.cn/articles/2019/05/23/1558614398661.html)
- [x] [Android 之路 (12) - RxLifecycle的集成](http://fullscreendeveloper.cn/articles/2019/05/31/1559294685034.html)
- [x] [Android 之路 (13) - RxJava请求结果预处理、多数据结构适配及统一错误处理](http://fullscreendeveloper.cn/articles/2019/10/16/1571213647696.html)


# 其他
## 什么时候更新
> 不定时更新，看工作情况吧。
> 更新的时候会在微信公众号、个人博客、简书同步更新。
> 每次文章都会对应一个release版本，下载源码的时候注意对应某个版本。

## 关于我
1. Android Dev
3. 我的独立域名[博客](fullscreendeveloper.cn)
4. 我的邮箱[aohanyao@gmail.com](aohanyao@gmail.com)
5. 我的[GitHub](https://github.com/aohanyao)


# 微信公众号
> 扫描二维码，关注公众号，时不时会悄悄的推送一些小技巧的文章~~
> 如果我的文章和代码对你有了帮助，请给我一个star和关注~~

![AndroidRookie](https://avatars1.githubusercontent.com/u/13215774?s=460&v=4)
