# vinay1


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
   
</head>
<body>
    <h1>code for the perform arithmetic operations for the two numbers</h1>
    <input type="text" id="num1" placeholder="num1">
    <select id="opt">
        <option id="add" >+</option>
        <option id="sub">-</option>
        <option id="multi">*</option>
        <option id="divi">/</option>
    </select>
    <input type="text" id="num2" placeholder="num2">
    <button onclick="asm()" >find</button>
    <input type="text" id="result" placeholder="your result is appear here..">
<script>
    function asm(){
        var num1=Number(document.getElementById("num1").value);
        var num2=Number(document.getElementById("num2").value);
        if(document.getElementById("opt").value==document.getElementById("add").value){
            var res=num1+num2;
            document.getElementById("result").value=res;
        }
       else if(document.getElementById("opt").value==document.getElementById("sub").value){
            var res=num1-num2;
            document.getElementById("result").value=res;
        }
        else if(document.getElementById("opt").value==document.getElementById("multi").value){
            var res=num1*num2;
            document.getElementById("result").value=res;
        }
         else{
            var res=num1/num2;
            document.getElementById("result").value=res;
        }
    }
</script>
</body>
</html>
