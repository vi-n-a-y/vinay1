<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculator</title>
</head>
<body>
  
    

    <h1>performing arithmetic operation on the two numbers</h1>
    <input type="text" id="num1" placeholder="enter your number..">
    <select id="sel">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>
    <input type="text" id="num2" placeholder="enter your number.."><br><br>
    <button onclick="asm()">result</button><br><br>
    <input type="text" id="result" placeholder="your result is appear here...">
  

<script>
   function asm(){
    var num1=Number(document.getElementById("num1").value);
    var num2=Number(document.getElementById("num2").value);
    var res;
       var op=document.getElementById("sel").value;
      if(op=="+"){
         res=num1+num2;
   
      }
     else if(op=="-"){
         res=num1-num2;
   
      }
      else if(op=="*"){
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
