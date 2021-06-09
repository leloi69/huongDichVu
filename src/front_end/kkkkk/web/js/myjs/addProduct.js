var AddProduct = (function () {
    // var obj = JSON.parse(sessionStorage.currentProduct);
    var initial = function () {
        setDataForm();
        bindEvent();
    };

    var setDataForm = function () {

    };

    var bindEvent = function () {
        $(document).on('click','#cancle_add', function () {
            window.location.href = 'table.html';
        });
        $(document).on('click','#add', function () {
            var add = {};
            add.name = $('input[name=namea]').val();
            add.price = $('input[name=pricea]').val();
            add.quantities = $('input[name=quantitiesa]').val();
            add.type = $('#cake_type').val();
            add.des = $('input[name=desa]').val();
            $.ajax({
                url: "http://localhost:8088/api/v1/tasty",
                type: "POST",
                data: JSON.stringify({  "name" : add.name, "price" : add.price ,"des": add.des, "quantities": add.quantities, "category_id": add.type}),
                contentType: 'application/json',
                dataType: "json",
                // body : data,
                success: function(result) {
                    console.log(result);
                },
                error: function(error) {
                    console.log(error);
                }
            });
            window.location.href = 'table.html';
        });
    };

    return {
        initial: initial,
    }
})();
AddProduct.initial();