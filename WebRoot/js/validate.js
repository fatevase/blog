$('#sign-form')
		.form({
			fields : {
						username: {
							identifier : 'username',
							//depends    : 'isDoctor',
							rules      : [
								{
									type   : 'empty',
									prompt : '用户名输入不能为空'
								},
								{
									type   : 'regExp[/^[a-z0-9_-]{4,16}$/]',
									prompt : '请输入4～16位的英文和数字组合'
								}
							]
						},
						password1: {
							identifier : 'password1',
							//depends    : 'isDoctor',
							rules      : [
								{
									type   : 'empty',
									prompt : '密码输入不能为空'
								},
								{
									type   : 'regExp[/^[^*]{6,18}$/]',
									prompt : '请输入6～18位的密码组合'
								}
							]
						},
						usermail: {
							identifier : 'usermail',
							//depends    : 'isDoctor',
							rules      : [
								{
									type   : 'email',
									prompt : '邮箱格式不对'
								}
							]
						},
						password2: {
							identifier : 'password2',
							//depends    : 'isDoctor',
							rules      : [
								{
									type   : 'match[password1]',
									prompt : '两次密码要输入一致'
								}
							]
						}
					},
			on     : 'blur'
		})
	;

$('#comment-form')
.form({
	fields : {
				commentvalue: {
					identifier : 'commentvalue',
					rules      : [
						{
							type   : 'empty',
							prompt : '评论不能为空'
						},
						{
							type: 'regExp',
							value: /^(([^\^\.<>%&',;=?$"':#@!~\]\[{}\\/`\|])*)$/i,
							prompt : '禁止提交特殊字符'
						}
					]
				}
			},
	on     : 'blur'
})
;