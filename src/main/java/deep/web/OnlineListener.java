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
	private static Map map = new HashMap();
	private String user_name;

	public static int getOnlineGuest() {
		int OnlineGuest = 0;
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {// entrySet()
			Object key = it.next();
			if (map.get(key).equals("")) {
				OnlineGuest++;
			}
		}
		return OnlineGuest;
	}

	public static Map getOnlinePlayer() {
		Map mapx = new HashMap();
		for (Iterator it = map.keySet().iterator(); it.hasNext();) {// entrySet()
			Object key = it.next();
			if (!map.get(key).equals("") && !map.get(key).equals(",")) {
				mapx.put(map.get(key), map.get(key));
			}
		}
		return mapx;
	}

	public void attributeAdded(HttpSessionBindingEvent evt) {
		// TODO Auto-generated method stub
		HttpSession session = evt.getSession();
		user_name = (String) session.getAttribute("p_name");
		map.put(session, user_name);

	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
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

	}

	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
