<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Вход</title>
    <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../slider/generic.css" rel="stylesheet" type="text/css"/>
    <link href="../slider/js-image-slider.css" rel="stylesheet" type="text/css"/>
    <script src="../slider/js-image-slider.js"></script>
    <script src="../js/jquery-3.1.1.min.js"></script>
    <script src="../js/bootstrap.js"></script>
    <style>
        .error input,
        .error textarea {
            border: 1px solid red;
        }

        .error {
            color: red;
        }
    </style>

</head>

<body>
<div id="header1" class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

        </div>
        <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav menu1">
            <li class="li1"><a href="/home">Клиника+</a></li>
            <li class="li1"><a href="/newses">Новости</a></li>
            <li class="dropdown li1"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Персонал<b
                    class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="/leaderships">Руководители</a></li>
                    <li><a href="/specialists">Специалисты</a></li>
                </ul>

            <li class="dropdown li1"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Услуги<b
                    class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li class="li1"><a href="/services">Услуги</a></li>
                    <li class="li1"><a href="/deals">Предложения</a></li>
                </ul>

        <li class="right dropdown" id="login1"><a href="#" class="dropdown-toggle" data-toggle="dropdown">О
            нас<b
                    class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a href="/contacts">Контакты</a></li>
                <li><a href="/comments">Отзывы</a></li>
            </ul>
        <#if islogin ?has_content>
            <li><a href="/personal_cabinet">Личный кабинет</a></li>
            <li class="li1"><a href="/logout">Выйти</a></li>
        <#else >
            <li class="right dropdown" id="login1"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Вход<b
                    class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="/login">Вход</a></li>
                    <li><a href="/personal_cabinet">Личный кабинет</a></li>
                </ul>
        </ul></#if>

        </div>
    </div>
</div>


<div class="container1">
    <div class="content"><@content></@content></div>
</div>


<#--<div class="footer" id="footer1">-->
<#--<div class="row">-->
<#--<div class="col-md-1"></div>-->
<#--<div class="col-md-3">-->
<#--<p>© 2016 "Med+"</p>-->
<#--</div>-->
<#--<div class="col-md-2">-->
<#--<a href="#">...</a>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<script type='text/javascript' src='/ntsaveforms.js'></script>
</body>
</html>