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

public class OnlineListener extends HttpServlet implements HttpSessionListener,
		HttpSessionAttributeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -724585474693809304L;
	private static Map<HttpSession, String> map = new HashMap<HttpSession, String>();
	private String user_name;
	public static Map<String,HttpSession> sMap = new HashMap<String,HttpSession>();

	public static int getOnlineGuest() {
		int OnlineGuest = 0;
		for (Iterator<HttpSession> it = map.keySet().iterator(); it.hasNext();) {// entrySet()
			Object key = it.next();
			if (map.get(key).equals("")) {
				OnlineGuest++; 
			}
		}
		return OnlineGuest;
	}

	public static Map<String, String> getOnlinePlayer() {
		Map<String, String> mapx = new HashMap<String, String>();
		for (Iterator<HttpSession> it = map.keySet().iterator(); it.hasNext();) {// entrySet()
			Object key = it.next();
			if (!map.get(key).equals("") && !map.get(key).equals(null)) {
				System.out.println(map.get(key));
				mapx.put(map.get(key), map.get(key)); 
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

	public void sessionCreated(HttpSessionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSession() != null){
			sMap.put(e.getSession().getId(), e.getSession());
		}
	}

	public void sessionDestroyed(HttpSessionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSession() != null){
			sMap.remove(e.getSession().getId());
		}
	}
}
