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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import deep.sys.bean.User;
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
	
	@RequestMapping(value="/modiPswd",method=RequestMethod.GET)
	public String password(){		
		return "player/addBalance";
	}

	@RequestMapping(value="/modiPswd.ajax",method=RequestMethod.POST)
	@ResponseBody
	public String password(HttpServletRequest req,@RequestParam("nickname") String nickname,@RequestParam("old") String oldPassword,@RequestParam("nw")String newPassword){
		Player player = playerSvc.getByAccount(nickname);
		if(player.getPassword().equals(oldPassword)){
			player.setPassword(newPassword);
			playerSvc.modiPlayer(player);			
			System.out.println("++++++++++++++"+nickname+"+++++++"+oldPassword+"++++++++"+newPassword);
			return "密码已修改!";
		}
		else{
			return "原密码错误!";
		}
	}
	
	private static final String TEMPLATE = "Hello %s";
	private final AtomicLong counter = new AtomicLong();
	
}
