package com.mfh.yueru.yueru;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.Seconds;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * 时间工具类
 */
public class DateUtils {
  public static final String UNIX_FIRST_YEAR = "1970-01-01";

  public static final String YEAR = "yyyy";

  public static final String MONTH = "MM";

  public static final String WEEK = "EEEE";

  public static final String GET_DAY = "dd";

  public static final String DATE = "yyyy-MM-dd";

  public static final String DATE_DOT = "yyyy.MM.dd";

  public static final String DATE_NO_YEAR = "MM.dd";

  public static final String DAY = "yyyyMMdd";

  public static final String DAY2 = "yyyy/MM/dd";

  public static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";

  public static final String DATE_TIME_H_M = "yyyy-MM-dd HH:mm";

  public static final String TIME = "HH:mm:ss";

  public static final String TIME_H_M = "HH:mm";

  public static final String SEPARATE = "-";


  /**
   * 获取YYYY格式
   *
   * @return
   */
  public static String getYears() {
    return new DateTime().toString(YEAR);
  }

  /**
   * 获取YYYY格式
   *
   * @return 当前年份
   */
  public static Long getYear() {
    return Long.valueOf(new DateTime().toString(YEAR));
  }

  /**
   * 获取MM格式
   *
   * @return 当前月份
   */
  public static Long getMonth() {
    return Long.valueOf(new DateTime().toString(MONTH));
  }

  /**
   * 获取EEEE格式
   *
   * @return 当前天数星期几
   */
  public static String getWeeks() {
    return new DateTime().toString(WEEK);
  }

  public static int getWeek() {
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    int w = cal.get(Calendar.DAY_OF_WEEK) - 1 == 0 ? 7 : cal.get(Calendar.DAY_OF_WEEK) - 1;
    return w;
  }

  /**
   * 获取DD格式
   *
   * @return 当前几号
   */
  public static int getCDay() {
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    return cal.get(Calendar.DAY_OF_MONTH);
  }

  public static int getCDay(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    return cal.get(Calendar.DAY_OF_MONTH);
  }

  /**
   * 获得指定日期为星期几
   *
   * @param date 指定日期
   * @return 星期几
   */
  public static String getWeeks(Date date) {
    SimpleDateFormat dateFm = new SimpleDateFormat(WEEK);
    String currSun = dateFm.format(date);
    return currSun;
  }

  public static int getWeek(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    int w = cal.get(Calendar.DAY_OF_WEEK) - 1 == 0 ? 7 : cal.get(Calendar.DAY_OF_WEEK) - 1;
    return w;
  }

  /**
   * 获取给定时间下周周一日期时间为00:00:00
   *
   * @param date 给定时间
   * @return 时间
   */
  public static Date getNextWeekMonday(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(getThisWeekMonday(date));
    cal.add(Calendar.DATE, 7);
    // 时
    cal.set(Calendar.HOUR_OF_DAY, 0);
    // 分
    cal.set(Calendar.MINUTE, 0);
    // 秒
    cal.set(Calendar.SECOND, 0);
    // 毫秒
    cal.set(Calendar.MILLISECOND, 0);
    return cal.getTime();
  }

  public static Date getThisWeekMonday(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    // 获得当前日期是一个星期的第几天
    int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
    if (1 == dayWeek) {
      cal.add(Calendar.DAY_OF_MONTH, -1);
    }
    // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
    cal.setFirstDayOfWeek(Calendar.MONDAY);
    // 获得当前日期是一个星期的第几天
    int day = cal.get(Calendar.DAY_OF_WEEK);
    // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
    cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
    return cal.getTime();
  }

  /**
   * 返回指定日期有几周（判断条件为：WeeklyRestDaysService）
   *
   * @param year
   * @param month
   * @return
   */
  public static int getSeveralWeeks(Long year, Long month) {
    Date date = formatDate(year + "-" + month + "-01");
    //当月一号为周几
    int week = getWeek(date);
    //当月有几天
    int days = getDays(date);
    int returnWeeks = week <= 4 ? 1 : 0;
    int surplusDay = days - (7 - week + 1);//减去第一周天数
    returnWeeks += surplusDay / 7;//中间周数
    int i = surplusDay % 7;//最后一周剩余天数
    if (i >= 4) {
      returnWeeks++;
    }
    return returnWeeks;
  }

  /**
   * 判断指定年月的某一周是否为在当前时间
   *
   * @return
   */
  public static Boolean getSeveralWeeks(Long year, Long month, Long week) {
    return false;
  }

  /**
   * 获取YYYY-MM-DD格式
   *
   * @return
   */
  public static String getDay() {
    return new DateTime().toString(DATE);
  }

  /**
   * 获取YYYYMMDD格式
   *
   * @return
   */
  public static String getDays() {
    return new DateTime().toString(DAY);
  }

  /**
   * 根据指定时间获取YYYYMMDD格式
   *
   * @return
   */
  public static String getDaysByDate(Date date) {
    return new DateTime(date).toString(DAY);
  }

  /**
   * 根据指定时间获取YYYY/MM/DD格式
   */
  public static String getDaysByDate2(Date date) {
    return new DateTime(date).toString(DAY2);
  }

  /**
   * 获取DD格式
   *
   * @return 当前月份的天数
   */
  public static int getDays(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
  }

  /**
   * 获取HH:MM
   *
   * @return
   */
  public static String getHM() {
    return new DateTime().toString(TIME_H_M);
  }

  /**
   * 获取YYYY-MM-DD HH:mm:ss格式
   *
   * @return
   */
  public static String getTime() {
    return new DateTime().toString(DATE_TIME);
  }

  /**
   * @param s
   * @param e
   * @return boolean
   * @throws
   * @Title: lteCurrentTime
   * @Description: (日期比较 ， 如果s > = e 返回true 否则返回false)
   */
  public static boolean lteCurrentTime(String s, String e) {
    if (fomatDate(s) == null || fomatDate(e) == null) {
      return false;
    }
    return fomatDate(s).compareTo(fomatDate(e)) >= 0;
  }

  /**
   * 判断日期是否大于等于当前日期
   *
   * @param date
   * @return
   */
  public static boolean isDateGteNow(String date) {
//        Date dateTime = fomatDate(date).withTimeAtStartOfDay().toLocalDateTime().toDate();
    Date dateTime = formatStringToDate(date, DATE_TIME);
    Date nowDate = new DateTime().withTimeAtStartOfDay().toLocalDateTime().toDate();
    return dateTime.compareTo(nowDate) >= 0;
  }

  public static boolean isDateGteNow(Date date) {
    Date nowDate = new DateTime().withTimeAtStartOfDay().toLocalDateTime().toDate();
    return date.compareTo(nowDate) >= 0;
  }

  /**
   * 1 前者大于后者
   * 0 前者等于后者
   * -1 前者小于后者
   *
   * @param start
   * @param end
   * @return
   */
  public static int startIsGtEnd(Date start, Date end) {
    return (new DateTime(start)).compareTo(new DateTime(end));
  }

  /**
   * 格式化日期
   *
   * @return
   */
  public static DateTime fomatDate(String date) {

    try {
      return new DateTime(date.trim());
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * 年、月、日格式化日期
   */
  public static Date formatDate(int year, int month, int day) {
    String date = year + SEPARATE + month + SEPARATE + day;
    return formatDate(date);
  }

  /**
   * 格式化日期
   *
   * @param date
   * @return
   */
  public static Date formatDate(String date) {
    DateTime dateTime = new DateTime(date.trim());
    return dateTime.toDate();
  }

  public static Date formatStringToDate(String str, String pattern) {
    DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(pattern);
    return DateTime.parse(str, dateTimeFormatter).toDate();
  }

  /**
   * 校验日期是否合法
   *
   * @return
   */
  public static boolean isValidDate(String s, String pattern) {
    if (null == s || "".equals(s) || null == pattern || "".equals(pattern))
      return false;
    DateFormat fmt = new SimpleDateFormat(pattern);
    try {
      fmt.parse(s);
      return true;
    } catch (Exception e) {
      // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
      e.printStackTrace();
      return false;
    }
  }

  public static int getDiffYear(String startTime, String endTime) {
    try {
      return Years.yearsBetween(new DateTime(startTime), new DateTime(endTime)).getYears();
    } catch (Exception e) {
      // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
      e.printStackTrace();
      return 0;
    }
  }

  /**
   * <li>功能描述：时间相减得到天数
   *
   * @param beginDateStr
   * @param endDateStr
   * @return long
   * @author Administrator
   */
  public static long getDaySub(String beginDateStr, String endDateStr) {
    long days = 0;

    try {
      days = Days.daysBetween(new DateTime(beginDateStr), new DateTime(endDateStr)).getDays();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return days;
  }

  /**
   * 两个日期相差小时数
   * 后者-前者
   */
  public static int getBetweenHours(Date start, Date end) {
    return Hours.hoursBetween(new DateTime(start), new DateTime(end)).getHours();
  }

  /**
   * 计算两个日期相差几天end-start，不足一天为0
   */
  public static int getBetweenDays(Date start, Date end) {
    Period p = new Period(new DateTime(start), new DateTime(end), PeriodType.days());
    return p.getDays();
  }

  /**
   * 计算两个日期相差分钟
   *
   * @param start
   * @param end
   * @return
   */
  public static int getBetweenMinutes(Date start, Date end) {
    Period p = new Period(new DateTime(start), new DateTime(end), PeriodType.minutes());
    return p.getMinutes();
  }

  /**
   * 获取当前日期 n 天后的日期
   *
   * @param days 增加的天数
   * @return
   */
  public static String getDateAfterDays(int days) {
    DateTime dateTime = new DateTime();
    dateTime = dateTime.plusDays(days);

    return dateTime.toString(DATE);
  }

  /**
   * 获取当前日期 n 天后的日期
   *
   * @param days 增加的天数
   * @return
   */
  public static Date getDateAfterDay(int days) {
    DateTime dateTime = new DateTime();
    dateTime = dateTime.plusDays(days);

    return dateTime.toDate();
  }

  /**
   * 获取一个日期 plusDay 天后的日期
   *
   * @param date
   * @param plusDay 增加的天数
   * @return
   */
  public static Date getDateAfterDays(Date date, int plusDay) {
    if (date == null) return null;
    DateTime dateTime = new DateTime(date);
    DateTime afterDateTime = dateTime.plusDays(plusDay);
    return afterDateTime.toDate();
  }

  /**
   * 获取一个日期 n 天前的日期
   *
   * @param date
   * @param minusDay
   * @return
   */
  public static Date getDateBeforeDays(Date date, int minusDay) {
    DateTime dateTime = new DateTime(date);
    DateTime beforeDateTime = dateTime.minusDays(minusDay);
    return beforeDateTime.toDate();
  }

  /**
   * 获取一个日期几天后的日期，按格式返回
   *
   * @param date
   * @param plusDay 增加的天数
   * @param pattern 格式化格式
   * @return
   */
  public static String getFormatDateAfterDays(Date date, int plusDay, String pattern) {
    DateTime dateTime = new DateTime(date);
    DateTime afterDateTime = dateTime.plusDays(plusDay);
    return afterDateTime.toString(pattern);
  }

  /**
   * 获取某日期几天后的日期
   *
   * @param days
   * @param date
   * @return
   */
  public static Date getDaysAfterDate(int days, Date date) {
    DateTime dateTime = new DateTime(date).plusDays(days);
    return dateTime.toDate();
  }


  /**
   * 获取当前日期几周后的日期
   *
   * @param days
   * @return
   */
  public static String getDateAfterWeeks(String days) {
    int daysInt = Integer.parseInt(days);
    DateTime dateTime = new DateTime();
    dateTime = dateTime.plusWeeks(daysInt); // 增加星期
    return dateTime.toString(DATE);
  }

  /**
   * 格式化日期
   *
   * @param date    类型时间
   * @param pattern 转换格式
   */
  public static String getFormatDate(Date date, String pattern) {
    if (date == null || "".equals(pattern) || null == pattern) return "";
    DateTime dtime = new DateTime(date);
    return dtime.toString(pattern);
  }

  /**
   * 格式化时间格式
   *
   * @param dateTime
   * @param pattern
   * @return
   */
  public static String formatDateTime(String dateTime, String pattern) {
    if (dateTime == null || "".equals(pattern) || null == pattern) return "";
    DateTime dtime = new DateTime(dateTime);
    return dtime.toString(pattern);
  }


  /**
   * Date类型按照指定格式转化为Date类型
   *
   * @param date     格式化前
   * @param pattern  日期格式 yyyy-mm-dd
   * @param minusDay 获取date的前N天日期
   */
  public static Date getDateToDate(Date date, String pattern, int minusDay) {
    String dateStr = getFormatDate(date, pattern);
    return fomatDate(dateStr).minusDays(minusDay).toDate();
  }

  /**
   * 获取某个月有多少天
   *
   * @param year  哪年
   * @param month 哪月
   */
  public static int getDaysOfMonth(int year, int month) {
    DateTime dateTime = new DateTime(year, month, 14, 12, 0, 0, 000);
    return dateTime.dayOfMonth().getMaximumValue();
  }

  /**
   * 获取两个相同年月日日期的时分秒 大小
   *
   * @return true 当前时间大于截止日期  false当前时间小于截止日期
   */
  public static boolean lteCurrentTime(Date endDate) {
    DateTimeFormatter format = DateTimeFormat.forPattern(DATE_TIME);
    DateTime now = DateTime.parse(UNIX_FIRST_YEAR + " " + (new DateTime()).toString(TIME), format);
    DateTime end = DateTime.parse((new DateTime(endDate)).toString(format), format);
    return now.compareTo(end) >= 0;
  }

  public static String getLangDate() {
    java.time.LocalTime localtime = java.time.LocalTime.now();
    java.time.LocalDateTime localDateTime = localtime.atDate(LocalDate.now());
    return localDateTime.format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
  }

  /**
   * 判断日期是否为周末
   *
   * @param date
   * @return
   */
  public static boolean isWeekend(Date date) {
    int dayOfWeek = new DateTime(date).dayOfWeek().get();
    if (dayOfWeek == 6 || dayOfWeek == 7) {
      return true;
    }
    return false;
  }

  /**
   * 判断日期是否在两个日期之间
   *
   * @param checkDate
   * @param startDate
   * @param endDate
   * @return
   */
  public static boolean isDateBetweenDates(Date checkDate, Date startDate, Date endDate) {

    if (checkDate == null || startDate == null || endDate == null) {
      return false;
    }
    long checkDateLong = checkDate.getTime();
    if (checkDateLong >= startDate.getTime() && checkDateLong <= endDate.getTime()) {
      return true;
    }

    return false;
  }

  /**
   * 判断当前日期是否在两个日期之间
   *
   * @param startDate
   * @param endDate
   * @return
   */
  public static boolean isDateBetweenDates(Date startDate, Date endDate) {
    Date newDate = new Date();
    if (startDate == null || endDate == null) {
      return false;
    }
    long checkDateLong = newDate.getTime();
    if (checkDateLong >= startDate.getTime() && checkDateLong <= endDate.getTime()) {
      return true;
    }

    return false;
  }

  /**
   * 获得当前时间当天的开始时间，即当前给出的时间那一天的00:00:00的时间
   *
   * @param date 当前给出的时间
   * @return 当前给出的时间那天的00:00:00的时间的日期对象
   */
  public static Date getDateBegin(Date date) {
    SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd");
    if (date != null) {
      try {
        return DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.CHINA).parse(ymdFormat.format(date));
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }

    return null;
  }

  /**
   * 获得当前时间当天的结束时间，即当前给出的时间那一天的23:59:59的时间
   *
   * @param date 当前给出的时间
   * @return 当前给出的时间那天的23:59:59的时间的日期对象
   */
  public static Date getDateEnd(Date date) {
    SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd");
    if (date != null) {
      try {
        date = getDateBeforeOrAfterDays(date, 1);
        date = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.CHINA).parse(ymdFormat.format(date));
        Date endDate = new Date();
        endDate.setTime(date.getTime() - 1000);
        return endDate;
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  /**
   * 计算出date day天之前或之后的日期
   *
   * @param date {@link Date} 日期
   * @param days int 天数，正数为向后几天，负数为向前几天
   * @return 返回Date日期类型
   */
  public static Date getDateBeforeOrAfterDays(Date date, int days) {
    Calendar now = Calendar.getInstance();
    now.setTime(date);
    now.set(Calendar.DATE, now.get(Calendar.DATE) + days);
    return now.getTime();
  }

  /**
   * 获取当前月第一天时间
   *
   * @return
   */
  public static Date getNowMonthBegin() {
    Calendar calendar = new GregorianCalendar();
    calendar.set(Calendar.DATE, 1);
    SimpleDateFormat simpleFormate = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat simpleFormate2 = new SimpleDateFormat(
      "yyyy-MM-dd HH:mm:ss");
    Date date = null;
    try {
      date = simpleFormate2
        .parse(simpleFormate.format(calendar.getTime())
          + " 00:00:00");
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return date;
  }

  /**
   * 取当前月最后一天
   *
   * @return
   */
  public static Date getNowMonthEnd() {
    Calendar calendar = new GregorianCalendar();
    calendar.set(Calendar.DATE, 1);
    calendar.roll(Calendar.DATE, -1);
    SimpleDateFormat simpleFormate = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat simpleFormate2 = new SimpleDateFormat(
      "yyyy-MM-dd HH:mm:ss");
    Date date = null;
    try {
      date = simpleFormate2
        .parse(simpleFormate.format(calendar.getTime())
          + " 23:59:59");
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return date;
  }

  /**
   * 得到日期的前或者后几小时
   *
   * @param iHour 如果要获得前几小时日期，该参数为负数； 如果要获得后几小时日期，该参数为正数
   * @return Date 返回参数<code>curDate</code>定义日期的前或者后几小时
   * @see Calendar#add(int, int)
   */
  public static Date getDateBeforeOrAfterHours(Date curDate, int iHour) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(curDate);
    cal.add(Calendar.HOUR_OF_DAY, iHour);
    return cal.getTime();
  }

  public static Date getDateAfterDayAndTime(Integer endOrderDay, Date endOrderTime) {
    //当前日期+提前天数
    Date currentDate = DateUtils.getDateAfterDays(new Date(), endOrderDay);
    Date currentDateYMD = DateUtils.getDateToDate(currentDate, DateUtils.DATE, 0);
    //当前时分大于当天最晚预定时间，则日期+1
    if (DateUtils.lteCurrentTime(endOrderTime)) {
      return DateUtils.getDateAfterDays(currentDateYMD, 1);
    } else {
      return currentDateYMD;
    }
  }

  /**
   * 格式化持续时间<br/>
   * 将持续时间，格式化为 xx天xx时xx分xx秒 如果 "xx" 为0 自动缺省。
   *
   * @param minute 持续时间,单位(分钟)
   * @return 格式化后的字符串
   * @see TimeUnit 时间单位转换工具
   */
  public static String convertMinute2Str(long minute) {
    final String[] UNIT_DESC = new String[]{"天", "时", "分", "秒"};
    StringBuilder sb = new StringBuilder();
    long[] date = {TimeUnit.SECONDS.toHours(minute) % 24, TimeUnit.SECONDS.toMinutes(minute) % 60, TimeUnit.SECONDS.toSeconds(minute) % 60};
    for (int i = 0; i < date.length; i++) {
      long l = date[i];
      if (l > 0) sb.append(l).append(UNIT_DESC[i]);
    }
    return sb.toString();
  }

  /**
   * 将字符串格式yyyyMMdd的字符串转为日期，格式"yyyy-MM-dd"
   *
   * @param date 日期字符串
   * @return 返回格式化的日期
   * @throws ParseException 分析时意外地出现了错误异常
   */
  public static String strToDateFormat(String date) {
    SimpleDateFormat formatter = new SimpleDateFormat(DAY);
    formatter.setLenient(false);
    Date newDate = null;
    try {
      newDate = formatter.parse(date);
      formatter = new SimpleDateFormat(DATE);
      return formatter.format(newDate);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 查询日期后N秒日期
   */
  public static Date getDateAfterSeconds(Date date, int seconds) {
    DateTime dateTime = new DateTime(date);
    return dateTime.plusSeconds(seconds).toDate();
  }

  /**
   * 查询日期前N秒日期
   */
  public static Date getDateBeforeSeconds(Date date, int seconds) {
    DateTime dateTime = new DateTime(date);
    return dateTime.minusSeconds(seconds).toDate();
  }

  /**
   * startDate距离endDate还有多少秒   return endDate-startDate;
   */
  public static int getBetweenSeconds(Date startDate, Date endDate) {
    return Seconds.secondsBetween(new DateTime(startDate), new DateTime(endDate)).getSeconds();
  }

  /**
   * startDate距离当前时间还有多少秒   return endDate-startDate;
   */
  public static int getBetweenSeconds(Date startDate) {
    return Seconds.secondsBetween(new DateTime(startDate), new DateTime(new Date())).getSeconds();
  }

  /**
   * 比较HH:MM类型谁大，可退为true
   */
  public static boolean getHM(String sDate, Date eDate) {
    char[] startDate = DateUtils.getDay().toCharArray();
    char[] startTime = sDate.toCharArray();
    String[] split = DateUtils.getFormatDate(eDate, DATE_TIME).split(" ");
    char[] endDate = split[0].toCharArray();
    char[] endTime = DateUtils.getHM().toCharArray();
    for (int i = 0; i < startDate.length; i++) {
      if (startDate[i] > endDate[i]) return false;
      if (startDate[i] < endDate[i]) return true;
    }
    for (int i = 0; i < startTime.length; i++) {
      if (startTime[i] > endTime[i]) return true;
      if (startTime[i] < endTime[i]) return false;
    }
    return false;
  }

  public static Date getStartOfDay(Date date) {
    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int day = calendar.get(Calendar.DATE);
    calendar.set(year, month, day, 0, 0, 0);
    return calendar.getTime();
  }

  public static Date getEndOfDay(Date date) {
    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int day = calendar.get(Calendar.DATE);
    calendar.set(year, month, day, 23, 59, 59);
    return calendar.getTime();
  }

  //日开始00:00
  public static Date atDayStart(Date date) {
    return localDateTimeToDate(dateToLocalDateTime(date).with(java.time.LocalTime.MIN));
  }
  //Date转LocalDateTime
  public static LocalDateTime dateToLocalDateTime(Date date) {
    return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
  }
  //LocalDateTime转Date
  public static Date localDateTimeToDate(java.time.LocalDateTime localDateTime) {
    return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
  }


  /**
   * @param args
   */
  public static void main(String[] args) {
//        System.out.println(getDateBegin(formatDate("2018-12-05")) + "========" + getDateEnd(formatDate("2018-12-30")));
//        System.out.println("" + getYear());
//        System.out.println("" + getMonth());
//        System.out.println("" + getDays(new Date()));
//        System.out.println("" + getDays(formatDate("2018-09-20")));
//        System.out.println("" + getSeveralWeeks(2018L, 12L, 20L));
    //   System.out.println("" + getCDay());
//        System.out.println("" + getWeek());
//        System.out.println("" + getWeek(formatDate("2018-12-30")));
//        Calendar instance = Calendar.getInstance();
//        instance.setTime(formatDate("2018-09-20"));
//        instance.setTime(new Date());
//        System.out.println("" + instance.get(Calendar.WEEK_OF_MONTH));
//        System.out.println("" + instance.getActualMaximum(Calendar.WEEK_OF_MONTH));
//        System.out.println("" + instance.getMaximum(Calendar.WEEK_OF_MONTH));
    System.out.println(getDaysByDate(new Date()));

    Date nextWeekMonday = getNextWeekMonday(new Date());
    Date a = getDateAfterDays(new Date(), 5);
  }
}
