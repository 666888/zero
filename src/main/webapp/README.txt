 在更改webapp目录下的文件时请认真阅读此文件

1.目录结构
	webapp
	   |
	   |--- META-INF
	   |
	   |--- cdn
	   |     |
	   |     |--- gm      		// GameManager后台管理
	   |     |
	   |     |--- player		// 玩家部分也就是主站功能 
	   |     |
	   |	 |--- ...
	   | 
	   |---- WEB-INF
	   |		|
	   |		|--- v
	   |		|
	   |		|--- web.xml 
	   |
	   |
	   |
	   
	   
一般情况下，我们会将所有静态页面放置在cdn下，静态文件又可划分为两类，一类是我们自有文件，另一部分是可以通过公共cdn获取到的（如jquery.js）等，
我们自有的文件划分为整站部分（如：site.css）及模块部分，模块部分需要建立相应的目录来存储，整站部分可直接放置到cdn目录下，注意：静态文件中引用
其它文件时要求使用相对路径，否则不能放入cdn目录及其子目录中。

WEB-INF 下的v目录用以放置jsp文件，它是spring mvc 中view 文件所在的目录，也分为整站部分和模块部分，整站部分可直接放置v下，模块部分需
建立相应的目录存放。


系统包括了一个前端的玩家功能和一个后端的管理功能，以前端的功能为主，后端的功能需要访问http://yourdomain/gm,在系统中会有两个登录页面分别对
应这两个模块

用户登录的过程如下：
1.直接访问/index.html页面，在这个页面是引导页面，还有两个功能，其一是登录系统， 另一个是注册页面，点击后进入到玩家注册页面，玩家注册页面完成后进入到系统中。
2.如果玩家登录时输入了错误的用户名或者密码，则引导入完整的登录页面进行登录，在这个完整的登录页面中需要输入验证码。
