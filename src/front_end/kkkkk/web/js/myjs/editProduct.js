var EditProduct = (function () {
    var obj = JSON.parse(sessionStorage.currentProduct);
    var initial = function () {
        setDataForm();
        bindEvent();
    };
    
    var setDataForm = function () {
        $('input[name=idE]').val(obj.id);
        $('input[name=nameE]').val(obj.name);
        $('input[name=priceE]').val(obj.price);
        $('input[name=quantitiesE]').val(obj.quantities);
        $('#cake_type').val(2);
        $('input[name=desE]').val(obj.des);
    };

    var bindEvent = function () {
        $(document).on('click','#cancle_edit', function () {
            window.location.href = 'table.html';
        });
        $(document).on('click','#edit', function () {
            var update = {};
            update.name = $('input[name=nameE]').val();
            update.price = $('input[name=priceE]').val();
            update.quantities = $('input[name=quantitiesE]').val();
            update.type = $('#cake_type').val();
            update.des = $('input[name=desE]').val();
            $.ajax({
                url: "http://localhost:8088/api/v1/tasty/"+ obj.id,
                type: "PUT",
                data: JSON.stringify({ "id": obj.id,"des": update.des,"name" : update.name, "price" : update.price ,"quantities": update.quantities, "category_id": update.type}),
                contentType: 'application/json',
                dataType: "json",
                // body : data,
                success: function(result) {
                    window.location.href = 'table.html';
                    console.log(result);
                },
                error: function(error) {
                    window.location.href = 'table.html';
                    console.log(error);
                }
            });
        });
    };

    return {
        initial: initial,
    }
})();
EditProduct.initial();