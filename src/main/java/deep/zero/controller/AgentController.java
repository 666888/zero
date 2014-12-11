package deep.zero.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import deep.zero.bean.Agent;
import deep.zero.svc.AgentSvc;

@Controller
@RequestMapping("/a")
public class AgentController {
	@Autowired
	private AgentSvc svc;
	
	/**
	 * 代理登录功能，主要由三个方法组成，前两个方法为GET POST方法，后一个为ajax的方法
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/signin",method=RequestMethod.GET)
	public String signin(Model model){
		Agent a = new Agent();
		model.addAttribute("agent", a);
		return "agent/signin";	
	}
	
	@RequestMapping(value="/signin",method=RequestMethod.POST)
	public String signin(@ModelAttribute("agent") Agent agent ,Model model,BindingResult br,String valiCode,HttpServletRequest req){
		try{
			ValidationUtils.rejectIfEmptyOrWhitespace(br, "code","code", "用户名不能为空");
			ValidationUtils.rejectIfEmptyOrWhitespace(br, "password", "password","密码不能为空");
			String kaptcha = (String)req.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
			if(!kaptcha.equals(valiCode))
				br.addError(new ObjectError("Invalid","登录被拒绝：验证码错误"));
			if(br.hasErrors())
			{
				// returning the errors on same page if any errors..
				model.addAttribute("Agent", agent);
				return "agent/signin";
			}
			else
			{
				if(svc.validate(agent.getCode(), agent.getPassword()))
				{
					req.getSession().setAttribute("ag_code", agent.getCode());
					return "redirect:/entry";
				}
				else
				{
					br.addError(new ObjectError("Invalid", "登录被拒绝  : 用户名或密码错误"));
					model.addAttribute("agent", agent);
					return "agent/signin";
				}
			}
				
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("Agent", agent);
			return "agent/signin";
		}
	}
	/**
	 * 使用ajax 方式来完成登录到代理系统
	 * @param code
	 * @param password
	 * @param valiCode
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/signin.ajax",method=RequestMethod.POST)
	@ResponseBody
	public Map<String ,String> signin(@RequestParam String code,@RequestParam String password,@RequestParam String valiCode,HttpServletRequest req){
		Map<String ,String> map = new HashMap<String,String>();
		//此处没有写验证码的部分
		String kaptcha = (String)req.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if(!kaptcha.equals(valiCode))
		{
			map.put("error", "验证码有误");
		}
		else
		{
			if(svc.validate(code, password))
			{
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
	public String entry (HttpServletRequest req,Model model){
		String code = (String)req.getSession().getAttribute("agcode");
		model.addAttribute("agent", new Agent());
		return "agent/entry";
		
	}
	
	/**
	 * 代理注册功能，对应增删改查中的 增
	 * 向数据集中增加一条记录
	 * 涉及到增加的都需要使用GET和POST两个方法来实现,GET 主要完成是第一次的请求
	 * POST方式主要用来处理提交功能。
	 * @return
	 */
	@RequestMapping(value="/signup", method=RequestMethod.GET )
	public String reg(Model model){
		Agent agent = new Agent();
		model.addAttribute("agent", agent);
		return "agent/reg";
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public String reg(@ModelAttribute Agent agent, Model model,BindingResult br,HttpServletRequest req){
		try{
			ValidationUtils.rejectIfEmptyOrWhitespace(br, "code", "code","账号不能为空");
			ValidationUtils.rejectIfEmptyOrWhitespace(br, "password", "password", "密码不能为空");
			//此处少写了验证码
			if(br.hasErrors()){
				return "agent/reg";
			}	
			else
			{
				Agent a = svc.save(agent);
				req.getSession().setAttribute("agid", a.getId());
				model.addAttribute("aName",agent.getName());
				model.addAttribute("agent",new Agent());
				return "agent/signin";	
			}
		}catch(Exception e){
			e.printStackTrace();
			return "agent/reg";
		}
	}
	
	/**
	 * 删除代理，由于系统中有多重的强关系键，因此默认情况下我们使用冻结
	 * 而不是从物理上删除代理。
	 * @return
	 */
	@RequestMapping(value="/{id}/del",method=RequestMethod.GET)
	public String del(@PathVariable Long id){
		svc.freezen(id);
		return "agent/list";
	}
	
	/**
	 * 对代理的修改功能
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String show(@PathVariable Long id ,Model model){
		model.addAttribute((Agent)svc.getOne(id));
		return "agent/update";		
	}
	@RequestMapping(value="/{id}/update",method = RequestMethod.GET)
	public String update(@PathVariable Long id,Model model){
		model.addAttribute((Agent)svc.getOne(id));
		return "agent/update";
	}
	
	/**
	 * 分页列出所有的代理
	 * @return
	 */
	@RequestMapping(value="/{page}/list",method=RequestMethod.GET)
	public List<Agent> list(@PathVariable int page){
		return null;
		
	}
	
	
}
