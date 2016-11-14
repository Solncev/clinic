<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<#if service?has_content>
<title>${service.name}</title>
<#else>
<title>Услуга</title>
</#if>

<#include "base.ftl">

<#macro content>
<div class="content">
    <a href='/home'>Назад</a>
    <br>
    <#if service?has_content>
        <#if service.name??>
            <h4>Название: ${service.name}</h4>
        <#else>
            <h4>Название: null</h4>
        </#if>
        <img class="img-responsive" src="http://placehold.it/900x300" alt="">
        <#if service.text??>
            <h4>Описание: ${service.text}</h4>
        <#else>
            <h4>Описание: null</h4>
        </#if>
        <#if service.price??>
            <h4>Стоимость: ${service.price}</h4>
        <#else>
            <h4>Стоимость: null</h4>
        </#if>
    <#else>
        sobachiy nuh
    </#if>
</div>
</#macro>
</html>