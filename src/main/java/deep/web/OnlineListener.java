package deep.web;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import deep.zero.bean.Player;
import deep.zero.repo.PlayerRepo;
import deep.zero.svc.PlayerSvc;
import deep.zero.svc.PlayerSvcImpl;

public class OnlineListener extends HttpServlet implements HttpSessionListener,
		HttpSessionAttributeListener {
	/**
	 * 
	 */
	private PlayerSvcImpl playerSvc = new PlayerSvcImpl();
	private static final long serialVersionUID = -724585474693809304L;
	public static Map<HttpSession, String> map = new HashMap<HttpSession, String>();
	private String user_name;
	public static Map<String,HttpSession> sMap = new HashMap<String,HttpSession>();
	public Map<String, Player> mapx = new HashMap<String, Player>();

	public static int getOnlineGuest() {
		int OnlineGuest = 0;
		for (Iterator<HttpSession> it = map.keySet().iterator(); it.hasNext();) {// entrySet()
			Object key = it.next();
			if (null != map.get(key)) {
				OnlineGuest++; 
			}
		}
		return OnlineGuest;
	}

	public Map<String, Player> getOnlinePlayer() {	
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();		
		PlayerSvcImpl ps = (PlayerSvcImpl)wac.getBean("playerSvcImpl");
		for (Iterator<HttpSession> it = map.keySet().iterator(); it.hasNext();) {// entrySet()
			Object key = it.next();
			if (null != map.get(key) && !"".equals(map.get(key))) {
				System.out.println(map.get(key));
				Player player = ps.getByAccount("player");
				mapx.put(map.get(key), player);
			}
		}
		return mapx;
	}

	public void attributeAdded(HttpSessionBindingEvent evt) {
		// TODO Auto-generated method stub
		HttpSession session = evt.getSession();		
		user_name = (String) session.getAttribute("p_name");
		System.out.println("创建session"+user_name+session.getId());
		map.put(session, user_name);
		System.out.println(map.size());
		if(evt.getSession() != null && evt.getSession().getAttribute("p_name") != null){	
			System.out.println(evt.getSession().getAttribute("p_name"));
			sMap.put((String)evt.getSession().getAttribute("p_name"), session);
		}
	}

	public void attributeRemoved(HttpSessionBindingEvent evt) {
		// TODO Auto-generated method stub
	}

	public void attributeReplaced(HttpSessionBindingEvent evt) {
		// TODO Auto-generated method stub
		HttpSession session = evt.getSession();
		user_name = (String) session.getAttribute("p_name");
		System.out.println("+++++++++"+user_name+"++++++++");
		if (user_name == null) {
			map.remove(session);
		} else
			map.put(session, user_name);
		System.out.println(map.size()+user_name);
	}
	//将所有session放入map
	public void sessionCreated(HttpSessionEvent e) {
		
	}
	//
	public void sessionDestroyed(HttpSessionEvent e) {
	}
	//通过nickname得到session
	public static HttpSession getSession(String nickname){
		return sMap.get(nickname);
	}
}
