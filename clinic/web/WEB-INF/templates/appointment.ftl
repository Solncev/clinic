<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">

<#include "base.ftl">
<title>Запись на прием</title>

<#macro content>
<form method="post" action="appointment">
    <div class="row block">
        <div class="form-group col-md-3">
            <label>Фамилия доктора: </label>
            <input type="text" class="form-control" name="surname1">
        </div>
        <div class="form-group col-md-3">
            <label>Имя доктора: </label>
            <input type="text" class="form-control" name="name1">
        </div>
    </div>
    <div class="row block">
        <div class="form-group col-md-3">
            <label>Дата записи: </label>
            <input type="date" class="form-control" name="date" placeholder="Дата">
        </div>
        <div class="form-group col-md-3">
            <label>Время приема: </label>
            <input type="time" class="form-control" name="time" placeholder="Время приёма">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Записаться</button>
</form>


    <#if appointments?has_content>
        <#list appointments as a>
        <h4>${a.date}</h4>
        </#list>
    <#else>

    </#if>


</#macro>
</html>