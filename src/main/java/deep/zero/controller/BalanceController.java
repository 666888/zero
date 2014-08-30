package deep.zero.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import deep.zero.bean.Balance;
import deep.zero.bean.Player;
import deep.zero.svc.BalanceSvcImpl;
import deep.zero.svc.PlayerSvc;

@Controller
@RequestMapping("/player")
public class BalanceController {
	@Autowired
	BalanceSvcImpl balanceSvcImpl;
	@Autowired
	private PlayerSvc playerSvc;
	
	/**
	 * URL to addBalance.jsp
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addBalance",method=RequestMethod.GET)
	public String addBalance(Model model){
		Balance balance = new Balance();
		model.addAttribute("balance", balance);
		return "player/addBalance";
	}
	@RequestMapping(value="/addBalance",method=RequestMethod.POST)
	public String addBalance(@ModelAttribute Balance balance,
			Model model,BindingResult br,HttpServletRequest req, HttpServletResponse res){
		Balance balanceNew=null;
		String nickname=(String)req.getSession().getAttribute("p_name");
		Player player=playerSvc.getByAccount(nickname);
		Balance balanceOld=balanceSvcImpl.findLastBalance(player.getId());
		if (null==balanceOld) {
			balance.setPlayerId(player.getId());
			balance.setBalance(balance.getAmount());
			balanceSvcImpl.addBalance(balance);
		}else{
			 balanceNew=new Balance();
//			Balance balanceT=balanceSvcImpl.get(balance.getId());
			balanceNew.setAmount(balance.getAmount());
			balanceNew.setPlayerId(player.getId());
			balanceNew.setOpp(balance.getOpp());
			balanceNew.setRemark(balance.getRemark());
			balanceNew.setTransferTime(new Date());
			if (balance.getIo()) {
				balanceNew.setBalance(balanceOld.getBalance().add(balance.getAmount()));
			}else{
				balanceNew.setBalance(balanceOld.getBalance().subtract(balance.getAmount()));
			}
			balanceNew.setIo(balance.getIo());
			balanceSvcImpl.addBalance(balanceNew);
		}
		Balance balanceTmp=new Balance();
		balanceNew=balanceSvcImpl.findLastBalance(player.getId());
		balanceTmp.setBalance(balanceNew.getBalance());
		List<Balance> balances=balanceSvcImpl.getAll();
		model.addAttribute("balances", balances);
		model.addAttribute("balance", balanceTmp);
		return "player/addBalance";
	}
}
