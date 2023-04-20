package org.crm.crmback.infrastructure.token.charset;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DefaultTokenCharset implements TokenCharset {
  ALPHA(CustomCharset.ALPHA_ALL),
  NUMERIC(CustomCharset.NUMERIC),
  ALPHANUMERIC(CustomCharset.ALPHA_ALL + CustomCharset.NUMERIC),
  ALL_CHARACTERS(
      CustomCharset.ALPHA_ALL + CustomCharset.NUMERIC + CustomCharset.SPECIAL_CHARACTERS);

  private final String charset;
}
