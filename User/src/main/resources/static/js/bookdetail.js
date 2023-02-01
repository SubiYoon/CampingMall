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
	   let over_num=parseInt(basic.innerText);
	   let hap=num1+num2;
	   
	   
	   // 더하기/빼기
	   if(type === 'plus') {
		   if(hap<4){
			   if(number<4){
				     number = parseInt(number) + 1;
				     
				     if(hap+1>basic_num){
						   over_number=hap+1-basic_num;
						   over.innerText=over_number;
					   }
				     overchange(over_number);
			   }
		   }
	   }else if(type === 'minus')  {
		   if(hap>1){
			   if(number>0){
				   number = parseInt(number) - 1;
				   
				   if(hap-1>=basic_num){
					   console.log(1111111);
					   over_number=hap-1-basic_num;
					   over.innerText=over_number;
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
	   }else{
		   $("#over-count").css("display","none");
	   }
	   
   }