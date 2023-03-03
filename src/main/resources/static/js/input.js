/**
 * 
 */
 
 
 /**
 * 
 */
 
 function inputCheck() {
	
	if(document.reg_frm.requestgr.value.length == 0) {
		alert("업무구분을 입력해주세요");
		reg_frm.requestgr.focus();
		return;		
	}

var requestdate = new Date(document.reg_frm.requestdate.value);
var enddate = new Date(document.reg_frm.enddate.value);

    // enddate가 requestdate보다 빠른 날짜인 경우
    if(enddate < requestdate) {
        alert("종료일은 요청일 이후로 설정해주세요.");
        reg_frm.enddate.focus();
        return;
    }

			alert("입력이 완료되었습니다.")


	document.reg_frm.submit();
	
}
	
 function updateCheck() {

	}

function finputCheck() {


	if(document.freg_frm.factnm.value.length == 0) {
		alert("사업장명을 입력해주세요");
		freg_frm.factnm.focus();
		return;		
	}
	
	alert("사업장이 등록되었습니다.")	
	document.freg_frm.submit();
	
}


function minputCheck() {


	if(document.mreg_frm.managernm.value.length == 0) {
		alert("담당자명을 입력해주세요");
		mreg_frm.managernm.focus();
		return;
	}

	document.mreg_frm.submit();

}