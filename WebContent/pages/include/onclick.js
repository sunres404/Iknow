
//前往页面函数
function goMain(){
	window.location.href="main.html";
}
function goEssay(){
	window.location.href="essay.html";
}
function goLogin(){
	window.location.href="login.html";
}
function goKind(){
	window.location.href="kind.html";
}
function goRegister(){
	window.location.href="register.html";
}
function goResult(){
	window.location.href="result.html";
}
function goUser(){
	window.location.href="user.html";
}
function goWrite(){
	window.location.href="write.html";
}
//登录检验函数
function loginChack(){
	var username=document.getElementById("username").value;
	var passcode=document.getElementById("passcode").value;
	if(username==""){
		alert("用户名为空，你仿佛在逗我");
	}
	if(passcode==""){
		alert("密码为空，你丫账号不设密码的")
	}
	if(username!=""&&passcode!=""){
		alert("userName=lne&userPassword=lne");
		window.location.href="main.html";
	}
}
//注册检验函数
function registerChack(){
	var username=document.getElementById("username").value;
	
	var passcode=document.getElementById("passcode").value;
	var repasscode=document.getElementById("repasscode").value;
	if(username=="") alert("呵呵，你的用户名呢");
	if(repasscode!=passcode) alert("两次密码不一致，你是要用两个密码吗");
	if(username!=""&&repasscode!=""&&passcode!=""&&repasscode==passcode){
		alert("恭喜"+username+"注册成功");
		alert("userName=lne&userPassword=lne");
		window.location.href="main.html";
	}
}
//分类函数
function select(kind){
	for(var i=1;i<=7;i++){
		var str=document.getElementById('kind'+i);
		if(str!=document.getElementById(kind)){
			str.style.backgroundColor='#c0c0c0';
			str.classList.remove("on");
		}else{
			str.classList.add("on");
			str.style.backgroundColor='#595959';
			var obj=document.getElementById("otherkind");
			if(obj){
				var order=0;
				for(var j=1;j<=4;j++){
					var strOrder=document.getElementById('otherkind'+j);
					if(strOrder.classList.contains("on2")==true){
						order=j;
					}
				}
				alert("kind="+i+"&"+"order="+order);
			}else{
				alert("kind="+i);
			}
			
		}		
	}
}
function selectother(otherkind){
	for(var i=1;i<=4;i++){
		var str=document.getElementById('otherkind'+i);
		str.classList.remove("on2");
		if(str!=document.getElementById(otherkind)){
			
			str.style.backgroundColor='#c0c0c0';
			
		}else{
			str.classList.add("on2");	
			str.style.backgroundColor='#595959';
			var kind=0;
			var obj=document.getElementById("kind");
			if(obj){
				for(var j=1;j<=7;j++){
					var strKind=document.getElementById('kind'+j);
					if(strKind.classList.contains("on")==true){
						kind=j;
					}
				}
				alert("kind="+kind+"&"+"order="+i);
			}else{
				alert("order="+i);
			}
			
		}		
	}
}
//分页函数
function page(obj){
	var pageid=document.getElementsByClassName("page");
	for(var i=0;i<pageid.length;i++){
		if(pageid[i]!=obj){
			pageid[i].classList.remove("active");	
		}
	}
	obj.classList.add("active");
	alert("page="+obj.value);
}
function formPage(){
	var pageid=document.getElementsByClassName("page");
	for(var i=0;i<pageid.length;i++){
		if(pageid[i].classList.contains("active")==true){
			if(i-1>=0){
				pageid[i].classList.remove("active");
				pageid[i-1].classList.add("active");
				alert("page="+pageid[i-1].value);
			}	
		}
	}
	
}
function nextPage(){
	var pageid=document.getElementsByClassName("page");
	for(var i=0;i<pageid.length;i++){
		if(pageid[i].classList.contains("active")==true){
			if(i+1<pageid.length){
				pageid[i].classList.remove("active");
				pageid[i+1].classList.add("active");
				alert("page="+pageid[i+1].value);
				break;
			}	
		}
	}
	
}

