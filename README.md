## Fresco 的封装，快速上手，图像后处理，超大图高清预览，缩小放大，双击放大等一一俱全。

[![](https://jitpack.io/v/CarGuo/FrescoUtils.svg)](https://jitpack.io/#CarGuo/FrescoUtils)
[![Build Status](https://travis-ci.org/CarGuo/FrescoUtils.svg?branch=master)](https://travis-ci.org/CarGuo/FrescoUtils)

### [新 GSYImageLoader 图片加载工具，集成Glide、Picasso、Fresco的图片加载管理器](https://github.com/CarGuo/GSYImageLoader)

## 依赖

#### 在project下的build.gradle添加
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
#### 在module下的build.gradle添加
```
dependencies {
    compile 'com.github.CarGuo:FrescoUtils:v1.2.1'
}

```

-----------------------------

####  1.2.1

update fresco to 1.8.0


####  1.1.0

update fresco to 1.7.1

update subsampling-scale-image-view to 3.9.0

update photodraweeview to 1.1.3

update gradle to 4.0.1

#### 1.0.8

update fresco to 1.5.0


#### 1.0.7 增加option配置方法；

```
/**
 * @param imageView  图片加载控件
 * @param loadOption 加载配置构造器
 */
public static void loadFrescoImage(FrescoImageView imageView, LoadOption loadOption) 
```

* 1.0.6 update fresco to 1.3.0；

* 1.0.5 update fresco to 1.2.0；移除无用依赖；

* 1.0.4 update fresco to 1.0.1，update scaleImage to 3.6.0

* 1.0.3 update fresco to 1.0.0

* 1.0.2 最低API调整到15

* 1.0.1 增加了额FrescoHelper直接超大图加载接口

```
/**
 * 超大图片的就接口
 *
 * @param context   上下玩
 * @param imageView 图片加载控件
 * @param imageUri  图片地址
 * @param defaultId 默认失败图片
 */
public static void loadBigImage(final Context context, final SubsamplingScaleImageView imageView, String imageUri, final int defaultId)
```

<h4><a href="http://www.jianshu.com/p/cd058a924288">简书入口 这里有详细介绍</a></h4>

## 效果显示
<img src="https://github.com/CarGuo/FrescoUtils/blob/master/01.jpg" width="240px" height="426px"/>
<img src="https://github.com/CarGuo/FrescoUtils/blob/master/02.jpg" width="240px" height="426px"/>
<p></p>


### 动态图效果


<img src="https://github.com/CarGuo/FrescoUtils/blob/master/01.gif" width="240px" height="426px"/>
<img src="https://github.com/CarGuo/FrescoUtils/blob/master/02.gif" width="240px" height="426px"/>
<p></p>

### 记得记得在Application里初始化

```
ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
        .setDownsampleEnabled(true)
        .build();
Fresco.initialize(this, config);

```

### FrescoHelper 封装了针对  <a href="https://github.com/HomHomLin/FrescoImageView">FrescoImageView</a> 的工具类，直接使用FrescoImageView作为ImageView使用即可。

封装了多种类型，这是最全的一种
```

/**
 * @param imageView     图片加载控件
 * @param uri           路径或者URL
 * @param defaultImg    默认图片
 * @param cornerRadius  弧形角度
 * @param isCircle      是否为圆
 * @param loadLocalPath 是否本地资源,如果显示R.drawable.xxx,Path可以为null,前提isCircle为true
 * @param isAnima       是否显示GIF动画
 * @param size          是否再编码
 * @param postprocessor 图像显示处理
 */
public static void loadFrescoImage(FrescoImageView imageView, String uri, int defaultImg,
                                   int cornerRadius, boolean isCircle, boolean loadLocalPath, boolean isAnima,
                                   Point size, Postprocessor postprocessor) {
    init(imageView, cornerRadius, isCircle, isAnima, size, postprocessor);
    if (loadLocalPath) {
        imageView.loadLocalImage(uri, defaultImg);
    } else {
        imageView.loadView(uri, defaultImg);
    }
}

···

FrescoHelper.loadFrescoImage(frescoImageView, recyclerDataModel.getUrl(), R.mipmap.ic_launcher, 2, false, recyclerDataModel.getSize(), new BlurPostprocessor(context, 10));


```

### 带有<a href="https://github.com/wasabeef/fresco-processors">fresco-processors</a>各种处理特效，高斯，五角形等。

<img src="https://github.com/wasabeef/fresco-processors/raw/master/art/demo.gif" width="240px" height="426px"/>


### 带有<a href="https://github.com/davemorrissey/subsampling-scale-image-view">subsampling-scale-image-view</a>实现超高清图片超长图片不模糊显示。

<img src="https://github.com/CarGuo/FrescoUtils/blob/master/01.gif" width="240px" height="426px"/>

### 带有<a href="https://github.com/ongakuer/PhotoDraweeView">PhotoDraweeView</a> 功能与PhotoView一样，支持双击放大，单击返回，手动放大与缩小等。

<img src="https://github.com/ongakuer/PhotoDraweeView/raw/master/screenshot.gif" width="240px" height="426px"/>
