$(document).ready(function(){
	
		$("#start").click(function(){
			var numbers = new Array(6);
			var flags = new Array(46);
			
			for(var i=0;i<flags.length;i++){
				flags[i]=false;
			}
			for(var i=0;i<numbers.length;i++){
				do{
					number = Math.ceil(Math.random()*45);
				}while(flags[number==true]);
				numbers[i]=number;
				flags[number]=true;
			}
			console.log(numbers);
			var cnt=0;
			var start = setInterval(function(){
				var input = "<p>"+numbers[cnt++]+"</p>";
				$("div.here").append(input);
				
				if(cnt==6){
					clearInterval(start);
				}
				
			},1000);
			
		});
		
		$("#reset").click(function(){
			$("p").remove();
			
		})
			
	});