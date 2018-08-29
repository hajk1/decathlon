package ir.hajk1;

import java.text.DecimalFormat;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <This class is used for converting minutes and seconds>
 */
public class TimeUtils {

  /**
   * This method is used to change back 'seconds.fraction' to 'minutes.seconds.fraction'
   */
  public static String convertSecondsToMinutes(double score) {
    int minutes = (int) (score) / 60;
    int seconds = (int) (score) % 60;
    String fraction = new DecimalFormat("0.00").format(score).split("\\.")[1];
    return minutes + "." + seconds + "." + fraction;
  }

  /**
   * This method is used to convert 'minutes.seconds.fraction' to 'seconds.fraction'
   */
  public static Double convertMinutesToSeconds(String minutesSecondsStr) {
    String[] times = minutesSecondsStr.split("\\.");
    int minutes = Integer.parseInt(times[0]);
    int seconds = (minutes * 60) + Short.parseShort(times[1]);
    return Double.parseDouble(seconds + "." + times[2]);
  }
}
