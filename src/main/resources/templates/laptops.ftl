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
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>

    <script type="text/javascript">
        $(document).ready(function () {


            $("#search").click(function () {
                var str = $("#searchQuery").val();
                ajax_submit(0, "lowPrice", str);
            });

            ajax_submit(0, "lowPrice", "null");

            $("#form1").on("click", "#filter", function (event) {
                event.preventDefault();
                ajax_submit(0, "lowPrice", "null");
            });
        });

        function ajax_submit(number, sort, searchQuery) {
            let criterias = $("#form1").serializeArray();

            let laptopManufacturers = new Array();
            let displayDiagonals = new Array();
            let displayResolutions = new Array();
            let displayTypes = new Array();
            let processorTypes = new Array();
            let ramSizes = new Array();
            let ramTypes = new Array();
            let storageSizes = new Array();
            let storageTypes = new Array();

            for (var i = 0; i < criterias.length; i++) {
                let name = JSON.stringify(criterias[i].name);
                let value = JSON.stringify(criterias[i].value).replace("\"", "").replace("\"", "");

                switch (name) {
                    case "\"laptopManufacturers\"" : {
                        var item = {"value": value};
                        laptopManufacturers.push(item);
                        break;
                    }

                    case "\"displayDiagonals\"": {
                        var item = {"value": value};
                        displayDiagonals.push(item);
                        break;
                    }

                    case "\"displayResolutions\"": {
                        var item = {"value": value};
                        displayResolutions.push(item);
                        break;
                    }

                    case "\"displayTypes\"": {
                        var item = {"value": value};
                        displayTypes.push(item);
                        break;
                    }

                    case "\"processorTypes\"": {
                        var item = {"value": value};
                        processorTypes.push(item);
                        break;
                    }

                    case "\"ramSizes\"": {
                        var item = {"value": value};
                        ramSizes.push(item);
                        break;
                    }

                    case "\"ramTypes\"": {
                        var item = {"value": value};
                        ramTypes.push(item);
                        break;
                    }

                    case "\"storageSizes\"": {
                        var item = {"value": value};
                        storageSizes.push(item);
                        break;
                    }

                    case "\"storageTypes\"": {
                        var item = {"value": value};
                        storageTypes.push(item);
                        break;
                    }
                }
            }

            var laptopCriteria = {
                "laptopManufacturers": laptopManufacturers,
                "displayDiagonals": displayDiagonals,
                "displayResolutions": displayResolutions,
                "displayTypes": displayTypes,
                "processorTypes": processorTypes,
                "ramSizes": ramSizes,
                "ramTypes": ramTypes,
                "storageSizes": storageSizes,
                "storageTypes": storageTypes
            };

            var jsonDTO = {
                "laptopCriteria": laptopCriteria,
                "pageNumber": number,
                "size": 12,
                "sort": sort,
                "searchQuery": searchQuery
            }

            $.ajax({
                type: "POST",
                url: "/getContent",
                contentType: 'application/json',
                dataType: 'text',

                data: JSON.stringify(jsonDTO),

                success: function (data) {
                    console.log("Succes!")
                    $("#allLaptops").empty();
                    $("#allLaptops").append(data);
                }
            });
        }

    </script>
</head>

<body>

<div class="container-fluid p-0 m-0">

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

    <main id="main">
        <div class="container-fluid">
            <div class="row">

                <div class="col-xs-5 col-sm-4 col-md-3 col-lg-2" id="filterContent">
                    <form method="post" id="form1">
                        <p>
                            <button class="btn btn-light w-100" type="button" id="filterButton" data-toggle="collapse"
                                    data-target="#laptopManufacturers"
                                    aria-expanded="true" aria-controls="collapseExample">
                                Производитель
                            </button>
                        </p>
                        <div class="collapse mb-3 <#if (laptopCriteria.getLaptopManufacturers()?size>0)>show</#if>"
                             id="laptopManufacturers">
                            <div class="card card-body">
                                <#list laptopManufacturers as criteria>
                                    <div class="custom-control custom-checkbox py-2">
                                        <input class="form-check-input" type="checkbox" id="${criteria.getValue()}"
                                               name="laptopManufacturers"
                                               value="${criteria.getValue()}"
                                                <#if laptopCriteria?has_content>
                                            <#list laptopCriteria.getLaptopManufacturers() as item>
                                                <#if item.getValue()?contains("${criteria.getValue()}")>checked</#if>
                                            </#list>
                                                </#if>>
                                        <label class="form-check-label"
                                               for="${criteria.getValue()}">${criteria.getValue()}</label>
                                    </div>
                                </#list>
                            </div>
                        </div>

                        <p>
                            <button class="btn btn-light w-100" type="button" id="filterButton" data-toggle="collapse"
                                    data-target="#processorTypes" aria-expanded="true" aria-controls="processorTypes">
                                Процессор
                            </button>
                        </p>
                        <div class="collapse mb-3<#if (laptopCriteria.getProcessorTypes()?size>0)>show</#if>"
                             id="processorTypes">
                            <div class="card card-body">
                                <#list processorTypes as criteria>
                                    <div class="custom-control custom-checkbox py-2">
                                        <input class="form-check-input" type="checkbox" id="${criteria.getValue()}"
                                               name="processorTypes"
                                               value="${criteria.getValue()}"
                                                <#if laptopCriteria?has_content>
                                            <#list laptopCriteria.getProcessorTypes() as item>
                                                <#if item.getValue()?contains("${criteria.getValue()}")>checked</#if>
                                            </#list>
                                                </#if>>
                                        <label class="form-check-label"
                                               for="${criteria.getValue()}">${criteria.getValue()}</label>
                                    </div>
                                </#list>
                            </div>
                        </div>

                        <p>
                            <button class="btn btn-light w-100" type="button" id="filterButton" data-toggle="collapse"
                                    data-target="#displayDiagonals" aria-expanded="true"
                                    aria-controls="collapseExample">
                                Диагональ дисплей
                            </button>
                        </p>
                        <div class="collapse mb-3<#if (laptopCriteria.getDisplayDiagonals()?size>0)>show</#if>"
                             id="displayDiagonals">
                            <div class="card card-body">
                                <#list displayDiagonals as criteria>
                                    <div class="custom-control custom-checkbox py-2">
                                        <input class="form-check-input" type="checkbox" id="${criteria.getValue()}"
                                               name="displayDiagonals"
                                               value="${criteria.getValue()}"
                                                <#if laptopCriteria?has_content>
                                            <#list laptopCriteria.getDisplayDiagonals() as item>
                                                <#if item.getValue()?contains("${criteria.getValue()}")>checked</#if>
                                            </#list>
                                                </#if>>
                                        <label class="form-check-label"
                                               for="${criteria.getValue()}">${criteria.getValue()}"</label>
                                    </div>
                                </#list>
                            </div>
                        </div>

                        <p>
                            <button class="btn btn-light w-100" type="button" id="filterButton" data-toggle="collapse"
                                    data-target="#displayResolutions" aria-expanded="true"
                                    aria-controls="collapseExample">
                                Расширение дисплея
                            </button>
                        </p>
                        <div class="collapse mb-3<#if (laptopCriteria.getDisplayResolutions()?size>0)>show</#if>"
                             id="displayResolutions">
                            <div class="card card-body">
                                <#list displayResolutions as criteria>
                                    <div class="custom-control custom-checkbox py-2">
                                        <input class="form-check-input" type="checkbox" id="${criteria.getValue()}"
                                               name="displayResolutions"
                                               value="${criteria.getValue()}"
                                                <#if laptopCriteria?has_content>
                                            <#list laptopCriteria.getDisplayResolutions() as item>
                                                <#if item.getValue()?contains("${criteria.getValue()}")>checked</#if>
                                            </#list>
                                                </#if>>
                                        <label class="form-check-label"
                                               for="${criteria.getValue()}">${criteria.getValue()}</label>
                                    </div>
                                </#list>
                            </div>
                        </div>

                        <p>
                            <button class="btn btn-light w-100" type="button" id="filterButton" data-toggle="collapse"
                                    data-target="#displayTypes"
                                    aria-expanded="true" aria-controls="collapseExample">
                                Тип дисплея
                            </button>
                        </p>
                        <div class="collapse mb-3<#if (laptopCriteria.getDisplayTypes()?size>0)>show</#if>"
                             id="displayTypes">
                            <div class="card card-body">
                                <#list displayTypes as criteria>
                                    <div class="custom-control custom-checkbox py-2">
                                        <input class="form-check-input" type="checkbox" id="${criteria.getValue()}"
                                               name="displayTypes"
                                               value="${criteria.getValue()}"
                                                <#if laptopCriteria?has_content>
                                            <#list laptopCriteria.getDisplayTypes() as item>
                                                <#if item.getValue()?contains("${criteria.getValue()}")>checked</#if>
                                            </#list>
                                                </#if>>
                                        <label class="form-check-label"
                                               for="${criteria.getValue()}">${criteria.getValue()}</label>
                                    </div>
                                </#list>
                            </div>
                        </div>

                        <p>
                            <button class="btn btn-light w-100" type="button" id="filterButton" data-toggle="collapse"
                                    data-target="#ramSizes"
                                    aria-expanded="true" aria-controls="collapseExample">
                                Объем памяти RAM
                            </button>
                        </p>
                        <div class="collapse mb-3<#if (laptopCriteria.getRamSizes()?size>0)>show</#if>" id="ramSizes">
                            <div class="card card-body">
                                <#list ramSizes as criteria>
                                    <div class="custom-control custom-checkbox py-2">
                                        <input class="form-check-input" type="checkbox" id="${criteria.getValue()}"
                                               name="ramSizes"
                                               value="${criteria.getValue()}"
                                                <#if laptopCriteria?has_content>
                                            <#list laptopCriteria.getRamSizes() as item>
                                                <#if item.getValue()?contains("${criteria.getValue()}")>checked</#if>
                                            </#list>
                                                </#if>>
                                        <label class="form-check-label"
                                               for="${criteria.getValue()}">${criteria.getValue()}</label>
                                    </div>
                                </#list>
                            </div>
                        </div>

                        <p>
                            <button class="btn btn-light w-100" type="button" id="filterButton" data-toggle="collapse"
                                    data-target="#ramTypes"
                                    aria-expanded="true" aria-controls="collapseExample">
                                Тип памяти RAM
                            </button>
                        </p>
                        <div class="collapse mb-3<#if (laptopCriteria.getRamTypes()?size>0)>show</#if>" id="ramTypes">
                            <div class="card card-body">
                                <#list ramTypes as criteria>
                                    <div class="custom-control custom-checkbox py-2">
                                        <input class="form-check-input" type="checkbox" id="${criteria.getValue()}"
                                               name="ramTypes"
                                               value="${criteria.getValue()}"
                                                <#if laptopCriteria?has_content>
                                            <#list laptopCriteria.getRamTypes() as item>
                                                <#if item.getValue()?contains("${criteria.getValue()}")>checked</#if>
                                            </#list>
                                                </#if>>
                                        <label class="form-check-label"
                                               for="${criteria.getValue()}">${criteria.getValue()}</label>
                                    </div>
                                </#list>
                            </div>
                        </div>

                        <p>
                            <button class="btn btn-light w-100" type="button" id="filterButton" data-toggle="collapse"
                                    data-target="#storageTypes"
                                    aria-expanded="true" aria-controls="collapseExample">
                                Тип жесткого диска
                            </button>
                        </p>
                        <div class="collapse mb-3<#if (laptopCriteria.getStorageTypes()?size>0)>show</#if>"
                             id="storageTypes">
                            <div class="card card-body">
                                <#list storageTypes as criteria>
                                    <div class="custom-control custom-checkbox py-2">
                                        <input class="form-check-input" type="checkbox" id="${criteria.getValue()}"
                                               name="storageTypes"
                                               value="${criteria.getValue()}"
                                                <#if laptopCriteria?has_content>
                                            <#list laptopCriteria.getStorageTypes() as item>
                                                <#if item.getValue()?contains("${criteria.getValue()}")>checked</#if>
                                            </#list>
                                                </#if>>
                                        <label class="form-check-label"
                                               for="${criteria.getValue()}">${criteria.getValue()}</label>
                                    </div>
                                </#list>
                            </div>
                        </div>

                        <p>
                            <button class="btn btn-light w-100" type="button" id="filterButton" data-toggle="collapse"
                                    data-target="#storageSizes"
                                    aria-expanded="true" aria-controls="collapseExample">
                                Объем жесткого диска
                            </button>
                        </p>
                        <div class="collapse mb-3<#if (laptopCriteria.getStorageSizes()?size>0)>show</#if>"
                             id="storageSizes">
                            <div class="card card-body">
                                <#list storageSizes as criteria>
                                    <div class="custom-control custom-checkbox py-2">
                                        <input class="form-check-input" type="checkbox" id="${criteria.getValue()}"
                                               name="storageSizes"
                                               value="${criteria.getValue()}"
                                                <#if laptopCriteria?has_content>
                                            <#list laptopCriteria.getStorageSizes() as item>
                                                <#if item.getValue()?contains("${criteria.getValue()}")>checked</#if>
                                            </#list>
                                                </#if>>
                                        <label class="form-check-label"
                                               for="${criteria.getValue()}">${criteria.getValue()}</label>
                                    </div>
                                </#list>
                            </div>
                        </div>

                        <p>
                            <button type="submit" id="filter" class="btn btn-light my-2 w-100">Фильтровать
                            </button>
                        </p>
                    </form>

                </div>

                <div class="col-xs-7 col-sm-8 col-md-9 col-lg-10" id="allLaptops">

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

</div>


</body>

</html>