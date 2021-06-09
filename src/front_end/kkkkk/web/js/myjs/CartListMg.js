var ProductTasty = (function () {
    var initial = function () {
        getAllData();
        bindEvent();
    };

    var drawData = function (obj) {
        var html = '';
        for (var i = 0; i < obj.length; i++) {
            html += '<tr>' +
                '<td>'+ obj[i].id +'</td>' +
                '<td>'+ obj[i].address +'</td>' +
                '<td>'+ obj[i].cost +'</td>' +
                '<td>'+ obj[i].phone +'</td>' +
                '<td>'+ obj[i].user_id +'</td>' +
                '</tr>'
        }
        $("#tableBody").html(html);
    };

    var getAllData = function () {
        $.ajax({
            url: 'http://localhost:8088/api/v1/cart',
            type: "GET",
            success: function(result) {
                if(result.length > 0) {
                    sessionStorage.setItem("CartList",JSON.stringify(result));
                    var obj = JSON.parse(sessionStorage.CartList);
                    drawData(obj);
                } else {
                    alert("không thể kết nối");
                }
            },
            error: function(error) {
                console.log(error);
            }
        });
    };

    var bindEvent = function () {
    };

    return{
        initial:initial,
    }

})();
ProductTasty.initial();