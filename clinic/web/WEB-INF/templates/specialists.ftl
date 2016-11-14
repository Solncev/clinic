<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<title>Специалисты</title>
<#include "base.ftl">

<#macro content>
<div class="content1">
    <a href='/home'>Назад</a>
    <br>
    <#if doctors?has_content>
        <#list doctors as d>
            <#if d.staff??>
                <h4>${d.staff}: </h4>
            </#if>
            <h3><a href="/specialist?id=${d.id}">${d.surname} ${d.name}</a><br></h3>
        </#list>
    <#else>
        sobachiy nuh
    </#if>
</div>
</#macro>
</html>
