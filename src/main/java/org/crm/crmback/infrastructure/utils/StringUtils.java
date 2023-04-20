package org.crm.crmback.infrastructure.utils;

public class StringUtils {

  private StringUtils() {}

  public static String removeFromString(String str, String... removableStrings) {
    String output = str;
    for (String s : removableStrings) {
      output = output.replace(s, "");
    }
    return output;
  }

  public static boolean isBlank(String str) {
    return str == null || str.isBlank();
  }
}
