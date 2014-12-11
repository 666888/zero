package deep.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {

	@RequestMapping(value="/jtc",method=RequestMethod.GET,params="type=json")
	@ResponseBody
	public ModelMap testJson(){
		ModelMap md = new ModelMap();
		md.addAttribute("name", "李奎");
		md.addAttribute("password", 123456);
		md.addAttribute("really", true);
		return md;
	}
	
}
