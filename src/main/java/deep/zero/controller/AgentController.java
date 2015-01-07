package deep.zero.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	/**
	 * 代理注册功能，主要用作代理在系统中的注册的实现，此部分要求对输入的相关数据
	 * 进行服务器端验证，其验证的内容包括：账号，密码，验证码三个部分，其它部分在
	 * 前端进行验证。
	 * @param agent
	 * @param model
	 * @param br
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public String reg(@ModelAttribute Agent agent, Model model,BindingResult br,HttpServletRequest req,String vcode){
		try{
			ValidationUtils.rejectIfEmptyOrWhitespace(br, "code", "code","账号不能为空");
			ValidationUtils.rejectIfEmptyOrWhitespace(br, "password", "password", "密码不能为空");
			//validate the vcode from request param.
			if(vcode == null || vcode.trim().length()!=4)
			{
				br.addAllErrors(null);
			}
				
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
	 * 使用Ajax来进行代理的注册功能，主要解决有些静态页面调用的问题。
	 * 当前使用的就是这个方法.
	 * @param code			用户的登录名
	 * @param password		用户的登录密码
	 * @param name			用户的名字
	 * @param phone			用户的电话
	 * @param mail			用户的电子邮件
	 * @param vcode			验证码
	 * @return
	 */
	@SuppressWarnings("null")
	@RequestMapping(value="/signup.ajax",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, List<String>> reg(@RequestParam String code,@RequestParam String password,
			@RequestParam String name,@RequestParam String phone,@RequestParam String mail,@RequestParam String vcode){
		Map<String,List<String>> rtn = new HashMap<String,List<String>>();
		ArrayList<String> lst = new ArrayList<String>();
		// 此部分的验证可以在前端使用java script来完成
		if(code==null || code.trim().length()==0)
			lst.add("账号不能为空");
		if(password==null || password.trim().length()==0)
			lst.add("密码不能为空");
		if(name==null || name.trim().length()==0)
			lst.add("账号不能为空");
		if(phone==null || phone.trim().length()==0)
			lst.add("电话不能为空");
		if(mail==null || mail.trim().length()==0)
			lst.add("电子邮件不能为空");
		if(vcode==null || vcode.trim().length()==0)
			lst.add("验证码不能为空");
		//validate if the code is registered.
		///ToDo

		if(lst.size()>0){
			rtn.put("Err", lst);
		}
		else
		{
			Agent agent = new Agent();
			agent.setCode(code);
			agent.setPassword(password);
			agent.setName(name);
			agent.setPhone(phone);
			agent.setEmail(mail);
			svc.save(agent);
			lst.add("注册成功，请联系客服快速开通账号");
			rtn.put("ok", lst);
		}
		return rtn;
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
