package deep.tool;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DateUtils
{
  private static final Logger log=LoggerFactory.getLogger(DateUtils.class);

  private static String[] dateFormat = { "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss", "yyyy年MM月dd日HH时mm分ss秒", "yyyy-MM-dd", "yyyy/MM/dd", "yy-MM-dd", "yy/MM/dd", "yyyy年MM月dd日", "HH:mm:ss", "yyyyMMddHHmmss", "yyyyMMdd", "yyyy.MM.dd", "yy.MM.dd" ,"MMyyHHmdd","MMddHHmmss"};

  public static Timestamp convUtilCalendarToSqlTimestamp(Calendar date)
  {
    if (date == null) {
      return null;
    }
    return new Timestamp(date.getTimeInMillis());
  }

  public static Calendar convSqlTimestampToUtilCalendar(Timestamp date)
  {
    if (date == null) {
      return null;
    }
    GregorianCalendar gc = new GregorianCalendar();
    gc.setTimeInMillis(date.getTime());
    return gc;
  }

  public static Calendar parseDate(String dateStr)
  {
    if ((dateStr == null) || (dateStr.trim().length() == 0)) {
      return null;
    }
    Date result = parseDate(dateStr, 0);
    Calendar cal = Calendar.getInstance();
    cal.setTime(result);

    return cal;
  }

  public static String toDateTimeStr(Calendar date)
  {
    if (date == null)
      return null;
    return new SimpleDateFormat(dateFormat[0]).format(date.getTime());
  }

  public static String toDateTimeStr(int format, Calendar date)
  {
    if (date == null)
      return null;
    return new SimpleDateFormat(dateFormat[format]).format(date.getTime());
  }

  public static String toDateStr(Calendar date,int formatindex)
  {
    if (date == null)
      return null;
    return new SimpleDateFormat(dateFormat[formatindex]).format(date.getTime());
  }

  public static String toDateStrByFormatIndex(Calendar date, int formatIndex) {
    if (date == null)
      return null;
    return new SimpleDateFormat(dateFormat[formatIndex]).format(date.getTime());
  }

  public static int calendarMinus(Calendar d1, Calendar d2) {
    if ((d1 == null) || (d2 == null)) {
      return 0;
    }

    d1.set(11, 0);
    d1.set(12, 0);
    d1.set(13, 0);

    d2.set(11, 0);
    d2.set(12, 0);
    d2.set(13, 0);

    long t1 = d1.getTimeInMillis();
    long t2 = d2.getTimeInMillis();
    log.debug("DateUtils: d1 = " + toDateTimeStr(d1) + "(" + t1 + ")");

    log.debug("DateUtils: d2 = " + toDateTimeStr(d2) + "(" + t2 + ")");

    long daylong = 86400000L;
    t1 -= t1 % daylong;
    t2 -= t2 % daylong;

    long t = t1 - t2;
    int value = (int)(t / daylong);

    log.debug("DateUtils: d2 -d1 = " + value + " （天）");

    return value;
  }

  public static long calendarminus(Calendar d1, Calendar d2)
  {
    if ((d1 == null) || (d2 == null)) {
      return 0L;
    }
    return (d1.getTimeInMillis() - d2.getTimeInMillis()) / 86400000L;
  }

  public static Date parseDate(String dateStr, int index)
  {
    DateFormat df = null;
    try {
      df = new SimpleDateFormat(dateFormat[index]);

      return df.parse(dateStr);
    } catch (ParseException pe) {
      return parseDate(dateStr, index + 1); } catch (ArrayIndexOutOfBoundsException aioe) {
    }
    return null;
  }

  public static Date StringToDate(String dateStr)
  {
    if ((dateStr == null) || (dateStr.trim().length() == 0)) {
      return null;
    }
    return parseDate(dateStr, 3);
  }

  public static String dateToString(Date date, int index)
  {
    if (date == null) {
      return null;
    }
    return new SimpleDateFormat(dateFormat[index]).format(date);
  }

  public static String dateToString(Date date)
  {
    if (date == null) {
      return null;
    }
    return new SimpleDateFormat(dateFormat[3]).format(date);
  }

  public static Timestamp convUtilDateToSqlTimestamp(Date date)
  {
    if (date == null) {
      return null;
    }
    return new Timestamp(date.getTime());
  }
  public static Calendar convUtilDateToUtilCalendar(Date date) {
    if (date == null) {
      return null;
    }
    GregorianCalendar gc = new GregorianCalendar();
    gc.setTimeInMillis(date.getTime());
    return gc;
  }

  public static Timestamp parseTimestamp(String dateStr, int index)
  {
    DateFormat df = null;
    try {
      df = new SimpleDateFormat(dateFormat[index]);

      return new Timestamp(df.parse(dateStr).getTime());
    } catch (ParseException pe) {
      return new Timestamp(parseDate(dateStr, index + 1).getTime()); } catch (ArrayIndexOutOfBoundsException aioe) {
    }
    return null;
  }

  public static Timestamp parseTimestamp(String dateStr)
  {
    DateFormat df = null;
    try {
      df = new SimpleDateFormat(dateFormat[3]);
      return new Timestamp(df.parse(dateStr).getTime());
    } catch (ParseException pe) {
      return null; } catch (ArrayIndexOutOfBoundsException aioe) {
    }
    return null;
  }
  /**
   * 
   * @param dateStr
   * @return
   */
  public static Timestamp toTimestampdateFormat0(String dateStr)
  {
    DateFormat df = null;
    try {
      df = new SimpleDateFormat(dateFormat[0]);
      return new Timestamp(df.parse(dateStr).getTime());
    } catch (ParseException pe) {
    	
      return null; 
      
    
     } catch (ArrayIndexOutOfBoundsException aioe) {
    }
    return null;
  }
  
  /**
   * 根据formatIndex 返回
   * @param dateStr
   * @param formatIndex
   * @return
   */
  public static Timestamp toTimestampdateByformatIndex(String dateStr,int formatIndex)
  {
    DateFormat df = null;
    try {
      df = new SimpleDateFormat(dateFormat[formatIndex]);
      return new Timestamp(df.parse(dateStr).getTime());
    } catch (ParseException pe) {
    	
      return null; 
      
    
     } catch (ArrayIndexOutOfBoundsException aioe) {
    }
    return null;
  } 

  /**
   * 得到当前日期
   * @param a 为0为当前时间 相差a天
   * @param formatIndex 格式
   * @return
   */
  public static String getNowDate(int a,int formatIndex) {
		 Date date = new Date();
		 DateFormat   df = null;
		 Calendar c = Calendar.getInstance(); 
		  c.setTime(date); 
		  int day=c.get(Calendar.DATE); 
		  c.set(Calendar.DATE,day+a); 
		  df = new SimpleDateFormat(dateFormat[formatIndex]); 
		 // Calendar.
		return df.format(c.getTime()) ;
	}
  
  
  
  public static Timestamp parseTimestampYYMMDDHHMMSS(String dateStr)
  {
    DateFormat df = null;
    try {
      df = new SimpleDateFormat(dateFormat[9]);
      return new Timestamp(df.parse(dateStr).getTime());
    } catch (ParseException pe) {
      return null; } catch (ArrayIndexOutOfBoundsException aioe) {
    }
    return null;
  } 
  
  
  public static Timestamp parseTimestamp(Calendar calendar)
  {
    return new Timestamp(calendar.getTimeInMillis());
  }

  public static int calcMonthDays(Calendar date) {
    Calendar t1 = (Calendar)date.clone();
    Calendar t2 = (Calendar)date.clone();
    int year = date.get(1);
    int month = date.get(2);
    t1.set(year, month, 1);
    t2.set(year, month + 1, 1);
    t2.add(6, -1);
    return calendarMinus(t2, t1) + 1;
  }
  /**
   * 取指定日期的相差 a天数的日期
   * @param date
   * @param a
   * @return
   */
  public static Date getBeforOrNextDay(Date date,int a){
	  if(date==null){
		  return  null; 
	  }else{
		  Calendar c = Calendar.getInstance(); 
		  c.setTime(date); 
		  int day=c.get(Calendar.DATE); 
		  c.set(Calendar.DATE,day+a); 
		//  SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		//  System.out.println("取得的日期是:---->>>>>"+df.format(c.getTime()));

	      return c.getTime();
	  }
	 
  }
  /**
   * 取指定日期所在月的最后一天
   * @param strdate
   * @return
   */
  public static String  getMonthLastDay(String  strdate)  
  {  
          Date date  =  StringToDate(getMonthFirstDay(strdate));  
          Calendar  calendar  =  Calendar.getInstance();  
          calendar.setTime(date);  
          calendar.add(Calendar.MONTH,1);  
          calendar.add(Calendar.DAY_OF_YEAR,  -1); 

          return  formatDateByFormat(calendar.getTime(),"yyyy-MM-dd");  
  }  
  /**
   * 取指定日期所在月的第一天
   * @param strdate
   * @return
   */
  public static String  getMonthFirstDay(String  strdate)  
  {  
          java.util.Date  date  = StringToDate((strdate));  
        
          return  formatDateByFormat(date,"yyyy-MM")  +  "-01";  
  }  

  public static String  formatDateByFormat(Date  date,String  format)  
  {  
          String  result  =  "";  
          if(date  !=  null)  
          {  
                  try  
                  {  
                          SimpleDateFormat  sdf  =  new  SimpleDateFormat(format);  
                          result  =  sdf.format(date);  
                  }  
                  catch(Exception  ex)  
                  {  
                         
                          ex.printStackTrace();  
                  }  
          }  
          return  result;  
  }
  //得到前 - addmoth月或者下+addmoth月的当前时间
  public static Date getLastMonOrNextMonTime(Date today,int addmoth){
	 
	  Calendar cal=Calendar.getInstance(); 
	  cal.setTime(today);
	  cal.add(Calendar.DATE, -1);    //得到前一天 
	  cal.add(Calendar.MONTH, addmoth);    //得到前一个月 
	  return cal.getTime();
  }
  //两个时间相差的天数
  public static int getDistanceDays(Date day1,Date day2){
	  Calendar cal=Calendar.getInstance(); 
	  cal.setTime(day1);
	  int num1=cal.get(Calendar.DATE); 
	  cal.setTime(day2);
	  int num2=cal.get(Calendar.DATE); 
	  return num1-num2;
  }
  
  public  static long getTimeInMillis(){
	  Calendar cal=Calendar.getInstance(); 
	  return cal.getTimeInMillis();
  }
  /**
   * 得到比date 多 或 少  a分钟的时间
   * @param a
   * @param formatIndex
   * @return
   */
  public static String getNextMinute(Date date,int a,int formatIndex){
	 // Date date = new Date();  
	  Calendar c = Calendar.getInstance();    
      c.setTime(date); 
      c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE)+a,c.get(Calendar.SECOND)) ;  
      DateFormat  df = new SimpleDateFormat(dateFormat[formatIndex]); 
		 // Calendar.
      return df.format(c.getTime()) ;
    
  }
/**
 * 本周开始
 * @return
 */
  public static String weekStartTime1(){
//	  Date weekStartTime=null;
	  DateFormat  df = new SimpleDateFormat(dateFormat[3]);
	  Calendar cal = Calendar.getInstance();
//	  try {
		  int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 2;
		  cal.add(Calendar.DATE, -day_of_week);
		  
//		  weekStartTime=df.parse(df.format(cal.getTime())+ " 23:59:59");
//	} catch (ParseException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	  return df.format(cal.getTime())+ " 0:00:00";
  }
  /**
   * 本周开始
   * @return
   */
    public static Date weekStartTime(){
  	  Calendar cal = Calendar.getInstance();
  	  int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 2;
  	  cal.add(Calendar.DATE, -day_of_week);
  	  return cal.getTime();
    }
  /**
   * 本周最后时间
   * @return
   */  
  public static String weekEndTime1(){
	  Calendar cal = Calendar.getInstance();
	  DateFormat  df = new SimpleDateFormat(dateFormat[3]);
		  int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 2;
		  cal.add(Calendar.DATE, -day_of_week);
		  cal.add(Calendar.DATE, 6);
	  
//		  weekEndTime=df.parse(df.format(cal.getTime())+ " 23:59:59");
	  return df.format(cal.getTime())+ " 23:59:59";
  }
  /**
   * 本周最后时间
   * @return
   */  
  public static Date weekEndTime(){
	  Calendar cal = Calendar.getInstance();
	  int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 2;
	  cal.add(Calendar.DATE, -day_of_week);
	  cal.add(Calendar.DATE, 6);
	  return cal.getTime();
  }
//  private final SimpleDateFormat shortSdf;
//  private final SimpleDateFormat longHourSdf;
//  private final SimpleDateFormat longSdf;
// 
//  public DateUtils(){
//      this.shortSdf = new SimpleDateFormat("yyyy-MM-dd");
//      this.longHourSdf = new SimpleDateFormat("yyyy-MM-dd HH");
//      this.longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//  } 
	public static  Date getCurrentMonthStartTime() {
      Calendar c = Calendar.getInstance();
      Date now = null;
      DateFormat  df = new SimpleDateFormat(dateFormat[3]);
      try {
    	  
          c.set(Calendar.DATE, 1);
          now=c.getTime();
//          now = shortSdf.parse(shortSdf.format(c.getTime())+"0:00:00");
          	now=df.parse(df.format(now)+" 0:00:00");
      } catch (Exception e) {
          e.printStackTrace();
      }
      return now;
  }

  /**
   * 当前月的结束时间，即2012-01-31 23:59:59
   *
   * @return
   */
  public  static Date getCurrentMonthEndTime() {
      Calendar c = Calendar.getInstance();
      Date now = null;
      DateFormat  df = new SimpleDateFormat(dateFormat[3]);
      try {
          c.set(Calendar.DATE, 1);
          c.add(Calendar.MONTH, 1);
          c.add(Calendar.DATE, -1);
//          now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
          now=df.parse(df.format(c.getTime())+" 23:59:59");
      } catch (Exception e) {
          e.printStackTrace();
      }
      return now;
  } 
  
  public static void main(String[] args)  {
		//sendMail("120601174@qq.com", "120601174@qq.com,xtp1211@163.com", "测试邮件", "这是一封测试的邮件");
//		 Calendar cal=Calendar.getInstance(); 
//		 System.out.println(getNowDate(0, 14));
	  System.out.println(weekStartTime());
	  Calendar c = Calendar.getInstance();
      Date now = null;
      try {
//          c.set(Calendar.DATE, 1);
//          c.add(Calendar.MONTH, 1);
//          c.add(Calendar.DATE, -1);
//          now=c.getTime();
////          now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
//          DateFormat  df = new SimpleDateFormat(dateFormat[3]); 
//          System.out.println("月"+now);
//          System.out.println("月"+df.format(now)+" 0:00:00");
    	  DateFormat  df = new SimpleDateFormat(dateFormat[3]);
//    	  System.out.println("本周开始时间："+df.format(DateUtils.weekStartTime())+" 0:00:00");
//    	  System.out.println("本周结束时间："+df.format(DateUtils.weekEndTime())+ " 23:59:59");
      } catch (Exception e) {
          e.printStackTrace();
      }
	  
	}
  
  public  static Date getCurrentQuarterStartTime() {
      Calendar c = Calendar.getInstance();
      int currentMonth = c.get(Calendar.MONTH) + 1;
      Date now = null;
      DateFormat  df = new SimpleDateFormat(dateFormat[3]); 
      try {
          if (currentMonth >= 1 && currentMonth <= 3)
              c.set(Calendar.MONTH, 0);
          else if (currentMonth >= 4 && currentMonth <= 6)
              c.set(Calendar.MONTH, 3);
          else if (currentMonth >= 7 && currentMonth <= 9)
              c.set(Calendar.MONTH, 4);
          else if (currentMonth >= 10 && currentMonth <= 12)
              c.set(Calendar.MONTH, 9);
          c.set(Calendar.DATE, 1);
//          now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
          now=df.parse(df.format(c.getTime()) + " 00:00:00");
      } catch (Exception e) {
          e.printStackTrace();
      }
      return now;
  }

  /**
   * 当前季度的结束时间，即2012-03-31 23:59:59
   *
   * @return
   */
  public static  Date getCurrentQuarterEndTime() {
      Calendar c = Calendar.getInstance();
      int currentMonth = c.get(Calendar.MONTH) + 1;
      Date now = null;
      DateFormat  df = new SimpleDateFormat(dateFormat[3]); 
      try {
          if (currentMonth >= 1 && currentMonth <= 3) {
              c.set(Calendar.MONTH, 2);
              c.set(Calendar.DATE, 31);
          } else if (currentMonth >= 4 && currentMonth <= 6) {
              c.set(Calendar.MONTH, 5);
              c.set(Calendar.DATE, 30);
          } else if (currentMonth >= 7 && currentMonth <= 9) {
              c.set(Calendar.MONTH,8);
              c.set(Calendar.DATE, 30);
          } else if (currentMonth >= 10 && currentMonth <= 12) {
              c.set(Calendar.MONTH, 11);
              c.set(Calendar.DATE, 31);
          }
//          now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
          now=df.parse(df.format(c.getTime()) + " 23:59:59");
      } catch (Exception e) {
          e.printStackTrace();
      }
      return now;
  } 
}