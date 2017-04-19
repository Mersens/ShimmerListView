## 说明
* ShimmerListView基于[Facebook Shimmer](https://github.com/facebook/shimmer-android)实现闪光加载效果  
## 效果图
![运行效果图](https://github.com/Mersens/ShimmerListView/blob/master/screenshots/shimmer.gif)
## How to 
To get a Git project into your build:</br>
Step 1.Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency:
```
dependencies {
	        compile 'com.github.Mersens:ShimmerListView:0c5a4fe182'
	}

```
Step 3. Used:
```
    <com.mersens.shimmer.ShimmerListView
        android:id="@+id/shimmerListView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:shimmer_item_count="10"
        app:shimmer_layout="@layout/shimmer_item_view"
         />
```
