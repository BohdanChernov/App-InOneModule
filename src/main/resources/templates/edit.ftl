<!doctype html>
<html>
<head>
    <title>Laptops to GO</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="shortcut icon" href="images/logo.ico" type="image/x-icon"/>
    <link href="/css/main.css" rel="stylesheet">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/4.0/examples/sticky-footer-navbar/sticky-footer-navbar.css"
          rel="stylesheet">

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>


    <script type="text/javascript">

    </script>
</head>

<body>

<header>
    <nav class="navbar navbar-expand-sm navbar-dark">

        <span><a id="logo" href="/">Laptops to GO</a></span>

    </nav>
</header>

<main role="main" class="container">
    <div id="editContent">

        <form method="post">

            <div class="form-group row" style="background-color:#0093c4; padding: 5px">
                <label class="col-5 col-form-label">Введите модель нотбука для редактирования:</label>
                <input class="col-5 form-control" type="text" name="laptopModel" value="<#if product?has_content>${product.getModel()}</#if>">
            </div>

            <#if product?has_content>

                <div class="form-group row">
                    <label class="col-5 col-form-label">Производитель:</label>
                    <input class="col-5 form-control" type="text" name="manufacturer" value="${product.getLaptopManufacturer().getValue()}">
                </div>

                <div class="form-group row">
                    <label class="col-5 col-form-label">Модель:</label>
                    <input class="col-5 form-control" type="text" name="modelOflaptop" value="${product.getModel()}">
                </div>

                <div class="form-group row">
                    <label class="col-5 col-form-label">Процессор:</label>
                    <input class="col-5 form-control" type="text" name="processor" value="${product.getProcessorType().getValue()}">
                </div>

                <div class="form-group row">
                    <label class="col-5 col-form-label">Диагональ дисплея:</label>
                    <input class="col-5 form-control" type="text" name="displayDiagonal" value="${product.getDisplayDiagonal().getValue()}">
                </div>

                <div class="form-group row">
                    <label class="col-5 col-form-label">Расширение дисплея:</label>
                    <input class="col-5 form-control" type="text" name="displayResolution" value="${product.getDisplayResolution().getValue()}">
                </div>

                <div class="form-group row">
                    <label class="col-5 col-form-label">Тип дисплея:</label>
                    <input class="col-5 form-control" type="text" name="displayType" value="${product.getDisplayType().getValue()}">
                </div>

                <div class="form-group row">
                    <label class="col-5 col-form-label">Объем памяти RAM:</label>
                    <input class="col-5 form-control" type="text" name="ramSize" value="${product.getRamSize().getValue()}">
                </div>

                <div class="form-group row">
                    <label class="col-5 col-form-label">Тип памяти RAM:</label>
                    <input class="col-5 form-control" type="text" name="ramType" value="${product.getRamType().getValue()}">
                </div>

                <div class="form-group row">
                    <label class="col-5 col-form-label">Тип жесткого диска:</label>
                    <input class="col-5 form-control" type="text" name="storageType" value="${product.getStorageType().getValue()}">
                </div>

                <div class="form-group row">
                    <label class="col-5 col-form-label">Объем жесткого диска:</label>
                    <input class="col-5 form-control" type="text" name="storageSize" value="${product.getStorageSize().getValue()}">
                </div>

                <div class="form-group row">
                    <label class="col-5 col-form-label">Цена:</label>
                    <input class="col-5 form-control" type="text" name="price" value="${product.getPrice()}">
                </div>
            </#if>

            <div class="form-group row">
                <button  class="btn btn-danger w-100" type="submit">Отправить</button>
            </div>

        </form>




    </div>
</main>

<footer class="footer">
    <nav class="navbar navbar-expand-lg m-0 p-0" id="footer">
        <ul class="navbar-nav ml-auto">
            <div class="form-inline">
                <li class="nav-item">
                    <a class="btn btn-light" id="footerButton" href="/login">Вход администратора</a>
                </li>
                <li class="nav-item">
                    <a class="btn btn-light" id="footerButton" href="/edit">Редактирование товаров</a>
                </li>
                <li class="nav-item">
                    <a class="btn btn-light" id="footerButton" href="/parser">Парсер товаров</a>
                </li>

                <li class="nav-item">
                    <a class="btn btn-light" id="footerButton" href="/contacts">Контакты</a>
                </li>
                <li class="nav-item">
                    <a class="btn btn-light" id="footerButton" href="/delivery">Условия доставки</a>
                </li>
                <li class="nav-item">
                    <a class="btn btn-light" id="footerButton" href="/feedback">Обратная
                        связь</a>
                </li>
            </div>
        </ul>
    </nav>
</footer>

</body>
</html>