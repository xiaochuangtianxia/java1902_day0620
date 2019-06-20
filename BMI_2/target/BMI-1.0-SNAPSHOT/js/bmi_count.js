function cal() {
    var height=document.getElementById("height").value;
    var weight=document.getElementById("weight").value;
    var genders=document.getElementsByName("sex");

    //计算bmi指数
    var bmi=weight/(height*height*0.01*0.01);
    bmi=Math.round(bmi*100)/100;
    document.getElementById("cal_bmi").innerText=bmi;
    var zt;

    //计算标准体重
    for(var i=0;i<genders.length;i++){
       if(genders[i].checked){
           var sex= genders[i].id;
       }
    }
    if(sex=="male"){
        var bztz=(height-80)*0.7;
        bztz=Math.round(bztz*100)/100;
        if(bmi<18.5){
            document.getElementById("cal_zt").innerText="偏瘦";
            document.getElementById("cal_pohto").src="img/3_01.jpg";
        }
        else if (bmi>=18.5 && bmi < 24 ){
            document.getElementById("cal_zt").innerText="正常";
            document.getElementById("cal_pohto").src="img/3_02.jpg";
        }
        else if (bmi>=24 && bmi < 28 ){
            document.getElementById("cal_zt").innerText="过重";
            document.getElementById("cal_pohto").src="img/3_03.jpg";
        }
        else if (bmi>=28 ){
            document.getElementById("cal_zt").innerText="肥胖";
            document.getElementById("cal_pohto").src="img/3_04.jpg";
        }
        document.getElementById("bztz_id").innerText=bztz;
    }
    else if(sex="female"){
        var bztz=(height-70)*0.6;
        bztz=Math.round(bztz*100)/100;
        if(bmi<18.5){
            document.getElementById("cal_zt").innerText="偏瘦";
            document.getElementById("cal_pohto").src="img/3_01_01.jpg";
        }
        else if (bmi>=18.5 && bmi < 24 ){
            document.getElementById("cal_zt").innerText="正常";
            document.getElementById("cal_pohto").src="img/3_01_03.jpg";
        }
        else if (bmi>=24 && bmi < 28 ){
            document.getElementById("cal_zt").innerText="过重";
            document.getElementById("cal_pohto").src="img/3_01_04.jpg";
        }
        else if (bmi>=28 ){
            document.getElementById("cal_zt").innerText="肥胖";
            document.getElementById("cal_pohto").src="img/3_01_05.jpg";
        }
        document.getElementById("bztz_id").innerText=bztz;
     }


    var d=new Date();
    var year=d.getFullYear();
    var month=d.getMonth()+1;
    var mydate=year+"-"+month;
    var sign=d.getTime();
     var xhr=new XMLHttpRequest();
    var url="http://localhost:8080/bmi?action=add&h="+height+"&w="+weight+"&bmi="+bmi+"&date="+mydate+"&sign="+sign;
    xhr.open("GET",url,true);
    xhr.send(null);
    xhr.onreadystatechange=function () {
        if(xhr.readyState==4 && xhr.status==200){
            var res1=xhr.responseText;
            alert(res1);
            document.getElementById("div1").innerText=res1;

        }
    }


}