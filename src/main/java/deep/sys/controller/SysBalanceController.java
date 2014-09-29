package deep.sys.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import deep.tool.Constants;
import deep.tool.DateUtils;
import deep.zero.bean.Account;
import deep.zero.bean.Balance;
import deep.zero.bean.Player;
import deep.zero.svc.AccountSvc;
import deep.zero.svc.BalanceSvc;
import deep.zero.svc.PlayerSvcImpl;

@Controller
@RequestMapping("/gm")
public class SysBalanceController {

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
	@RequestMapping(value="/accountSearch",method=RequestMethod.GET)
	public String accountSearch(){
		return "user/accountSearch";
	}
	@RequestMapping(value="/rechargeHistory",method=RequestMethod.POST)
	public String rechangeHistory(
			Model model,HttpServletRequest req,@RequestParam("nickname") String nickname, HttpServletResponse res){
		Player player=playerSvc.getByAccount(nickname);
		Account account = accountSvc.getAccountByPlayerIdAndName(player.getId(), -1L);
		BigDecimal allAccount = balanceSvc.ALLAcount(player.getId(),account.getId());
 //		Balance balanceNew=new Balance();
		
//		balance.setPlayerId(player.getId());
//		balance.setAccId(account.getId());
//		balance.setTransferTime(new Date());
//		balance.setTransType(Constants.transType[2]);
		List<Balance> balanceList=balanceSvc.findFreeBalanceByPlayerId(account.getId(),DateUtils.weekStartTime1(),DateUtils.weekEndTime1());
		model.addAttribute("balanceList", balanceList);
		model.addAttribute("allAccount", allAccount);
		return "user/rechangeView";
	}
	
	/**
	 * 后台玩家账户充值查询
	 * @param balance
	 * @param model
	 * @param br
	 * @param req
	 * @param nickname
	 * @param res
	 * @return
	 */
	@RequestMapping(value="/rechargeSearch",method=RequestMethod.GET)
	public String rechargeSearch(){
		return "user/accountSearch";
	}
	@RequestMapping(value="/rechargeSearch.ajax",method=RequestMethod.POST)
	@ResponseBody
	public Map rechargeSearch(HttpServletRequest req,@RequestParam("nickname") String nickname, HttpServletResponse res){
		Map map=new HashMap<String, Object>();
		Player player=playerSvc.getByAccount(nickname);
		Account account = accountSvc.getAccountByPlayerIdAndName(player.getId(), -1L);
		BigDecimal allAccount = balanceSvc.ALLAcount(player.getId(),account.getId());
 //		Balance balanceNew=new Balance();
		
//		balance.setPlayerId(player.getId());
//		balance.setAccId(account.getId());
//		balance.setTransferTime(new Date());
//		balance.setTransType(Constants.transType[2]);
//		List<Balance> balanceList=balanceSvc.findFreeBalanceByPlayerId(account.getId(),DateUtils.weekStartTime1(),DateUtils.weekEndTime1());
//		model.addAttribute("player", player);
//		model.addAttribute("allAccount", allAccount);
		map.put("e", true);
		map.put("player", player);
		map.put("allAccount", allAccount);
		return map;
	}
//	充值
	@RequestMapping(value="/accountRecharge.ajax",method=RequestMethod.POST)
	@ResponseBody
	public Map accountRecharge(HttpServletRequest req,@RequestParam("nickname") String nickname,@RequestParam("recharge") String recharge, HttpServletResponse res){
		String accountId=null;
		Map map=new HashMap<String, Object>();
		Player player=playerSvc.getByAccount(nickname);
		Account account = accountSvc.getAccountByPlayerIdAndName(player.getId(), -1L);
//		BigDecimal balanceOld=balanceSvc.ALLAcount(player.getId(),account.getId());
		Balance balanceNew=new Balance(); 
		balanceNew.setRecharge(new BigDecimal(recharge));
		//balanceNew.setRolloff(balance.getRecharge());
		balanceNew.setPlayerId(player.getId());
		balanceNew.setAccId(account.getId());
		balanceNew.setTransferTime(new Date());
		balanceNew.setTransType(Constants.transType[0]);
		balanceSvc.BankToAccount(balanceNew,accountId);
		System.out.println(balanceSvc.ALLAcount(player.getId(),account.getId()));
//		List<Balance> list = balanceSvc.findAll();
//		for (Balance b : list) {
//			System.out.println(b.getRecharge());
//		}
		///Iterator it = list.iterator();
		//while(it.hasNext())
//		model.addAttribute("acc", "充值成功！");
//		model.addAttribute("pName", nickname);
		map.put("e", true);
		map.put("msg", "充值成功！");
		return map;
	}
	
}
