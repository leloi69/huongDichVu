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
               '<td>'+ obj[i].name +'</td>' +
               '<td>'+ obj[i].price +'</td>' +
               '<td>'+ obj[i].category_id +'</td>' +
               '<td>'+ obj[i].quantities +'</td>' +
               '<td>'+ obj[i].des +'</td>' +
               '<td>' +
               '<button id="editT">Sửa</button>' +
               '<button id="deleteT">Xóa</button>' +
               '</td>' +
               '</tr>'
       }
       $("#tableBody").html(html);
   };

   var getAllData = function () {
       $.ajax({
           url: 'http://localhost:8088/api/v1/tasty',
           type: "GET",
           success: function(result) {
               if(result.length > 0) {
                   sessionStorage.setItem("product",JSON.stringify(result));
                   var obj = JSON.parse(sessionStorage.product);
                   drawData(result);
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
       $(document).on('click','#addT', function () {
           window.location.href = 'add.html';
       });
       $(document).on('click','#editT', function () {
           var currentRow = $(this).closest('tr');
           var currentProduct = {};
           currentProduct.id = currentRow.find("td:eq(0)").text();
           currentProduct.name = currentRow.find("td:eq(1)").text();
           currentProduct.price = currentRow.find("td:eq(2)").text();
           currentProduct.type = currentRow.find("td:eq(3)").text();
           currentProduct.quantities = currentRow.find("td:eq(4)").text();
           currentProduct.des = currentRow.find("td:eq(5)").text();
           sessionStorage.setItem("currentProduct",JSON.stringify(currentProduct));

           window.location.href = 'edit.html';
           // $(this).closest('tr').find('td').each(function() {
           //     var textval = $(this).text(); // this will be the text of each <td>
           // });

       });
       $(document).on('click','#deleteT', function () {
           var currentRow = $(this).closest('tr');
           var id = currentRow.find("td:eq(0)").text();
           $.ajax({
               url: "http://localhost:8088/api/v1/tasty/"+id,
               type: "DELETE",
               success: function(result) {
                   console.log(result);
                   window.location.href = 'table.html';
               },
               error: function(error) {
                   console.log(error);
               }
           });
       });
   };

   return{
       initial:initial,
   }

})();
ProductTasty.initial();