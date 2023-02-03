/**
 * 
 */
 $(document).ready(function () {
      $(".nav-item:nth-child(5)").attr('class', 'nav-item active');
      $(".notactive:nth-child(5)").attr('class', 'active');
      
   });
   
	   
   function count(type,num)  {
	   
	   // 결과를 표시할 element
	   const resultElement = document.getElementById('result'+num);
	   const resultElement1 = document.getElementById('result1');
	   const resultElement2 = document.getElementById('result2');
	   const over = document.getElementById('over-count-num');
	   const basic = document.getElementById('basic-count');
	   
	   // 현재 화면에 표시된 값
	   let number = resultElement.innerText;
	   
	   let num1=parseInt(resultElement1.innerText);
	   let num2=parseInt(resultElement2.innerText);
	   let basic_num=parseInt(basic.innerText);
	   let over_number=parseInt(over.innerText);
	   let hap=num1+num2;
	   
	   
	   // 더하기/빼기
	   if(type === 'plus') {
		   if(hap<4){
			   if(number<4){
				     number = parseInt(number) + 1;
				     
				     if(hap+1>basic_num){
						   over_number=hap+1-basic_num;
						   over.innerText=over_number;
						   count_customer(over_number,basic_num);
						   
					   }
				     overchange(over_number);
			   }
		   }
	   }else if(type === 'minus')  {
		   if(hap>1){
			   if(number>0){
				   number = parseInt(number) - 1;
				   
				   if(hap-1>=basic_num){
					   over_number=hap-1-basic_num;
					   over.innerText=over_number;
					   count_customer(over_number,basic_num);
				   }
				   overchange(over_number);
			   }
		   }
	   }
	   
	   // 결과 출력
	   resultElement.innerText = number;
	   
	   
	 }
   
   function overchange(over_num){
	   if(over_num>0){
		   $("#over-count").css("display","flex");
		   $(".reservation-cost-container-total>div:nth-child(3)").css("display","flex");
		   
		   
	   }else{
		   $("#over-count").css("display","none");
		   $(".reservation-cost-container-total>div:nth-child(3)").css("display","none");
		   
	   }
	   
	   let over_cost=over_num*10000;
	   $("#result3").html(over_cost);
	   total_count();
	   
   }
   
   function addition_count(type,num){
	   const resultElement = document.getElementById('result'+num);
	   
	   let number = resultElement.innerText;
	   
	    if(type === 'plus') {
			   if(number==0){
				     number = parseInt(number) + 1;
				     $(".reservation-cost-container-total>div:nth-child("+num+")").css("display","flex");
		   }
	   }else if(type === 'minus')  {
			   if(number==1){
				   number = parseInt(number) - 1;
				   $(".reservation-cost-container-total>div:nth-child("+num+")").css("display","none");
		   }
	   }
	   
	   // 결과 출력
	   resultElement.innerText = number;
	   total_count();
   }
   
   function total_count(){
	   let result7=parseInt($('#result7').text());
	   let result3=parseInt($('#result3').text());
	   let result4=parseInt($('#result4').text());
	   let result5=parseInt($('#result5').text());
	   let result6=parseInt($('#result6').text());
	   let total_result=result7+result3+(result4*20000)+(result5*20000)+(result6*20000);
	   
	   $('#total_result').html(total_result);
   }
   
   function count_customer(over_number,basic_num){
	   $('#over_customer').html(over_number);
	   $('#total_customer').html(over_number+basic_num);
   }
   
   
   