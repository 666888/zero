package deep.sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import deep.sys.bean.User;
import deep.sys.svc.PermissionSvc;
import deep.sys.svc.RoleSvc;
import deep.sys.svc.UserSvc;
import deep.tool.TemplateDB;

@Controller
@RequestMapping("/gm")
public class InitSysController {
	
	@Autowired
	UserSvc us ;
	@Autowired
	RoleSvc rs ;
	
	@RequestMapping(value="/Init",method=RequestMethod.GET)
	public String password(HttpServletRequest req,Model model){
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		UserSvc us = (UserSvc)wac.getBean("userSvc");
		RoleSvc rs = (RoleSvc)wac.getBean("roleSvc");
		PermissionSvc ps = (PermissionSvc)wac.getBean("permissionSvc");
//		deep.tool.TemplateDB.init(us,rs,ps);
		List<User> userList=TemplateDB.InitDB(us,rs,ps);
		if(userList.size()>0){
			model.addAttribute("msg", "初始化成功");
			return "user/init";
		}
		else{
			model.addAttribute("msg", "初始化失败");
			return "user/init";
		}
	}
	

	
}
