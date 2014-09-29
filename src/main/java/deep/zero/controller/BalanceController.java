package deep.zero.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
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

import deep.tool.Constants;
import deep.tool.DateUtils;
import deep.zero.bean.Account;
import deep.zero.bean.Balance;
import deep.zero.bean.Player;
import deep.zero.svc.AccountSvc;
import deep.zero.svc.BalanceSvc;
import deep.zero.svc.PlayerSvcImpl;

@Controller
@RequestMapping("/p")
public class BalanceController {
	@Autowired
	private BalanceSvc balanceSvc;
	@Autowired
	private PlayerSvcImpl playerSvc;
	@Autowired
	private AccountSvc accountSvc;
	/**
	 * 从银行往账户充值
	 * URL to account.jsp
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addAccount",method=RequestMethod.GET)
	public String addAccount(Model model,HttpServletRequest req){
		Balance balance = new Balance();
		model.addAttribute("balance", balance);
		model.addAttribute("pName", (String)req.getSession().getAttribute("p_name"));
		System.out.println((String)req.getSession().getAttribute("p_name"));
		return "player/addBalance";
	}
	@RequestMapping(value="/addAccount",method=RequestMethod.POST)
	public String addAccount(@ModelAttribute Balance balance,
			Model model,BindingResult br,HttpServletRequest req, HttpServletResponse res){
		String nickname=(String)req.getSession().getAttribute("p_name");
		
		String accountId=null;
		Player player=playerSvc.getByAccount(nickname);
		Account account = accountSvc.getAccountByPlayerIdAndName(player.getId(), -1L);
		BigDecimal balanceOld=balanceSvc.ALLAcount(player.getId(),account.getId());
		Balance balanceNew=new Balance(); 
		balanceNew.setRecharge(balance.getRecharge());
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
		model.addAttribute("acc", "充值成功！");
		model.addAttribute("pName", nickname);
		return "player/addBalance";
	}
	/**
	 * 卡向游戏账户或是游戏账户向游戏账户转账
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
		String gAccount=(String)req.getSession().getAttribute("g_account");
//		Balance toBalance=balanceSvc.freeAccount(player.getId());
		Balance toBalance=new Balance();
		Balance fromBalance=new Balance();
		fromBalance.setAccId(balance.getAccId());
		fromBalance.setRolloff(balance.getRolloff());
		fromBalance.setPlayerId(player.getId());
		fromBalance.setRemark(balance.getRemark());
		fromBalance.setTransferTime(new Date());
		fromBalance.setTransType(Constants.transType[4]);
		//转出
		toBalance.setAccId(Long.valueOf(gAccount));
		toBalance.setRecharge(balance.getRecharge());
		toBalance.setPlayerId(player.getId());
		toBalance.setRemark(balance.getRemark());
		toBalance.setTransferTime(new Date());
		toBalance.setTransType(Constants.transType[1]);
		balanceSvc.add(fromBalance, toBalance);
		model.addAttribute("balance", null);
		return "player/addBalance";
	}
	
/**
	 * 从主账户提钱到卡上
	 * URL to account.jsp
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/withDraw",method=RequestMethod.GET)
	public String withDraw(Model model){
		Balance balance = new Balance();
		model.addAttribute("balance", balance);
		return "player/withDraw";
	}
	@RequestMapping(value="/withDraw",method=RequestMethod.POST)
	public String withDraw(@ModelAttribute Balance balance,
			Model model,BindingResult br,HttpServletRequest req, HttpServletResponse res){
		String nickname=(String)req.getSession().getAttribute("p_name");
		String accountId=null;
		Player player=playerSvc.getByAccount(nickname);
		Account account = accountSvc.getAccountByPlayerIdAndName(player.getId(), -1L);
		BigDecimal balanceOld=balanceSvc.ALLAcount(player.getId(),account.getId());
//		Balance balanceNew=new Balance();
		
		balance.setPlayerId(player.getId());
		balance.setAccId(account.getId());
		balance.setTransferTime(new Date());
		balance.setTransType(Constants.transType[2]);
		balanceSvc.AccountToBank(balance,accountId);
		return "player/withDraw";
	}
	/*
	@RequestMapping(value="rechangeHistory",method=RequestMethod.GET)
	public String rechangeHistory(Model model){
		Balance balance = new Balance();
		model.addAttribute("balance", balance);
		return "player/withDraw";
	}*/
	@RequestMapping(value="/rechargeHistory",method=RequestMethod.GET)
	public String rechangeHistory(@ModelAttribute Balance balance,
			Model model,BindingResult br,HttpServletRequest req, HttpServletResponse res){
		String nickname=(String)req.getSession().getAttribute("p_name");
		String accountId=null;
		Player player=playerSvc.getByAccount(nickname);
		Account account = accountSvc.getAccountByPlayerIdAndName(player.getId(), -1L);
		BigDecimal balanceOld=balanceSvc.ALLAcount(player.getId(),account.getId());
		BigDecimal allAccount = balanceSvc.ALLAcount(player.getId(),account.getId());
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
