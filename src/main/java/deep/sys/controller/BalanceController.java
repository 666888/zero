package deep.sys.controller;

import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.RequestParam;

import deep.tool.DateUtils;
import deep.zero.bean.Account;
import deep.zero.bean.Balance;
import deep.zero.bean.Player;
import deep.zero.svc.AccountSvc;
import deep.zero.svc.BalanceSvc;
import deep.zero.svc.PlayerSvcImpl;

@Controller
@RequestMapping("/gm")
public class BalanceController {

	@Autowired
	private BalanceSvc balanceSvc;
	@Autowired
	private PlayerSvcImpl playerSvc;
	@Autowired
	private AccountSvc accountSvc;
	
	/**
	 * 后台查询玩家账户
	 * @param balance
	 * @param model
	 * @param br
	 * @param req
	 * @param nickname
	 * @param res
	 * @return
	 */
	@RequestMapping(value="/rechargeHistory",method=RequestMethod.GET)
	public String rechangeHistory(@ModelAttribute Balance balance,
			Model model,BindingResult br,HttpServletRequest req,@RequestParam("nickname") String nickname, HttpServletResponse res){
		Player player=playerSvc.getByAccount(nickname);
		Account account = accountSvc.getAccountByPlayerIdAndName(player.getId(), -1L);
		BigDecimal allAccount = balanceSvc.ALLAcount(player.getId());
 //		Balance balanceNew=new Balance();
		
//		balance.setPlayerId(player.getId());
//		balance.setAccId(account.getId());
//		balance.setTransferTime(new Date());
//		balance.setTransType(Constants.transType[2]);
		List<Balance> balanceList=balanceSvc.findFreeBalanceByPlayerId(account.getId(),DateUtils.weekStartTime1(),DateUtils.weekEndTime1());
		model.addAttribute("balanceList", balanceList);
		model.addAttribute("pName", nickname);
		model.addAttribute("allAccount", allAccount);
		return "player/rechangeView";
	}
	
	
}
