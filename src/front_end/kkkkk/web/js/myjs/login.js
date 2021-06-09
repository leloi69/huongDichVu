var Login = (function () {
    var initial =function () {
      bindEvent();
    };

    var bindEvent = function () {
        $(document).on('click','#login', function () {
            var name = $('input[name=Username]').val();
            var pass = $('input[name=Password]').val();
            $.ajax({
                url: 'http://localhost:8088/api/v1/users?name='+name,
                type: "GET",
                success: function(result) {
                    if(result.length > 0) {
                        if (pass === result[0].pass) {
                            var obj = {name: result[0].name, pass: result[0].pass, id: result[0].id};
                            sessionStorage.setItem("user",JSON.stringify(obj));
                            var obj = JSON.parse(sessionStorage.user);
                            if (result[0].emp) {
                                window.location.href = 'table.html';
                            } else {
                                window.location.href = 'index.html';
                            }
                        } else {
                            alert("sai mật khẩu");
                        }
                    } else {
                        alert("sai mật khẩu hoặc tên đăng nhập");
                    }
                },
                error: function(error) {
                    console.log(error);
                }
            });
        });
        $(document).on('click','#register', function () {
            var user = {};
            user.name = $('input[name=UserName]').val();
            user.pass = $('input[name=PassWord]').val();
            var rePass = $('input[name=rePassword]').val();
            if (user.pass === rePass) {
                $.ajax({
                    url: "http://localhost:8088/api/v1/users",
                    type: "post",
                    data: JSON.stringify({ "name" : user.name, "pass": user.pass}),
                    contentType: 'application/json',
                    success: function(result) {
                        console.log(result);
                        alert("tạo thành công");
                        window.location.href = 'login.html';
                    },
                    error: function(error) {
                        console.log(error);
                    }
                });
            } else {
                alert("mật khẩu nhập lại phải trùng khớp");
            }
        })
    };

    return {
        initial: initial
    }
})();
Login.initial();