<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<title>Услуги</title>
<#include "base.ftl">

<#macro content>
<div class="content">
    <a href='/home'>Назад</a>
    <br>
    <#if services?has_content>
        <#list services as s>
            <h4><a href="/service?id=${s.id}">${s.name}</a><br></h4>
        </#list>
    <#else>
        sobachiy nuh
    </#if>
</div>
</#macro>
</html>