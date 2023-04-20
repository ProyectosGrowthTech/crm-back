package org.crm.crmback.infrastructure.token;

import org.crm.crmback.infrastructure.token.charset.TokenCharset;

public interface TokenGenerator {

  String generate(TokenCharset charset, int size);
}
