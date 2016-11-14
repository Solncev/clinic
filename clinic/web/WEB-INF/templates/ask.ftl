<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<title>Отзывы</title>
<#include "base.ftl">

<#macro content>
<div class="wrapper">
    <a href='/home'>Назад</a>
    <br>
    <h3>Задать вопрос</h3>

    <form class="form">
        <div class="form-group">
            <div>
                    <textarea cols="70" rows="10" name="text"
                              placeholder="Введите текст "></textarea>
            </div>
        </div>
        <button type="submit" class="btn btn-default">Отправить</button>
    </form>
</div>
</#macro>
</html>
