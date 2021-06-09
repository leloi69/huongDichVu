var Cake = (function () {
    var initial = function () {
        getDataByCartegory();
    };

    var drawData = function (obj) {
        var html = '';
        for (var i = 0; i < obj.length; i++) {
            html += '<div class="col-md-3 w3ls_w3l_banner_left">' +
                '<div class="hover14 column">' +
                '<div class="agile_top_brand_left_grid w3l_agile_top_brand_left_grid">' +
                '<div class="agile_top_brand_left_grid1">' +
                '<figure>' +
                '<div class="snipcart-item block">' +
                '<div class="snipcart-thumb">' +
                '<img src="images/img/'+obj[i].name+'.jpg" alt=" " class="img-responsive" />' +
                '<p>'+obj[i].name+'</p>' +
                '<h4>'+obj[i].price+'</h4>' +
                '</div>' +
                '<div class="snipcart-details">' +
                '<form action="#" method="post">' +
                '<fieldset>' +
                '<input type="hidden" name="cmd" value="_cart" />' +
                '<input type="hidden" name="add" value="1" />' +
                '<input type="hidden" name="id" value="'+obj[i].id+'" />' +
                '<input type="hidden" name="item_name" value="'+obj[i].name+'" />' +
                '<input type="hidden" name="amount" value="'+obj[i].price+'" />' +
                '<input type="hidden" name="discount_amount" value="0" />' +
                '<input type="hidden" name="currency_code" value="VND" />' +
                '<input type="hidden" name="return" value=" " />' +
                '<input type="hidden" name="cancel_return" value=" " />' +
                '<input type="submit" name="submit" value="Thêm Vào Giỏ" class="button" />' +
                '</fieldset>' +
                '</form>' +
                '</div>' +
                '</div>' +
                '</figure>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '</div>'
        }
        html += '<div class="clearfix"> </div>';
        $('#packk').html(html);
    };

    var getDataByCartegory = function () {
        if (!sessionStorage.tastyByCake) {
            $.ajax({
                url: 'http://localhost:8088/api/v1/tasty?category_id=2',
                type: "GET",
                success: function(result) {
                    if(result.length > 0) {
                        sessionStorage.setItem("tastyByCake",JSON.stringify(result));
                        drawData(result);
                    } else {
                        alert("không thể kết nối");
                    }
                },
                error: function(error) {
                    console.log(error);
                }
            });
        } else {
            var obj = JSON.parse(sessionStorage.tastyByCake);
            drawData(obj);
        }
    };

    return {
        initial: initial,
    }
})();
Cake.initial();