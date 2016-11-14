<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<title>Новости</title>
<#include "base.ftl">

<#macro content>
<div class="content">
    <a href='/home'>Назад</a>
    <br>
    <#if newses?has_content>
        <#list newses as n>
            <h4><a href="/news?id=${n.id}">${n.time}:      ${n.topic}</a><br></h4>
        </#list>
    <#else>
        sobachiy nuh
    </#if>
</div>
</#macro>
</html>