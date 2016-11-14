<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<title>Вопрос-ответ</title>
<#include "base.ftl">

<#macro content>
<div class="wrapper">
    <a href='/home'>Назад</a>
    <br>
    <h3>"Вопрос - ответ"</h3>
    <button type="submit" class="btn btn-default">Задать вопрос</button>

    <form class="form">
        <div class="form-group">
            <textarea cols="70" rows="10" name="text" placeholder="Вопрос клиента "></textarea>
        </div>
        <div class="form-group">
            <div>
                <textarea cols="70" rows="10" name="text" placeholder="Отет специалиста "></textarea>
            </div>
        </div>

    </form>
</div>
</#macro>
</html>