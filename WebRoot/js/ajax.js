function SignOut() {
	$.ajax({
			  type: 'POST',
			  url: "SignOut.action",
			  data: {},
			  success:function(data){
				  if(data.signout_msg=="SIGNOUT-SUCC") {
				  	  window.location.href="index.jsp";
				  } else {
				  	  alert("请尝试刷新界面");
				  }
			  }
	});
}