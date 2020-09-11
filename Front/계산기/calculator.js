	$(function(){
		var cl="";
		var tmp="";
		$(".btn").click(function(){
			tmp=$("#result").text();
			cl = $(this).val();
			console.log(cl);
			$("div#result").append(cl); 
		});
		$(".btn.CE").click(function(){
			$("div#result").html(""); 
		});
		
		$(".btn.RS").click(function(){
			var rs = $("#result").text();
			var res = eval(tmp);
			rs += res;
			$("div#result").html("");
			$("div#result").append(eval(tmp));
			
			console.log(rs);
			$("div#note").append(rs).append("<br>");
		});
});
