package deep.zero.controller;

import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import deep.sys.bean.User;
import deep.zero.bean.Player;
import deep.zero.svc.PlayerSvc;

/**
 * 此类用以完成玩家的注册、登录、登出、冻结、等功能 
 * @author Administrator
 *
 */
@Controller
public class PlayerController {
	@Autowired
	private PlayerSvc playerSvc;
	
	@RequestMapping(value="/regist",method=RequestMethod.GET)
	public String regist(Model model){
		Player player = new Player();
		model.addAttribute("player", player);
		return "player/register";
	}
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String regist(@ModelAttribute Player player,Model model,BindingResult br){
		player.setCode("55");
		player.setUserName("xiaoming");
		playerSvc.addPlayer(player);
		model.addAttribute("player", new Player());
		return "player/login";
	}
	
	@RequestMapping(value="/player/{id}",method=RequestMethod.GET)
	public String show(@PathVariable Long id,Model model){
		model.addAttribute(playerSvc.get(id));
		return "player/update";
	}
	@RequestMapping(value="/player/{id}/delete",method=RequestMethod.GET)
	public String del(@PathVariable Long id){
			playerSvc.delPlayer(id);
			return "redirect:/player/list";
	}	
	
	@RequestMapping(value="/player/{id}/update",method=RequestMethod.GET)
	public String update(@PathVariable Long id,Model model){
		model.addAttribute(playerSvc.get(id));
		return "player/update";
	}
	
	@RequestMapping(value="/player/{id}/update",method=RequestMethod.POST)
	public String update(@PathVariable Long id,@Validated Player player,BindingResult br){
		if(br.hasErrors())
			return "player/update";
		playerSvc.modiPlayer(player);
		return "redirect:/player/list";
	}
	
	@RequestMapping(value="/player/modiPswd",method=RequestMethod.GET)
	public String password(){		
		return "player/pswd";
	}

	@RequestMapping(value="/player/modiPswd",method=RequestMethod.POST)
	public @ResponseBody String password(HttpServletRequest req,String oldPassword,String newPassword){
		Player player = (Player)req.getSession().getAttribute("ray_user");
		if(player.getPassword().equals(oldPassword)){
			player.setPassword(newPassword);
			playerSvc.modiPlayer(player);
			return "密码已修改!";
		}
		else{
			return "原密码错误!";
		}
	}
	
	private static final String TEMPLATE = "Hello %s";
	private final AtomicLong counter = new AtomicLong();
	
}
