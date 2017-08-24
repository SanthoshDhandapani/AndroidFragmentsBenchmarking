# Benchmarking Android Fragments

<h4>Activities :</h4> MainActivity, Activity B, Activity C, Activity D
<h4>Results:</h4><p>Based on the navigations<br/>1) From MainActivity to ActivityD <br/>2) For Fragments : Fragment 1 to Fragment 4</p> 

<h2>This project aims just to test the memory usage of a basic android application with the following cases (using android studio's memory profiler).</h2>

<h2>1) When views are directly used in multiple Activity classes.</h2>
<pre>Class Name : MyApplication</pre>
<code>
 public boolean loadAsFragments = false;
 public boolean loadViewsByFragment = false;</code>
<h5>Sampling 1</h5>
Start : 21.28 MB
End : 24.2 MB
Diff : 3 MB
<h5>Sampling 2</h5>
Start : 21.48 MB
End : 24.18 MB
Diff : 2.7 MB
<h5>Sampling 3</h5>
Start : 21.7 MB
End : 24.62 MB
Diff : 2.92 MB
<h3>Average Memory Consumption: 2.87 MB<h3>
<hr/>

<h2>2) When views are used in a fragment and then it is implemented in an Activity.</h2>
<pre>Class Name : MyApplication</pre>
<code>
 public boolean loadAsFragments = false;
 public boolean loadViewsByFragment = true;</code>
<h5>Sampling 1</h5>
Start : 21.74 MB
End : 24.56 MB
Diff : 2.82 MB
<h5>Sampling 2</h5>
Start :  21.5 MB
End : 24.32 MB
Diff : 2.82 MB
<h5>Sampling 3</h5>
Start : 21.76 MB
End : 24.44 MB
Diff : 2.68 MB
<h3>Average Memory Consumption: 2.77 MB</h3>
<hr/>
<h3>3) Single Activity and multiple Fragments.</h3>
<pre>Class Name : MyApplication</pre>
<code>
 public boolean loadAsFragments = true;
 public boolean loadViewsByFragment = false;</code>
<h5>Sampling 1</h5>
Start : 21.87 MB
End : 23.11 MB
Diff : 1.24 MB
<h5>Sampling 2</h5>
Start :  21.85 MB
End : 23.08 MB
Diff : 1.23 MB
<h5>Sampling 3</h5>
Start : 21.84 MB
End : 23.42 MB
Diff : 1.58 MB
<h3>Average Memory Consumption: 1.35 MB</h3>

<!-- img src="https://user-images.githubusercontent.com/10140204/29455362-89e8c7a2-842e-11e7-8308-70f6a7b29c4a.jpg" alt="Views used directly in multiple Activity"/>
<img src="https://user-images.githubusercontent.com/10140204/29455371-91eecb68-842e-11e7-8753-6509b7ade701.jpg" alt="Views used in Fragment and which is used in Activity"/>
<img src="https://user-images.githubusercontent.com/10140204/29455384-9bd4fb48-842e-11e7-9757-4b25b1f18522.jpg" alt="Single Activity and muliple Fragments"/>
-->
<hr/>
<div>
<h3>App ScreenShots</h3>
<div style="width: 50%; float:left">
<h3>Navigation From MainActivity to ActivityD</h3>
   <img src="https://user-images.githubusercontent.com/10140204/29663775-77af4aa0-88ea-11e7-9fb6-760a69233dc6.gif" alt="App ScreenShot" />
</div>

<div style="width: 50%; float:right">
<h3>Navigation From MainActivity (Fragment1 to Fragment4)</h3>
  <img src="https://user-images.githubusercontent.com/10140204/29663776-77b3c364-88ea-11e7-8803-7f3658428a74.gif" alt="App ScreenShot" />
</div>
</div>
<!-- h3>App ScreenShots</h3>
<img src="https://user-images.githubusercontent.com/10140204/29663776-77b3c364-88ea-11e7-8803-7f3658428a74.gif" alt="App ScreenShot" height="960px" width="540px" style="height: 960px;width: 540px"/> -->
