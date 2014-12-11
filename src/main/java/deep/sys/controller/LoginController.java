package deep.sys.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import deep.sys.ApplicationModel;
import deep.sys.bean.User;
import deep.sys.svc.LoginService;

@Controller
@RequestMapping("/gm")
public class LoginController {

	// Create the User object user
	private User user;
	@Autowired
	private LoginService loginService;

	/**
	 * This method will load the login.jsp when the application start
	 * 
	 * @return
	 */
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView init() {
		user = new User();
		return new ModelAndView("gm/login", "loginDetails", user);
	}

	/**
	 * This method will be called when the user submits the login details from
	 * login.jsp page. If there is any error it will be displayed on the same
	 * page, if the user is valid then, will be redirected to the success page.
	 * 
	 * @param user
	 * @param br
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("loginDetails") User user,
			BindingResult br, HttpServletRequest req, HttpServletResponse res) {
		try {
			// Using Spring ValidationUtils class to check for the empty fields.
			// This will add the error if any in the br object
			ValidationUtils.rejectIfEmptyOrWhitespace(br, "code",
					"code", "登录号不能为空");
			ValidationUtils.rejectIfEmptyOrWhitespace(br, "password",
					"password", "密码不能为空");

			if (br.hasErrors()) {
				// returning the errors on same page if any errors..
				return new ModelAndView("gm/login", "loginDetails", user);
			} else {
				// If the user details is validated then redirecting the user to
				// success page.
				// else returning the error message on login page.
				if (loginService.validate(user)) {
					req.getSession().setAttribute("u_name", user.getCode());
					// Create a redirection view to success page. This will
					// redirect to UserController.
					
					UsernamePasswordToken token = new UsernamePasswordToken(user.getCode(),user.getPassword());
					String rememberMe = req.getParameter("remember_me");
					if(rememberMe!=null)
					{
						token.setRememberMe(true);
					}
					Subject currentUser = SecurityUtils.getSubject();
					currentUser.login(token);
					System.out.println(token.getPrincipal());
					RedirectView redirectView = new RedirectView("entry", true);
					return new ModelAndView(redirectView);
				} else {
					br.addError(new ObjectError("Invalid", "登录被拒绝  : 用户名或密码错误"));
					return new ModelAndView("gm/login", "loginDetails", user);
				}
			}
		} catch (Exception e) {
			System.out.println("Exception in LoginController " + e.getMessage());
			e.printStackTrace();
			return new ModelAndView("gm/login", "loginDetails", user);
		}
	}

	@RequestMapping(value = "/entry", method = RequestMethod.GET)
	public ModelAndView entry(HttpServletRequest req, HttpServletResponse res) {
		ApplicationModel applicationModel = new ApplicationModel();
		user = (User) req.getSession().getAttribute("ray_usr");
		applicationModel.setUser(user);
		return new ModelAndView("user/index", "applicationModel", applicationModel);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest hsr) {		
		hsr.getSession().setAttribute("ray_usr", null);
		//return "login";
		user = new User();		
		return new ModelAndView("login", "loginDetails", user);
	}
	/*
	 * @RequestMapping(value="/login",method=RequestMethod.GET) public String
	 * login(User user){ return "login"; }
	 * 
	 * 
	 * @RequestMapping(method=RequestMethod.POST) public String
	 * processForm(@Valid User usr,BindingResult result,Map model){ String
	 * userName = "admin"; String password = "admin"; if(result.hasErrors()){
	 * return "/"; }
	 * if(!usr.getUsername().equals(userName)||!usr.getPassword().equals
	 * (password)){ return "loginErr"; } model.put("user", usr); return
	 * "/entry"; }
	 */
}
