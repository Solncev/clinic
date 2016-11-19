<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<title>Регистрация</title>
<#include "base.ftl">

<#macro content>
<h1><#if err?has_content>${err}</#if></h1>
<form method="post" action="registration">
    <div class="row block">
        <div class="form-group col-md-3">
            <label>Фамилия* </label>
            <#if surname?has_content><input type="text" class="form-control ntSaveForms" name="surname"
                                            value="${surname}" maxlength="40">
            <#else> <input type="text" class="form-control ntSaveForms" name="surname" maxlength="40"></#if>
        </div>
        <div class="form-group col-md-3">
            <label>Имя* </label>
            <#if firstname?has_content><input type="text" class="form-control ntSaveForms" name="firstname"
                                              value="${firstname}" maxlength="30">
            <#else><input type="text" class="form-control ntSaveForms" name="firstname" maxlength="30"></#if>
        </div>
        <div class="form-group col-md-3">
            <label>Отчество* </label>
            <#if patronymic?has_content><input type="text" class="form-control ntSaveForms" name="patronymic"
                                               value="${patronymic}" maxlength="30">
            <#else><input type="text" class="form-control ntSaveForms" name="patronymic" maxlength="30"></#if>
        </div>
    </div>

    <div class="row block">
        <div class="form-group col-md-3">
            <label>Номер телефона* </label>
            <#if mobilenumber?has_content><input type="text" class="form-control ntSaveForms" name="mobilenumber"
                                                 maxlength="20"
                                                 value="${mobilenumber}">
            <#else ><input type="text" class="form-control ntSaveForms" name="mobilenumber" maxlength="20">
            </#if>
        </div>
        <div class="form-group col-md-3">
            <label>Полис ОМС* </label>
            <#if omsnumber?has_content><input type="text" class="form-control ntSaveForms" name="omsnumber"
                                              maxlength="30"
                                              value="${omsnumber}">
            <#else ><input type="text" class="form-control ntSaveForms" name="omsnumber" maxlength="30">
            </#if>
        </div>

        <div class="form-group col-md-3">
            Пол*
            <select class="active" name="gender">
                <option value="мужской">Мужской</option>
                <option value="женский">Женский</option>
            </select>
        </div>
    </div>
    <div class="row block">
        <div class="form-group col-md-3">
            <label>Логин* </label>
            <#if login?has_content><input type="text" class="form-control ntSaveForms" name="login" maxlength="40"
                                          value="${login}">
            <#else ><input type="text" class="form-control ntSaveForms" name="login" maxlength="40">
            </#if>
        </div>
        <div class="form-group col-md-3">
            <label>Пароль* </label>
            <#if password?has_content><input type="password" class="form-control ntSaveForms" name="password"
                                             maxlength="50"
                                             value="${password}">
            <#else ><input type="password" class="form-control ntSaveForms" name="password" maxlength="50">
            </#if>
        </div>
        <div class="form-group col-md-3">
            <label>Введите еще раз пароль* </label>
            <input type="password" class="form-control ntSaveForms" name="password2" maxlength="50">
        </div>
    </div>
    <div class="row block">
        <div class="form-group col-md-3">
            <label>Дата рождения* </label>
            <input type="date" name="birthday" class="date ntSaveForms">
        </div>
    </div>

    <button type="submit" class="btn btn-default">Зарегистрироваться</button>

</form>
</#macro>