<recipe folder="root://activities/CandyBaseActivity">

    <#if requireTheme!false>
    <#include "recipe_theme.xml.ftl" />
    </#if>

    <merge from="root/AndroidManifest.xml.ftl"
           to="${escapeXmlAttribute(manifestOut)}/AndroidManifest.xml" />
    <merge from="root/res/values/manifest_strings.xml.ftl"
             to="${escapeXmlAttribute(resOut)}/values/strings.xml" />

</recipe>
