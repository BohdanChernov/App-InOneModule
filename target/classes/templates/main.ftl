<#import "pager.ftl" as p>

<script>
    $(document).ready(function () {

        $(".addToBasket").click(function (event) {
            var id = $(this).attr('value');

            $( this ).animate({
                width: "70%",
                opacity: 0.4,
                borderWidth: "10px"
            }, 1500 );

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

            addCookie(id);
        })


        $(".page-link").click(function (event) {
            event.preventDefault();
            var pageValueButtom = $(this).attr('value');
            var sortPr = "${sortPrice}";
            ajax_submit(pageValueButtom, sortPr, "null");
        })

        $(".dropdown-item").click(function (event) {
            event.preventDefault();
            var sortButtom = $(this).attr('value');
            ajax_submit(0, sortButtom, "null");
        })
    });
</script>

<div class="row">
    <div class="form-inline">
        <#if page.content?has_content>

            <span class="pr-2"><@p.pager "" page></@p.pager></span>

            <div class="btn-group" id="pageNumber">
                <button type="button" class="btn dropdown-toggle" id="pageNumber"
                        data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">
                    <#if sortPrice?exists >
                        <#if sortPrice == "highPrice">
                            От дорогих к дешевым
                        <#else >
                            От дешевых к дорогим
                        </#if>
                    <#else>
                        От дешевых к дорогим
                    </#if>
                </button>
                <div class="dropdown-menu dropdown-menu-right">
                    <form method="post" id="form2">
                        <button form="form1" class="dropdown-item" type="submit" name="sortPrice"
                                value="lowPrice">
                            От дешевых к дорогим
                        </button>
                        <button form="form1" class="dropdown-item" type="submit" name="sortPrice"
                                value="highPrice">
                            От дорогих к дешевым
                        </button>
                    </form>
                </div>
            </div>

        </#if>
    </div>
</div>

<div class="row">
    <#if !page.content?has_content>
        <br>
        Попробуйте другие критерии поиска...
    </#if>
    <#list page.content as i>
        <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 text-center" id="load">
            <div class="container-fluid card border-0" id="containerCard">
                <div class="row card border-0" id="rowPhoto">
                    <form method="post" action="/product">
                        <button class="container-fluid" type="submit" name="idOfProduct" id="photo"
                                value="${i.getId()}">
                            <div class="card border-0"><#if i.getPhoto()?has_content><img
                                    src="${i.getPhoto()[0].getLocation()}"
                                    id="photo"
                                    class="img-thumbnail border-0 border-box"
                                    alt="Responsive image"></#if></div>
                        </button>
                    </form>
                </div>
                <div class="row card border-0" id="rowDescription">
                    <p>${i.getLaptopManufacturer().getValue()}</p>
                    <p>${i.getModel()}</p>
                    <p>Диагональ дисплея: ${i.getDisplayDiagonal().getValue()}</p>
                    <p>Цена: ${i.getPrice()}</p>
                </div>
                <div class="row card border-0" id="rowBuy">
                        <button class="btn btn btn-light w-100 addToBasket" id="addToBasket" value="${i.getId()}">Добавить в
                            корзину
                        </button>
                </div>
            </div>
        </div>
    </#list>
</div>

<div class="row">
    <#if page.content?has_content>
        <span class="pr-2"><@p.pager "" page></@p.pager></span>
    </#if>
</div>
