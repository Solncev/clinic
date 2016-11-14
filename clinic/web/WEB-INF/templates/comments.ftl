<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<title>Отзывы</title>
<#include "base.ftl">

<#macro content>
<div class="wrapper">
    <a href='/home'>Назад</a>
    <h3>Отзывы</h3>
    <#if comments?has_content>
        <#list comments as c>
            <div class="list">
                <div class="num" onclick="location.href='#'"><#if c.name??><h4>${c.name} ${c.date}: </h4><#else><h4>
                    Салим</h4></#if>
                    <h3><span>${c.text} </span></h3></div>
            </div>
        </#list>
    </#if>

    <div class="well">
        <h4>Напишите комментраий</h4>
        <form method="post" action="/comments">
            <script>
                $(document).ready(function () {
                    var maxCount = 2000;

                    $("#counter").html(maxCount);

                    $("#comment1").keyup(function () {
                        var revText = this.value.length;

                        if (this.value.length > maxCount) {
                            this.value = this.value.substr(0, maxCount);
                        }
                        var cnt = (maxCount - revText);
                        if (cnt <= 0) {
                            $("#counter").html('0');
                        }
                        else {
                            $("#counter").html(cnt);
                        }

                    });
                });
            </script>
            <div class="form-group">
                <textarea class="form-control text-review" rows="3" id="comment1" name="comment"
                          oninput="ready()"></textarea>
            </div>
            <div class="counter">Осталось символов: <span id="counter"></span></div>
            <button type="submit" class="btn btn-primary">Отправить</button>
        </form>
    </div>
</div>
</#macro>

</html>


