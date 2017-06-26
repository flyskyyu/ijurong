$(function () {
    $("#navSearch").click(function () {
        if ($("#searchWarp").is(":animated")) return;
        if ($(this).attr("active") == "off") {
         //   $("#searchWarp").animate({"top": "100%"}, 200);
			$("#searchWarp").slideDown(200);
            $(this).attr("active", "on");
        } else {
          //  $("#searchWarp").animate({"top": "90%","display":"none"}, 200);
			$("#searchWarp").slideUp(200);
            $(this).attr("active", "off");
        }

    });

    $("#backToTop").on("click", function () {
        $(window).scrollTop(0);
    });
    $(window).scroll(function () {
        // if ($(window).scrollTop() > 32) {
        //     $(".header").css("top")&& $(".header").css("top", 0);
        // }else{
        //     $(".header").css("top")=="0px"&& $(".header").css("top", 33);
        // }
        if ($("#backToTop").css("display") != "none" && $(window).scrollTop() <= 600) {
            $("#backToTop").hide();
        } else if ($("#backToTop").css("display") == "none" && $(window).scrollTop() > 600) {
            $("#backToTop").show();
        }
    })
});