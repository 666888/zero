package deep.sys.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;








import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import deep.sys.bean.Role;
import deep.sys.bean.User;
import deep.sys.svc.RoleSvc;
import deep.sys.svc.UserSvc;
import deep.web.OnlineListener;

@Controller
@RequestMapping("/gm")
public class UserController {
	
	@Autowired
	UserSvc us ;
	@Autowired
	RoleSvc rs ;
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("users",us.getAll());
		model.addAttribute("roles", rs.getAll());
		return "user/list";
	}

	/*开启modelDriven 1
	public String add(Model model){		
		model.addAttribute(new User());
		return "user/add";
	}*/
	//开启modelDriven 2
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	@RequiresPermissions("user:find")
	public String add(@ModelAttribute("user") User user){
		return "user/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Validated User user,BindingResult br){
		if(br.hasErrors()){
			return "user/add";
		}
		us.addUser(user);
		return "redirect:/gm/list";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@RequiresRoles("admin")
	public String show(@PathVariable Long id,Model model){
		model.addAttribute(us.get(id));
		return "user/update";
	}
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String del(@PathVariable Long id){
			us.delUser(id);
			return "redirect:/user/list";
	}	
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String update(@PathVariable Long id,Model model){
		model.addAttribute(us.get(id));
		return "user/update";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String update(@PathVariable Long id,@Validated User user,BindingResult br){
		if(br.hasErrors())
			return "user/add";
		us.modiUser(user);
		return "redirect:/gm/list";
	}
	
	@RequestMapping(value="/modiPswd",method=RequestMethod.GET)
	public String password(){		
		return "user/pswd";
	}

	@RequestMapping(value="/modiPswd",method=RequestMethod.POST)
	public @ResponseBody String password(HttpServletRequest req,String oldPassword,String newPassword){
		User usr = (User)req.getSession().getAttribute("ray_user");
		if(usr.getPassword().equals(oldPassword)){
			usr.setPassword(newPassword);
			us.modiUser(usr);
			return "密码已修改!";
		}
		else{
			return "原密码错误!";
		}
	}
	
	@RequestMapping(value="/playerManager",method=RequestMethod.GET)
	public String playerManager(){
		return "user/player_manage";
	}
	
	@RequestMapping(value="/template_tools",method=RequestMethod.GET)
	public String template_tools(){
		return "user/template_tools";
	}
	
	@RequestMapping(value="/system_manage",method=RequestMethod.GET)
	public String system_manage(){
		return "user/system_manage";
	}
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public String products(){
		return "user/products";
	}
	
	@RequestMapping(value="/payments",method=RequestMethod.GET)
	public String payments(){
		return "user/payments";
	}
	
	@RequestMapping(value="/risk_manage",method=RequestMethod.GET)
	public String risk_manage(){
		return "user/risk_manage";
	}
	
	@RequestMapping(value="/monitor_report",method=RequestMethod.GET)
	public String monitor_report(){
		return "user/monitor_report";
	}
	
	@RequestMapping(value="/userManager",method=RequestMethod.GET)
	public String userManager(Model model){
		model.addAttribute("users", us.getAll());

		return "user/user_manage";
	}
	
	
	@RequestMapping(value="/playerOnline",method=RequestMethod.GET)
	public String playerOnline(Model model){
		model.addAttribute("map", new OnlineListener().getOnlinePlayer());
		return "user/player_manage/player_online";
	}
	
	@RequestMapping(value="/modifyRole.ajax",method=RequestMethod.POST)
	@ResponseBody
	public String modifyRole(Long id,Long role){
		System.out.println(id+role);
		User u = us.get(id);
		Set s = new HashSet();
		s.add(rs.getOne(role));
		u.setRoles(s);
		us.addUser(u);
		//JsonConfig jsonConfig = new JsonConfig();  
		//jsonConfig.setExcludes(new String[]{"roles"});
		//JSONObject json=JSONObject.fromObject(u,jsonConfig);
		
		//String a = json.toString();
		//return a;
		
		//Json jsonObj = new Json();
		String jsonStr ="";
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("Convert Java object to JSON format.");
		try {
			jsonStr = mapper.writeValueAsString(u);
		     //mapper.writeValue(new File("c:\\jackson.json"), u);
		} catch (JsonGenerationException e) {
		 
		} catch (JsonMappingException e) {
		 
		} catch (IOException e) {
		 
		}
		return jsonStr;
	}
	//提出用户
	@RequestMapping(value="/kick",method=RequestMethod.GET)
	public String kick(@RequestParam String nickname){
		HttpSession session = OnlineListener.getSession(nickname);
		OnlineListener.map.remove(session);
		//session.setAttribute(nickname, null);
		//session.invalidate();
		session.setMaxInactiveInterval(1);
		return "redirect:/gm/playerOnline";
	}
	
	private static final String TEMPLATE = "Hello %s";
	private final AtomicLong counter = new AtomicLong();
	
	
	//@RequestMapping("/greeting")
	//public @ResponseBody Greeting greeting(
		//	@RequestParam(value="name",required=false,defaultValue="world") String name){
		//return new Greeting(counter.incrementAndGet(),String.format(TEMPLATE, name));
	//}

	
}
