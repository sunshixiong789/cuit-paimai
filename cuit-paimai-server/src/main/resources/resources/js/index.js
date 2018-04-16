$(document).ready(function(){
    $.ajax({
        type: "get",
        async: false,
        url: "cuitPicture/0",
        dataType: "json",
        success: function (result,status,xhr) {
            $("#slider-img1").attr('src',"/cuitfile/download?id=0&fileName="+result[0].pictureName)
            $("#slider-img2").attr('src',"/cuitfile/download?id=0&fileName="+result[1].pictureName)
            $("#slider-img3").attr('src',"/cuitfile/download?id=0&fileName="+result[2].pictureName)
            $("#slider-img4").attr('src',"/cuitfile/download?id=0&fileName="+result[3].pictureName)
        },
        error: function (xhr,status,error) {
        }
    });
});