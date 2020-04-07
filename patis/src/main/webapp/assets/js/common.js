function numberFormat(number, length) {
	 var zero = '';
	 number = number.toString();
	
	 if (number.length < length) {
	  for (i = 0; i < length - number.length; i++)
	   zero += '0';
	 }
	 return zero + number;
}

function isEmpty(value){ 
	if( value == "" || value == null || value == undefined || 
	  ( value != null && typeof value == "object" && !Object.keys(value).length )){ 
		return true 
	} else{ 
		return false 
	}
};


function validationInputLength(e){
	var flag = false;
	
	if(e.length >= 30) {
		alert("검색할 내용이 너무 길어 데이터를 반영할 수 없습니다.");
		
		flag = true;
	}
	
	return flag;
}

function pageLink(url) {
	$('#frm-link').attr('action', url);
	$('#frm-link').submit();
}

function setCookie(cookieName, value, exdays){
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;
}
 
function getCookie(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if(start != -1){
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}

function deleteCookie(cookieName){
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}
 
function adminLogoutBtn(){
	var answer = confirm("로그아웃 하시겠습니까?");
	
	if(answer) {
		var mainFrm = document.getElementById("moveMainFrm");
		mainFrm.submit();
	} else {
		return;
	}

}



function moveMypageBtn(){
	var pageFrm = document.getElementById("moveMypageFrm");
	pageFrm.submit();
}


function moveFindId(){
	var frm = document.getElementById("moveFindIdFrm");
	
	frm.submit();
}


function moveFindPass(){
var frm = document.getElementById("moveFindPassFrm");
	
	frm.submit();
}


function findIdType1(){
	
	var name = document.getElementById("searchBirth_name").value;
	var reg = document.getElementById("searchBirth_day").value;
	var mobile = document.getElementById("searchBirth_num").value;
	
	if(name.length < 1 || (reg.length < 1 || reg.length > 8) || mobile.length < 1) {
		alert("정확한 값을 입력해주세요");
		return;
	}
	
	
	var frmName = document.getElementById("find-name");
	var frmReg = document.getElementById("find-reg");
	var frmMobile = document.getElementById("find-mobile");
	
	frmName.value = name;
	frmReg.value = reg;
	frmMobile.value = mobile;
	
	document.getElementById("resultIdFrm").submit();
	
}


function findIdType2(){
	var name = document.getElementById("searchName").value;
	var email = document.getElementById("searchEmail").value;
	
	if(name.length < 1 || email.length < 1) {
		alert("정확한 값을 입력해주세요");
		return;
	}
	
	var frmName = document.getElementById("find2-name");
	var frmEmail = document.getElementById("find2-email");
	
	frmName.value = name;
	frmEmail.value = email;
	
	document.getElementById("resultId2Frm").submit();
	
}



function moveLogin(){
	document.getElementById("moveLoginFrm").submit();
}

function moveFindPass(){
	document.getElementById("moveFindPassFrm").submit();
}



function loginAni(){
	
	var inputId = document.getElementById("loginId").value;
	var inputPass = document.getElementById("loginPass").value;
	
	if(inputId.length < 1 || inputPass.length < 1) {
		alert("아이디/비밀번호를 입력하세요.");
		return;
	}
	
	// 애니메이션 --실행--
	$(".loading").css("display", "block");
	
	
	document.getElementById("mainLoginFrm").submit();
	
	
}


function enterkeyLogin() {
	
    if (window.event.keyCode == 13) {

    	loginAni();
    }
}



