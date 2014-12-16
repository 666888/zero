package deep.zero.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;

import deep.tool.EmailService;
import deep.tool.MailConstants;
import deep.zero.bean.Player;
import deep.zero.svc.PlayerSvcImpl;

/**
 * 此类用以完成玩家的注册、冻结、等功能 
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/p")
public class PlayerController {
	@Autowired
	private PlayerSvcImpl playerSvc;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET,params="json")
	@ResponseBody
	public Player sh(@PathVariable Long id){
		return playerSvc.get(id);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String show(@PathVariable Long id,Model model){
		model.addAttribute(playerSvc.get(id));
		return "player/update";
	}
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String del(@PathVariable Long id){
			playerSvc.delPlayer(id);
			return "redirect:/player/list";
	}	
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String update(@PathVariable Long id,Model model){
		model.addAttribute(playerSvc.get(id));
		return "player/update";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String update(@PathVariable Long id,@Validated Player player,BindingResult br){
		if(br.hasErrors())
			return "player/update";
		playerSvc.modiPlayer(player);
		return "redirect:/player/list";
	}
	
	@RequestMapping(value="/message",method=RequestMethod.GET)
	public String message(Model model,HttpServletRequest req){
		String code = (String)req.getSession().getAttribute("p_code");
		//String p_name = playerSvc.getByCode(code).getAbbrName();
		//此处使用注册号显示给前端，而不是使用昵称
		model.addAttribute("pName",code);
		if (req.getParameter("flag") != null) {
			model.addAttribute("upd_flag", "upd");
		}
		return "player/message";
	}
	/*
	@RequestMapping(value="/modiPswd",method=RequestMethod.GET)
	public String password(){		
		return "player/addBalance";
	}
	 */
	@RequestMapping(value="/modiPswd.ajax",method=RequestMethod.POST)
	@ResponseBody
	public String password(HttpServletRequest req,@RequestParam("old") String oldPassword,@RequestParam("nw")String newPassword){
		Player player = playerSvc.getByCode((String)req.getSession().getAttribute("p_code"));
		if(player.getPassword().equals(oldPassword)){
			player.setPassword(newPassword);
			playerSvc.modiPlayer(player);			
			return "{\"a\":\"修改成功！\"}";
		}
		else{
			return "{\"a\":\"原密码不正确！\"}";
		}
	}
	
	/**
	 * 绑定电子邮箱功能 ，用以找回密码，使用此功能时我们不做处理直接将email存入到数据库中
	 * 在实际的业务中我们可能会要求对其中的部分数据使用***来代替 , 在显示的时候需要做处理。
	 * 
	 * @param req
	 * @param email
	 * @return
	 */
	@RequestMapping(value="/secureMail.ajax",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> secureMail(HttpServletRequest req,@RequestParam("email") String email){
		Player player = playerSvc.getByCode((String)req.getSession().getAttribute("p_code"));
		Map<String,Object> map=new HashMap<String, Object>();
		if(email.equals(player.getEmail()))
		{
			map.put("e", true);
			map.put("msg", "已绑定邮箱");
		}
		else
		{
			player.setEmail(email);
			playerSvc.modiPlayer(player);
			map.put("e", true);
		}
		return map;
	}
	
	/**
	 * 设置账户的关联手机，以便可以通过手机来找回密码。
	 * 如果用户输入的同持久化的一致，不做操作，否则重新
	 * 持久化这个对象。
	 * @param req
	 * @param phone
	 * @return
	 */
	@RequestMapping(value="/securePhone.ajax",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap securePhone(HttpServletRequest req,@RequestParam String phone){
		Player player = playerSvc.getByCode((String)req.getSession().getAttribute("p_code"));
		ModelMap map = new ModelMap();
		String dp = player.getPhone();
		if(phone.equals(dp))
		{
			map.put("msg", "已绑定手机"+zero.util.Utils.vPhone(dp));
			map.put("p", true);
		}
		else
		{
			player.setPhone(phone);
            playerSvc.modiPlayer(player);
            if(dp==null)
            	dp="[ ]";
            map.put("msg", "绑定号码由"+dp+"更换为:"+phone);
            map.put("p", true);
		}
		
		return map;
	}
	
	/**
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/onload.ajax",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> securePhoneAndEmail(HttpServletRequest req){
		Player player = playerSvc.getByCode((String)req.getSession().getAttribute("p_code"));
		String email = player.getEmail();
		String phone = player.getPhone();
		Map<String,Object> map=new HashMap<String, Object>();
		if(!StringUtils.isBlank(email)){
			map.put("e", true);
			map.put("eMsg", "已绑定"+email);
		}
		else{
			map.put("e", false);
		}
		
		
		if(!StringUtils.isBlank(phone)){
			map.put("pMsg", "已绑定"+phone);
			map.put("p", true);
		}
		else{
			map.put("p", false);
		}
		return map;
	}
	
	@RequestMapping(value="/sendEmail.ajax",method=RequestMethod.GET)
	@ResponseBody
	public String sendEmail(){	
		String from=MailConstants.MALL_ACCOUNT;
		String to="";
		
		EmailService.sendHtmlEmail(from, to, MailConstants.EMAIL_FINDPASSWORD_DEFAULT_TITLE, MailConstants.EMAIL_FINDPASSWORD_DEFAULT_WORD);
		return null;
	}
	
	@RequestMapping(value="/modifyNickname",method=RequestMethod.GET)
	public String password(HttpServletRequest req,Model model){
		Player player = playerSvc.getByCode((String)req.getSession().getAttribute("p_code"));
		model.addAttribute("player", player);		
		return "player/modifyNickname";
	}
	
	
	//登录的GET
	@RequestMapping(value="/signin",method=RequestMethod.GET)
	public String Login(Model model){		
		Player player = new Player();
		model.addAttribute("player", player); 
		return "player/signin";
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
	public String signin(@ModelAttribute("player") Player player,Model model,BindingResult br,HttpServletRequest req){
		try{
			ValidationUtils.rejectIfEmptyOrWhitespace(br, "code","code", "昵称不能为空");
			ValidationUtils.rejectIfEmptyOrWhitespace(br, "password","password", "密码不能为空");
			if (br.hasErrors()) {
				// returning the errors on same page if any errors..
				model.addAttribute("player", player);
				return "player/signin";
				}
			else{
				if (playerSvc.validate(player.getCode(),player.getPassword())) {
					req.getSession().setAttribute("p_code", player.getCode());
					return "player/index";
					// Create a redirection view to success page. This will redirect to PlayerController.
					//return "redirect:/entry";
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
	
	/**
	 * 使用ajax 方式来完成登录到系统(此部分没有验证码)
	 * @param code			玩家的登录名称
	 * @param password		玩家的登录密码
	 * @return
	 */
	@RequestMapping(value="/signin0.ajax",method=RequestMethod.POST)
	@ResponseBody
	public Map<String ,String> login(@RequestParam("code") String code,@RequestParam("password") String password){
		Map<String ,String> map = new HashMap<String,String>();
		if(playerSvc.validate(code, password))
			map.put("code", code);
		else
			map.put("error", "用户名密码错误！");
		return map;
	}
	
	
	/**
	 * 使用ajax方式来完成登录到系统
	 * 登录方法要求有验证码的校验
	 * @param code			玩家登录的登录名
	 * @param password		玩家登录的密码
	 * @param valiCode		玩家输入的验证码
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/signin.ajax",method=RequestMethod.POST)
	@ResponseBody
	public Map<String ,String> signin(@RequestParam String code,@RequestParam String password,@RequestParam String valiCode,HttpServletRequest req){
		Map<String ,String> map = new HashMap<String,String>();
		String kaptcha = (String)req.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if(!kaptcha.equals(valiCode))
		{
			map.put("error", "验证码有误");
		}
		else
		{
			if(playerSvc.validate(code, password))
			{
				//将登录名写入到session
				map.put("code", code);
			}
			else
			{
				map.put("error", "用户名密码错误！");
			}
		}
		return map;
	}
	
	
	@RequestMapping("/entry")
	public String entry(HttpServletRequest req,Model model){
		Long p_id = (Long)req.getSession().getAttribute("p_id");
		String p_name = playerSvc.get(p_id).getAbbrName();
		model.addAttribute("player",new Player());
		model.addAttribute("pName", p_name);
		return "player/index";		
	}
	
	/**
	 * 玩家的登出功能 ，执行后清除了session中的有关些玩家的p_code值，并将页面
	 * 跳转到玩家登录页面。
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping("/signout")
	public String signout(Model model,HttpServletRequest req){
		Player player = new Player();
		req.getSession().setAttribute("p_code", null);
		model.addAttribute("player", player);
		return "player/signin";
	}
	
	/**************  玩家注册   ****************/
	
	/**
	 * 玩家注册的实现 GET 请求
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String singnup(Model model){
		Player player = new Player();
		model.addAttribute("player", player);
		return "player/register";
	}
	
	/**
	 * 玩家注册的实现 
	 * @param player
	 * @param model
	 * @param br
	 * @param req
	 * @return
	 * 
	 * 玩家注册需要不可为空的部分使用服务器端验证，要求code  password 及username 不可为空。
	 * 如以上属性中有任一个为空，则返回注册页面。
	 * 如果这三个属性都不为空，则可以通过注册，此时系统默认会在session存入玩家的用户名 昵称（默认和用户名相同）
	 * 注册时间 注册时的ip地址,注册完成后跳转到登录页面。
	 * 
	 * 使用Spring的服务器验证验证对不可为空的数据进行二次的的验证
	 * 对于使用自己写验证方法,可以加入到BindingResult 中，但要注意在使用国际化时,
	 * 要使用ObjectError("vCodeErr",new String["vCodeErr"],null,"vCodeErr")
	 * 也可以使用ObjectError("vCodeErr",ContextLoader.getCurrentWebApplicationContext().getMessage("vCodeErr",null,null))
	 * 其中第一个参数是资源文件的键值，第二个参数是资源文件的字符串的参数，由于本字符串没有参数，所以用null,第三个参数是一个java.util.Local类型
	 * 的参数，默认为null,表示使用浏览器默认语言
	 */
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public String signup(@ModelAttribute Player player,Model model,BindingResult br,String valiCode,HttpServletRequest req){
		try{
			ValidationUtils.rejectIfEmptyOrWhitespace(br, "code","userNotNull", "Require SignName");
			ValidationUtils.rejectIfEmptyOrWhitespace(br, "password","password", "Require Password");
			ValidationUtils.rejectIfEmptyOrWhitespace(br, "name","name", "Require UserName");
			String kaptcha = (String)req.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
			if(!kaptcha.equals(valiCode))
				br.addError(new ObjectError("vCodeErr",new String[]{"vCodeErr"},null,"vCodeErr"));
			if(br.hasErrors()){
				model.addAttribute("player", player);
				return "player/register";
			}
			else
			{
				player.setRegTime(new Date());
				player.setRegIP(deep.util.HttpUtil.getIPAddr(req)); 
				Player p = playerSvc.addPlayer(player);							
				req.getSession().setAttribute("p_code", player.getCode());	
				model.addAttribute("player",p);
				return "player/signin";								
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in PlayerController " + e.getMessage());
			e.printStackTrace();		
			return "player/register";
		}		
	}
	/**
	 * 系统中的玩家的用户名不可以重复，所有注册时要验证当前的用户名是否已存在
	 * 如果存在则请使用其它用户名
	 * @param code
	 * @return
	 */
	@RequestMapping(value="verifyCode.ajax",method=RequestMethod.POST)
	@ResponseBody
	public String verifyCode(@RequestParam String code){
		Player player = playerSvc.getByCode(code);
		if(player == null)
			return "true";
		else
			return "false";
	}
	
	
	private static final String TEMPLATE = "Hello %s";
	private final AtomicLong counter = new AtomicLong();
	
}
