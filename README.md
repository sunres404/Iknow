# Iknow
javaweb课程设计，文章发布系统


切记，编码设为utf-8

M:
	bean:
		文章和用户的基本信息
	dao:
		操作数据库，增删改查
V:
	前端页面
		basic.html 		把上面相同的信息做成一个头部，后面直接引入
		login.html 		登录页面
		write.html 		发布文章页
		kind.html 		分类页
		main.html 		首页
		result.html 	搜索结果页
		essay.html 		文章内容页
		user.html 		用户页
		register.html 	注册页
	Action:一律用首字母大写+Servlet,例如：user.html ---> UserServlet
	举例：
		<form action="UserServlet" method="post">
			<label>用户名称：</label>
			<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id=username" />
			<br />
			<br />
			<label>用户密码：</label>
			<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
			<br />
			<br />
			<input type="submit" value="登录" id="sub_btn" />											
		</form>
C:
	service：
		接受用户传来的信息，判断并，调用数据库，并完成对象的返回
	servlet:
		接受用户传来的信息，传入service层，收到service层的信息，传回给用户

	filter:
		过滤器，实现自动登陆，以及编码设置
		session cookie utf-8

		过滤器：未登录点击我的，跳转到登录页面