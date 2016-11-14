<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<title>Предложения</title>
<#include "base.ftl">

<#macro content>
<div class="content">
    <a href='/home'>Назад</a>
    <br>
    <#if deals?has_content>
        <#list deals as d>
            <h3>${d.name}:</h3><h4>${d.description}</h4>
        </#list>
    <#else>
        sobachiy nuh
    </#if>
</div>
</#macro>
</html>