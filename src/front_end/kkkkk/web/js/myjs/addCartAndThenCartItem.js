var AddCartAndCartItem = (function () {
    var initial =function () {
        bindEvent();
    };

    var bindEvent = function () {
        $(document).on('click','#checkoutT', function () {
            var addr = $('input[name=addr]').val();
            var sdt = $('input[name=sdt]').val();
            var cartTasty = JSON.parse(sessionStorage.CartTasty);
            var user = JSON.parse(sessionStorage.user);
            var amount = 0;
            var today = new Date();
            var date = today.getDate() +'/'+ today.getMonth() +'/' + today.getFullYear() + " " +
                        today.getHours()+':'+today.getMinutes()+':'+today.getSeconds();
            var userId = user.id;
            for (var i = 0; i < cartTasty.length; i++) {
                amount += cartTasty[i].amount;
            }
            if (cartTasty.length > 0) {
                $.ajax({
                    url: "http://localhost:8088/api/v1/cart",
                    type: "post",
                    data: JSON.stringify({ "id": 10, "cost" : amount, "user_id": userId, "created_at": date, "phone": sdt, "address": addr}),
                    contentType: 'application/json',
                    // dataType: "json",
                    // body : data,
                    success: function(result) {
                        alert('Đã thêm mới đơn hàng');
                        window.location.href = 'index.html';
                        console.log(result);
                    },
                    error: function(error) {
                        console.log(error);
                    }
                });

                $.ajax({
                    url: 'http://localhost:8088/api/v1/cart',
                    type: "GET",
                    success: function(result) {
                        if(result.length > 0) {
                            sessionStorage.setItem("allCart",JSON.stringify(result));
                        } else {
                        }
                    },
                    error: function(error) {
                        console.log(error);
                    }
                });
                var cartId = 1;
                var obj = JSON.parse(sessionStorage.allCart);
                if(obj) {
                        cartId = obj[obj.length - 1].id + 1;
                }

                if (cartTasty.length > 0) {
                    for (var i = 0; i < cartTasty.length; i++) {
                        var unitPrice = cartTasty[i].quantity * cartTasty[i].amount;
                        $.ajax({
                            url: "http://localhost:8088/api/v1/cartItem",
                            type: "post",
                            data: JSON.stringify({ "cart_id" : cartId, "tasty_id": cartTasty[i].id, "quantities": cartTasty[i].quantity, "unit_price": unitPrice}),
                            contentType: 'application/json',
                            // dataType: "json",
                            // body : data,
                            success: function(result) {
                                console.log(result);
                            },
                            error: function(error) {
                                console.log(error);
                            }
                        });
                    }
                }
            }
            // window.location.href = 'index.html';
        });
    };

    return {
        initial: initial
    }
})();
AddCartAndCartItem.initial();