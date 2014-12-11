package zero.util;

public class Utils {
	public static String vPhone(String phone){
		int len = phone.length();
		return "*******"+phone.substring(len-4,len);
	}
	
	public static String vEmail(String email){
		int idx = email.indexOf("@");
		if(idx != -1){
			int len = email.length();
			return "*****"+email.substring(idx-1,len);
		}
		else
		{
			throw new IllegalArgumentException("email format is not acceptable.");
		}
		
	}
}
