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
C:
	service：
		接受用户传来的信息，判断并，调用数据库，并完成对象的返回
	servlet:
		接受用户传来的信息，传入service层，收到service层的信息，传回给用户
	filter:
		过滤器，实现自动登陆，以及编码设置	