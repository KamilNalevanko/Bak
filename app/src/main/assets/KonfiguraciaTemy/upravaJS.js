$(".home").click(function(){
    if($(".prvy").is(':visible'))
      {
		$(".prvy").animate({ width: 'hide' }); 
      }
      else
      {
        $(".prvy").animate({ width: 'show' }); 

      }
});