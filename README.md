<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>sri ram rohit</title>
</head>
<body>
  
    

    <h1>performing arithmetic operation on the two numbers</h1>
    <input type="text" id="num1" placeholder="enter your number..">
    <select id="sel">
        <option id="plus">+</option>
        <option id="minus">-</option>
        <option id="multi">*</option>
        <option id="divi">/</option>
    </select>
    <input type="text" id="num2" placeholder="enter your number.."><br><br>
    <button onclick="asm()">result</button><br><br>
    <input type="text" id="result" placeholder="your result is appear here...">
  

<script>
   function asm(){
    var num1=Number(document.getElementById("num1").value);
    var num2=Number(document.getElementById("num2").value);
    var res;
      if(document.getElementById("sel").value==document.getElementById("plus").value){
         res=num1+num2;
   
      }
     else if(document.getElementById("sel").value==document.getElementById("minus").value){
         res=num1-num2;
   
      }
      else if(document.getElementById("sel").value==document.getElementById("multi").value){
         res=num1*num2;
   
      } 
      else{
         res=num1/num2;
   
      }
      document.getElementById("result").value=res;
 

   }
</script>
</body>
</html>
