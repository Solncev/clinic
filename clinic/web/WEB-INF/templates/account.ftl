<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<title>Личный кабинет</title>
<#include "base.ftl">

<#macro content>

<ul>
    <#if client?has_content>
        <#if client.login??> <h4>Ваш логин: ${client.login}</h4> <#else ><h4>Ваш логин: null</h4> </#if>
        <#if client.surname??> <h4>Фамилия: ${client.surname}</h4> <#else ><h4>Фамилия: null</h4> </#if>
        <#if client.name??> <h4>Имя: ${client.name}</h4> <#else ><h4>Имя: null</h4> </#if>
        <#if client.patronymic??> <h4>Отчество: ${client.patronymic}</h4></#if>
        <#if client.birthDay??>  <h4>День рождения: ${client.birthDay}</h4>  </#if>
        <#if client.gender??>  <h4>Пол: ${client.gender}</h4>  </#if>
        <#if client.mobile_number??> <h4>Мобильный телефон: ${client.mobile_number}</h4>  </#if>
        <#if client.OMS_number??><h4>Номер ОМС: ${client.OMS_number}</h4>  </#if>
        <h3><a href='/appointment'>Записаться на прием</a></h3>
        <#if appointments?has_content>
            <#list appointments as a>
                <h4>у вас имеется запись на: </h4>
                <h4>${a.date}    ${a.time}<br></h4>
            </#list>
        <#else >
        </#if>
    <#else>
        null
    </#if>

</ul>
</#macro>
</html>


