<#import "../shared_manifest_macros.ftl" as manifestMacros>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="${packageName}">

   <application>
           <activity android:name="${packageName}.${activityClass}"
               <#if generateActivityTitle!true>
                   <#if isNewProject>
                       android:label="@string/app_name"
                   <#else>
                       android:label="@string/title_${activityToLayout(activityClass)}"
                   </#if>
               </#if>
                   android:theme="@style/AppTheme.ToolbarHeight"
               <#if buildApi gte 16 && parentActivityClass != "">
                   android:parentActivityName="${parentActivityClass}"
               </#if>>
               <#if parentActivityClass != "">
                   <meta-data android:name="android.support.PARENT_ACTIVITY"
                       android:value="${parentActivityClass}" />
               </#if>
               <@manifestMacros.commonActivityBody />
           </activity>
       </application>
</manifest>
