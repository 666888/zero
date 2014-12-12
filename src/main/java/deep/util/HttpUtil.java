package deep.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 一般的web程序，都是经过nginx或apache多级转发后才到Web容器中，真实的IP有可能被拦截到外层
 * 服务，此时我们取得最终用户的ip会出现错误。
 * 在多层代理或者转发情况下是X-Forwarded-For (XFF)是如何产生的呢？
 * XFF 在最外面的一层(一般是CDN加速)使用$remote_addr取得真实的用户ip,在向上游发送时会
 * 将这个ip后面附上自己的ip，然后转发，上游的服务器会得到如下形式的XFF:
 * ip, srvip 注意：前一个ip是用户真实ip，后一个是CDN的ip,两者中间是一个逗号和一个空格
 * 一般来说，每一层转发都在原XFF上附加上一个 逗号和一个空格，再加上自己的ip，然后发送给上游Server
 * 有时CDN服务商为了自己的安全考虑，不会将自己的ip加入到XFF而是直接发送给上游。
 * 
 * @author dozray
 *
 */
public final class HttpUtil {
	private HttpUtil() {
	};

	public static String getIPAddr(HttpServletRequest req) {
		String ips = req.getHeader("x-forwarded-for");
		String ip = null;
		if (ips == null || ips.length() == 0 || "unknown".equalsIgnoreCase(ips)) {
			ips = req.getHeader("Proxy-Client-IP");
		} 
		else{
			ip = ips.split(",")[0];
		}
		
		if(ips == null || ips.length() ==0 || "unknown".equalsIgnoreCase(ips) ){
			ip = req.getHeader("WL-Proxy-Client-IP");
		}
		if(ips == null || ips.length() == 0 || "unknown".equalsIgnoreCase(ips)){
			ip = req.getRemoteAddr();
		}
	
		if(ips == null || ips.length() == 0 || "unknown".equalsIgnoreCase(ips)){
			ip = req.getHeader("HTTP_CLIENT_IP");
		}
	
		if(ips == null || ips.length() == 0 || "unknown".equalsIgnoreCase(ips)){
			ip = req.getRemoteAddr();
		}
		return ip ;
	}
}
