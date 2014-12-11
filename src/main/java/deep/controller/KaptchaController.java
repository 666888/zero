package deep.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.servlet.KaptchaExtend;

@Controller
@RequestMapping(value="/pub")
public class KaptchaController extends Kaptcha {

	@RequestMapping(value="/kaptcha",method = RequestMethod.GET)
	public void captcha(HttpServletRequest req ,HttpServletResponse resp) throws ServletException , IOException
	{
		super.captcha(req, resp);
		//String s = (String) req.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);;
		//System.out.println("当前的验证码为：【   "+s+"  】");
		
	}

	@RequestMapping(value="/register",method = RequestMethod.GET)
	public ModelAndView regGet(@RequestParam(value="error",required=false) boolean failed,
			HttpServletRequest request){
		ModelAndView model = new ModelAndView("reg_get");
		//
		// model MUST contain HTML with <img src="/captcha.jpg"> tag
		//
		return model;
	}

	@RequestMapping(value="/register",method = RequestMethod.POST)
	public ModelAndView regPost(@RequestParam(value="email",required=true) String email,
			@RequestParam(value="password",required=true) String password,HttpServletRequest request){
		ModelAndView model = new ModelAndView("reg_post");
		
		if(email.isEmpty())
			throw new RuntimeException("email empty");

		if(password.isEmpty())
			throw new RuntimeException("empty password");

		String captcha = request.getParameter("captcha");

		if(!captcha.equals(getGeneratedKey(request)))
			throw new RuntimeException("bad captcha");
		//
		// Everything is ok. proceed with your usr registration / login process 
		//
		return model; 
	}
}
