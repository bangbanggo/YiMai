var result = "";
var url = '';
$.ajax({
    url:"json_getuserinfo",
    success:function (data) {
        var da = eval(data);
        result = da.username;
        if (result!=""){
            url="#";
        }else {
            result = "登录";
        }
    }
})

var header = new Vue({
    el:"#header",
    data:{
        username:result,
        url:url
    }
})