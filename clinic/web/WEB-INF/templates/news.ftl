<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<#if news?has_content>
<title>${news.topic}</title>
<#else>
<title>Новость</title>
</#if>

<#include "base.ftl">

<#macro content>
<div class="content">
    <a href='/home'>Назад</a>
    <br>

    <#if news?has_content>
        <#if news.text??>
            <h4>${news.time}:</h4>
            <img class="img-responsive" src="http://placehold.it/900x300" alt="">
            <h3>${news.text}</h3>
        <#else>
            null
        </#if>
    <#else>
        sobachiy nuh
    </#if>
</div>
</#macro>
</html>