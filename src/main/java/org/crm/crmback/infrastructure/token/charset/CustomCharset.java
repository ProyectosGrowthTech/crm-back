package org.crm.crmback.infrastructure.token.charset;

import java.util.Locale;

public class CustomCharset {

  static final String ALPHA_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  static final String ALPHA_LOWER = ALPHA_UPPER.toLowerCase(Locale.ROOT);

  static final String ALPHA_ALL = ALPHA_LOWER + ALPHA_UPPER;

  static final String NUMERIC = "1234567890";

  static final String SPECIAL_CHARACTERS = "@#!$%&/()=?[]{}-_;:<>";
}
