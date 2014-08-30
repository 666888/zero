package deep.zero.controller;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import deep.zero.bean.Player;
import deep.zero.svc.LoginSvc;
import deep.zero.svc.PlayerSvc;
@Controller
public class CLoginController {
	
	private Player player;
	@Autowired
	private LoginSvc loginSvc;
	@Autowired
	private PlayerSvc playerSvc;
	
	@RequestMapping(value="/signin",method=RequestMethod.GET)
	public String Login(Model model){		
		player = new Player();
		model.addAttribute("player", player);
		return "player/login";
	}
	@RequestMapping(value="/signin",method=RequestMethod.POST)
	public String Login(@ModelAttribute("player") Player player,Model model,BindingResult br,HttpServletRequest req, HttpServletResponse res){
		try{
			System.out.println("++++++++++++++后台验证+++++++++++++++");
			ValidationUtils.rejectIfEmptyOrWhitespace(br, "nickname",
					"nickname", "昵称不能为空");
			ValidationUtils.rejectIfEmptyOrWhitespace(br, "password",
					"password", "密码不能为空");
			if (br.hasErrors()) {
				// returning the errors on same page if any errors..
				model.addAttribute("player", player);
				return "player/login";
				}
			else{
				if (loginSvc.validate(player)) {
					req.getSession().setAttribute("p_name", player.getNickname());
					// Create a redirection view to success page. This will
					// redirect to UserController.
					System.out.println("用户已写入到session中...");
					
					return "redirect:/entry";
				} else {
					br.addError(new ObjectError("Invalid", "登录被拒绝  : 用户名或密码错误"));
					model.addAttribute("player",player);
					return "player/login";
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception in LoginController " + e.getMessage());
			e.printStackTrace();
			model.addAttribute("player", player);
			return "player/login";
		}		
	}
	@RequestMapping("/entry")
	public String entry(HttpServletRequest req,Model model){
		player = (Player)req.getSession().getAttribute("ray_usr");
		model.addAttribute("player", player);
		return "success";		
	}
	@RequestMapping("/logout")
	public String logout(Model model,HttpServletRequest req){
		req.getSession().setAttribute("ray_usr", null);
		model.addAttribute("player", null);
		return "player/login";
	}
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String regist(Model model){
		Player player = new Player();
		model.addAttribute("player", player);
		return "player/register";
	}
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public String regist(@ModelAttribute Player player,Model model,BindingResult br){
		player.setCode("55");
		player.setUsername("xiaoming");
		playerSvc.addPlayer(player);
		model.addAttribute("player", new Player());
		return "player/login";
	}
}
