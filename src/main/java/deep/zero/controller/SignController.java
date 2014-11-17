package deep.zero.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import deep.zero.bean.Agent;
import deep.zero.bean.Player;
import deep.zero.svc.AgentSvc;
import deep.zero.svc.LoginSvc;
import deep.zero.svc.PlayerSvcImpl;
@Controller
public class SignController {
	
	@Autowired
	private LoginSvc loginSvc;
	
	@Autowired
	private PlayerSvcImpl playerSvc;
	
	@Autowired
	private AgentSvc agentSvc;
	
	//登录的GET
	@RequestMapping(value="/signin",method=RequestMethod.GET)
	public String Login(Model model){		
		Player player = new Player();
		model.addAttribute("player", player); 
		return "player/login";
	}
	/**
	 * 登录的post方法
	 * @param player
	 * @param model
	 * @param br
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/signin",method=RequestMethod.POST)
	public String Login(@ModelAttribute("player") Player player,Model model,BindingResult br,HttpServletRequest req){
		try{
			System.out.println("++++++++++++++后台验证+++++++++++++++");
			ValidationUtils.rejectIfEmptyOrWhitespace(br, "code",
					"code", "昵称不能为空");
			ValidationUtils.rejectIfEmptyOrWhitespace(br, "password",
					"password", "密码不能为空");
			if (br.hasErrors()) {
				// returning the errors on same page if any errors..
				model.addAttribute("player", player);
				return "player/signin";
				}
			else{
				if (loginSvc.validate(player)) {
					Long id = playerSvc.getByAccount(player.getCode()).getId();
					req.getSession().setAttribute("p_id", id);
					req.getSession().setAttribute("p_code", player.getCode());
					// Create a redirection view to success page. This will
					// redirect to UserController.
					System.out.println("用户已写入到session中...");
					
					return "redirect:/entry";
				} else {
					br.addError(new ObjectError("Invalid", "登录被拒绝  : 用户名或密码错误"));
					model.addAttribute("player",player);
					return "player/signin";
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception in LoginController " + e.getMessage());
			e.printStackTrace();
			model.addAttribute("player", player);
			return "player/signin";
		}		
	}
	@RequestMapping("/entry")
	public String entry(HttpServletRequest req,Model model){
		Long p_id = (Long)req.getSession().getAttribute("p_id");
		String p_name = playerSvc.get(p_id).getNickname();
		model.addAttribute("player",new Player());
		model.addAttribute("pName", p_name);
		
		return "player/login";		
	}
	@RequestMapping("/logout")
	public String logout(Model model,HttpServletRequest req){
		Player player = new Player();
		req.getSession().setAttribute("p_code", null);
		model.addAttribute("player", player);
		return "player/login";
	}
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String regist(Model model){
		Player player = new Player();
		model.addAttribute("player", player);
		return "player/register";
	}
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public String regist(@ModelAttribute Player player,Model model,BindingResult br,HttpServletRequest req){
		try{
			System.out.println("++++++++++++++后台验证+++++++++++++++");
			ValidationUtils.rejectIfEmptyOrWhitespace(br, "code",
					"code", "登陆码不能为空");
			ValidationUtils.rejectIfEmptyOrWhitespace(br, "password",
					"password", "密码不能为空");
			ValidationUtils.rejectIfEmptyOrWhitespace(br, "username",
					"username", "真实姓名不能为空");
			if(br.hasErrors()){
				return "player/register";
			}
			else{
				player.setNickname(player.getCode());
				player.setRegTime(new Date());
				playerSvc.addPlayer(player);				
				Long id = playerSvc.getByAccount(player.getCode()).getId();
				req.getSession().setAttribute("p_id", id);
				req.getSession().setAttribute("p_code", player.getCode());
				System.out.println("用户已写入到session中...");
				model.addAttribute("pName",player.getNickname());
				model.addAttribute("player",new Player());
				return "player/login";								
			}
		}
		catch(Exception e){
			System.out.println("Exception in LoginController " + e.getMessage());
			e.printStackTrace();		
			return "player/register";
		}		
	}
	
	@RequestMapping(value="verifyCode.ajax",method=RequestMethod.POST)
	@ResponseBody
	public String verifyCode(@RequestParam String code){
		Player player = playerSvc.getByAccount(code);
		if(player == null)
			return "true";
		else
			return "false";
	}
	
	/*
	 * Agent
	 * 
	 */
	//登录的GET
		@RequestMapping(value="/agsignin",method=RequestMethod.GET)
		public String agLogin(Model model){		
			Agent agent = new Agent();
			model.addAttribute("agent", agent); 
			return "agent/login";
		}
		/**
		 * 登录的post方法
		 * @return
		 */
		@RequestMapping(value="/agsignin",method=RequestMethod.POST)
		public String Login(@ModelAttribute("agent") Agent agent,Model model,BindingResult br,HttpServletRequest req){
			try{
				System.out.println("++++++++++++++后台验证+++++++++++++++");
				ValidationUtils.rejectIfEmptyOrWhitespace(br, "name",
						"name", "账号不能为空");
				ValidationUtils.rejectIfEmptyOrWhitespace(br, "password",
						"password", "密码不能为空");
				if (br.hasErrors()) {
					// returning the errors on same page if any errors..
					model.addAttribute("Agent", agent);
					return "agent/signin";
					}
				else{
					if (loginSvc.agentValidate(agent)) {
						Long id = agentSvc.getAgentByName(agent.getName()).getAgentid();
						req.getSession().setAttribute("a_id", id);
						req.getSession().setAttribute("a_name", agent.getName());
						// Create a redirection view to success page. This will
						// redirect to UserController.
						System.out.println("用户已写入到session中...");
						
						return "redirect:/agentry";
					} else {
						br.addError(new ObjectError("Invalid", "登录被拒绝  : 用户名或密码错误"));
						model.addAttribute("Agent",agent);
						return "agent/signin";
					}
				}
			}
			catch(Exception e){
				System.out.println("Exception in LoginController " + e.getMessage());
				e.printStackTrace();
				model.addAttribute("Agent", agent);
				return "agent/signin";
			}		
		}
		
		@RequestMapping("/agentry")
		public String agentry(HttpServletRequest req,Model model){
			String a_name = (String)req.getSession().getAttribute("a_name");
			//Agent agent = agentSvc.getAgentByName(a_name);
			model.addAttribute("agent",new Agent());
			model.addAttribute("agName", a_name);			
			return "agent/login";		
		}
		
		@RequestMapping(value="/agsignup",method=RequestMethod.GET)
		public String agregist(Model model){
			Agent agent = new Agent();
			model.addAttribute("agent", agent);
			return "agent/register";
		}
		@RequestMapping(value="/agsignup",method=RequestMethod.POST)
		public String agregist(@ModelAttribute Agent agent,Model model,BindingResult br,HttpServletRequest req){
			try{
				System.out.println("++++++++++++++后台验证+++++++++++++++");
				ValidationUtils.rejectIfEmptyOrWhitespace(br, "name",
						"name", "登陆码不能为空");
				ValidationUtils.rejectIfEmptyOrWhitespace(br, "password",
						"password", "密码不能为空");
				if(br.hasErrors()){
					return "agent/register";
				}
				else{					
					agentSvc.addAgent(agent);			
					Long id = agentSvc.getAgentByName(agent.getName()).getAgentid();
					req.getSession().setAttribute("a_id", id);
					req.getSession().setAttribute("a_name", agent.getName());
					System.out.println("用户已写入到session中...");
					model.addAttribute("aName",agent.getName());
					model.addAttribute("agent",new Agent());
					return "agent/login";								
				}
			}
			catch(Exception e){
				System.out.println("Exception in LoginController " + e.getMessage());
				e.printStackTrace();		
				return "agent/register";
			}		
		}
}
