<?xml version="1.0"?>
<recipe>
  <merge from="root/AndroidManifest.xml.ftl"
         to="${escapeXmlAttribute(manifestOut)}/AndroidManifest.xml" />
         
  <merge from="root/res/values/manifest_strings.xml.ftl"
           to="${escapeXmlAttribute(resOut)}/values/strings.xml" />


   <instantiate from="root/res/layout/simple.xml.ftl"
                to="${escapeXmlAttribute(resOut)}/layout/${simpleLayoutName}.xml" />


    <instantiate from="root/res/layout/app_bar.xml.ftl"
                 to="${escapeXmlAttribute(resOut)}/layout/${appBarLayoutName}.xml" />

    <instantiate from="root/src/app_package/SimpleActivity.${ktOrJavaExt}.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${activityClass}.${ktOrJavaExt}" />
    <open file="${escapeXmlAttribute(srcOut)}/${activityClass}.${ktOrJavaExt}" />


    <open file="${escapeXmlAttribute(resOut)}/layout/${simpleLayoutName}.xml" />

</recipe>
