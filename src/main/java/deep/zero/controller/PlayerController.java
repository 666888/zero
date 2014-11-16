package deep.zero.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import deep.sys.bean.User;
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
		Long id = (Long)req.getSession().getAttribute("p_id");
		String p_name = playerSvc.get(id).getNickname();
		model.addAttribute("pName",p_name);
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
		Player player = playerSvc.getByAccount((String)req.getSession().getAttribute("p_code"));
		if(player.getPassword().equals(oldPassword)){
			player.setPassword(newPassword);
			playerSvc.modiPlayer(player);			
			System.out.println("++++++++++++++"+oldPassword+"++++++++"+newPassword);
			return "{\"a\":\"修改成功！\"}";
		}
		else{
			return "{\"a\":\"原密码不正确！\"}";
		}
	}
	
	@RequestMapping(value="/secureMail.ajax",method=RequestMethod.POST)
	@ResponseBody
	public Map secureMail(HttpServletRequest req,@RequestParam("email") String email){
		Player player = playerSvc.getByAccount((String)req.getSession().getAttribute("p_code"));
		player.setEmail(email);
		playerSvc.modiPlayer(player);
		Map map=new HashMap<String, Object>();
		if(player.getEmail().equals(email)){
//			System.out.println("++++++++++++++"+nickname+"+++++++"+oldPassword+"++++++++"+newPassword);
			map.put("e", true);
			String email1=player.getEmail();
			String email2=email1.substring(email1.length()-9,email1.length());
	    	String email3=email1.substring(0,email1.length()-10);
	    	System.out.println(email3+"*****"+email2);
			map.put("msg", "已绑定("+email3+"*****"+email2+")");
			return map;
		}
		else{
			map.put("e", false);
			return map;
		}
	}
	
	@RequestMapping(value="/securePhone.ajax",method=RequestMethod.POST)
	@ResponseBody
	public Map securePhone(HttpServletRequest req,@RequestParam("phone") String phone){
		Player player = playerSvc.getByAccount((String)req.getSession().getAttribute("p_code"));
		player.setPhone(phone);
		playerSvc.modiPlayer(player);
		Map map=new HashMap<String, Object>();
		if(player.getPhone().equals(phone)){
//			System.out.println("++++++++++++++"+nickname+"+++++++"+oldPassword+"++++++++"+newPassword);
			map.put("p", true);
			String phone1=player.getPhone();
			String phone2=phone1.substring(phone1.length()-4,phone1.length());
	    	String phone3=phone1.substring(0,phone1.length()-8);
	    	System.out.println(phone3+"****"+phone2);
			map.put("msg", "已绑定("+phone3+"****"+phone2+")");
		}
		else{
			map.put("p", false);
		}
		return map;
	}
	
	@RequestMapping(value="/onload.ajax",method=RequestMethod.GET)
	@ResponseBody
	public Map securePhoneAndEmail(HttpServletRequest req){
		Player player = playerSvc.getByAccount((String)req.getSession().getAttribute("p_code"));
		Map map=new HashMap<String, Object>();
		if(!StringUtils.isBlank(player.getEmail())){
//			System.out.println("++++++++++++++"+nickname+"+++++++"+oldPassword+"++++++++"+newPassword);
			map.put("e", true);
			String email1=player.getEmail();
			String email2=email1.substring(email1.length()-9,email1.length());
	    	String email3=email1.substring(0,email1.length()-10);
	    	System.out.println(email3+"*****"+email2);
			map.put("eMsg", "已绑定("+email3+"*****"+email2+")");
		}
		else{
			map.put("e", false);
		}
		if(!StringUtils.isBlank(player.getPhone())){
//			System.out.println("++++++++++++++"+nickname+"+++++++"+oldPassword+"++++++++"+newPassword);
			String phone1=player.getPhone();
			String phone2=phone1.substring(phone1.length()-4,phone1.length());
	    	String phone3=phone1.substring(0,phone1.length()-8);
	    	System.out.println(phone3+"****"+phone2);
			map.put("pMsg", "已绑定("+phone3+"****"+phone2+")");
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
		Player player = playerSvc.getByAccount((String)req.getSession().getAttribute("p_code"));
		model.addAttribute("player", player);		
		return "player/modifyNickname";
	}
	
	private static final String TEMPLATE = "Hello %s";
	private final AtomicLong counter = new AtomicLong();
	
}
