<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<#if doctor?has_content>
<title>${doctor.surname}</title>
<#else>
<title>Доктор</title>
</#if>
<#include "base.ftl">

<#macro content>
<div class="content">
    <a href='/home'>На главную</a>
    <br>
    <#if doctor?has_content>
        <title> ${doctor.surname}</title>

        <div class="col-md-4"> <#if doctor.photo??><img class="img-responsive" src="${doctor.photo}" width="250"
                                                        height="250" alt=""><#else>
            <img class="img-responsive" src="http://placehold.it/250x250" alt=""></#if></div>
        <div class="col-md-8"><h4>Имя: ${doctor.name}</h4>
            <h4>Фамилия: ${doctor.surname}</h4>
            <h4>Отчество: ${doctor.patronymic}</h4>
            <#if doctor.speciality??>
                <h4>Специальность: ${doctor.speciality}</h4>
            </#if>
            <#if doctor.staff??>
                <h4>Должность: ${doctor.staff}</h4>
            </#if>
            <#if doctor.achievements??>
                <h4>Достижения: ${doctor.achievements}</h4>
            </#if>
            <#if doctor.education??>
                <h4>Образование: ${doctor.education}</h4>
            </#if>
            <#if doctor.experience??>
                <h4>Опыт работы: ${doctor.experience}</h4>
            </#if>
            <#if doctor.certificate??>
                <h4>Награды, сертификаты, благодарственные письма: ${doctor.certificate}</h4>
            </#if></div>

    <#else>
        sobachiy nuh
    </#if>
</div>
</#macro>
</html>
