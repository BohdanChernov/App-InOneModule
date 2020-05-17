<!DOCTYPE html>
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
        $(document).ready(function () {

            $(".addToBasket").click(function (event) {
                var id = $(this).attr('value');

                $( this ).animate({
                    width: "70%",
                    opacity: 0.4,
                    borderWidth: "10px"
                }, 1500 );

                addCookie(id);
            })

        });

        function addCookie(id) {

            $.ajax({
                type: "POST",
                url: "/addToBasket",
                contentType: 'application/json',
                dataType: 'text',
                data: id,
                success: function (data) {
                    console.log("Succes!")
                }
            });
        }
    </script>

</head>

<body>

<header>

    <nav class="navbar navbar-expand-sm navbar-dark">

        <span><a id="logo" href="/">Laptops to GO</a></span>

        <button class="navbar-toggler navbar-dark" type="button" data-toggle="collapse"
                data-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <div class="form-inline ml-auto">
                <ul class="navbar-nav">
                    <input id="searchQuery" class="form-control mt-1 mr-1" type="search" placeholder="Поиск"
                           aria-label="Search">
                    <button id="search" class="btn btn-light mt-1" type="submit">Найти</button>
                    <a href="/basket"><img id="basket" src="/images/basket-free.svg"></a></img>
                </ul>
            </div>
        </div>

    </nav>
</header>

<main role="main" class="container">
    <div class="row justify-content-center">



        <div class="col-6">

            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">


                    <div class="carousel-item active">
                        <img class="d-block w-100" src="${product.getPhoto()[0].getLocation()}" alt="Slide">
                    </div>


                    <#list product.getPhoto() as ph>
                        <#if ph.getId() != product.getPhoto()[0].getId()>
                            <div class="carousel-item">
                                <img class="d-block w-100" src="${ph.getLocation()}" alt="Slide">
                            </div>
                        </#if>
                    </#list>


                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>


        </div>

        <div class="col-6">
            Производитель: ${product.getLaptopManufacturer().getValue()}<br><br>
            Модель: ${product.getModel()}<br><br>
            Процессор: ${product.getProcessorType().getValue()}<br><br>
            Диагональ дисплея: ${product.getDisplayDiagonal().getValue()}<br><br>
            Расширение дисплея: ${product.getDisplayResolution().getValue()}<br><br>
            Тип дисплея: ${product.getDisplayType().getValue()}<br><br>
            Объем памяти RAM: ${product.getRamSize().getValue()}<br><br>
            Тип памяти RAM: ${product.getRamType().getValue()}<br><br>
            Тип жесткого диска: ${product.getStorageType().getValue()}<br><br>
            Объем жесткого диска: ${product.getStorageSize().getValue()}<br><br>
            Цена: ${product.getPrice()} грн.<br><br>

            <div class="row card border-0" id="rowBuy">
                <button class="btn btn btn-light w-100 addToBasket" id="addToBasket" value="${product.getId()}">Добавить в
                    корзину
                </button>
            </div>

        </div>
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