/*!gwebpack - 1.0.0-2018-04-12 */$(function () {
  $('.nav-item>a').on('click', function () {
    if (!$('.nav').hasClass('nav-mini')) {
      if ($(this).next().css('display') === "none") {
        $('.nav-item').children('ul').slideUp(300);
        $(this).next('ul').slideDown(300);
        $(this).parent('li').addClass('nav-show').siblings('li').removeClass('nav-show');
      } else {
        $(this).next('ul').slideUp(300);
        $('.nav-item.nav-show').removeClass('nav-show');
      }
    }
  });
  $('#mini').on('click', function () {
    if (!$('.nav').hasClass('nav-mini')) {
      $('.nav-item.nav-show').removeClass('nav-show');
      $('.nav-item').children('ul').removeAttr('style');
      $('.nav').addClass('nav-mini');
      $('.i-container').css("margin-left","36px");
      $('.scroll-wrapper').css("overflow-y","inherit");
      $('.icon-more').css("visibility","hidden");
    } else {
      $('.nav').removeClass('nav-mini');
      $('.i-container').css("margin-left","180px");
      $('.scroll-wrapper').css("overflow-y","auto");
      $('.icon-more').css("visibility","visible");
    }
  });
});