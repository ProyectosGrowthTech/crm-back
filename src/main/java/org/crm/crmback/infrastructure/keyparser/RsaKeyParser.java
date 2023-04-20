package org.crm.crmback.infrastructure.keyparser;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public interface RsaKeyParser {

  RSAPublicKey parsePublicKey(String pem);

  RSAPrivateKey parsePrivateKey(String pem);
}
