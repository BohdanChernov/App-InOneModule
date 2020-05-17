<!doctype html>
<html>
<head>
    <title>Laptops to GO</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="shortcut icon" href="images/logo.ico" type="image/x-icon" />
    <link href="/css/main.css" rel="stylesheet">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/4.0/examples/sticky-footer-navbar/sticky-footer-navbar.css"
          rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"/>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
</head>

<body>


<header>

    <nav class="navbar navbar-expand-sm navbar-dark">

        <span ><a id="logo" href="/">Laptops to GO</a></span>

    </nav>
</header>

<main role="main" class="container">
    <form method="post" action="/sendMessage">
        <div class="justify-content-center">
            <div class="row">
                <label class="sr-only" for="inlineFormInput">Name</label>
                <input name="name" type="text" class="form-control mb-2" id="inlineFormInput" placeholder="Ваше имя">
            </div>
            <div class="row">
                <label class="sr-only" for="inlineFormInput">Name</label>
                <input name="email" type="text" class="form-control mb-2" id="inlineFormInput" placeholder="Ваш e-mail">
            </div>
            <div class="row">
                <label class="sr-only" for="inlineFormInput">Name</label>
                <textarea name="body" class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="Ваше обращение"></textarea>
            </div>
            <div class="row mt-1">
                <button type="submit" class="btn btn-outline-secondary mb-2">Отправить</button>
            </div>
        </div>
    </form>
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


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

</body>
</html>