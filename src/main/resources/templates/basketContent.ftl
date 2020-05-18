<script>
    $(document).ready(function () {
        $(".deleteFromBasket").click(function (event) {
            var id = $(this).attr('value');
            function deleteProduct(id) {
                $.ajax({
                    type: "POST",
                    url: "/deleteFromBasket",
                    contentType: 'application/json',
                    dataType: 'text',
                    data: id,
                    success: function (data) {
                        console.log("Succes!")
                    }
                });
                getBasketContent();
            }
            deleteProduct(id);
        })

    });
</script>

<#list products as product>
    <div class="row justify-content-center" id="basketRow">
        <span class="col-12 col-sm-6 col-md-4 col-lg-4 align-self-center"><img id="imageLaptopBasket" src="${product.getPhoto()[0].getLocation()}"></span>
        <span class="col-12 col-sm-6 col-md-2 col-lg-2 align-self-center">${product.getLaptopManufacturer().getValue()}</span>
        <span class="col-12 col-sm-6 col-md-6 col-lg-3 align-self-center">${product.getModel()}</span>
        <span class="col-12 col-sm-3 col-md-6 col-lg-1 align-self-center">${product.getPrice()} UAH</span>
        <span class="col-12 col-sm-3 col-md-6 col-lg-2 align-self-center"><button class="btn btn-danger deleteFromBasket" value="${product.getId()}">Удалить</button></span>
    </div>
</#list>

<#if totalPrice?has_content>
    <div class="row" id="basketRowLast">
        <span class="col-4 align-self-center"></span>
        <span class="col-2 align-self-center"></span>
        <span class="col-3 align-self-center">СУММА: </span>
        <span class="col-1 align-self-center">${totalPrice} UAH</span>
        <span class="col-2 align-self-center"><button class="btn btn-success">Оплатить</button></span>
    </div>
</#if>