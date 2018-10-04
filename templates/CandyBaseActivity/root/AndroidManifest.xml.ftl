<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="${packageName}">

   <application>
           <activity android:name="${packageName}.${activityClass}"
                     android:label="@string/title_${activityToLayout(activityClass)}"
                     android:theme="@style/AppTheme.ToolbarHeight"/>
       </application>
</manifest>
