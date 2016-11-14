<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<#include "base.ftl">

<#macro content>
<h1><#if err?has_content>${err}</#if></h1>
<div class="wrapper">
    <h3>Авторизация</h3>
    <form method="post" action="login">
        <div class="form-group">
            <label>Логин</label>
            <#if login?has_content><p><input type="text" class="form-control" id="login2" name="login"
                                             placeholder="+7(9_ _)" value="${login}"></p>
            <#else > <p><input type="text" class="form-control" id="login2" name="login" placeholder="+7(9_ _)">
            </p></#if>
        </div>
        <div class="form-group">
            <label>Пароль</label>
            <input type="password" class="form-control" id="password2" name="password" placeholder="Введите пароль">
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" name="rememberMe">Запомнить меня
            </label>
        </div>
        <input type="submit" class="btn btn-default" value="Войти">
        <a href="/registration" class="btn btn-default" role="button">Регистрация</a>

    </form>
</div>
</#macro>
