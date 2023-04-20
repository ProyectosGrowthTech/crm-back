package org.crm.crmback.infrastructure.keyparser;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import org.crm.crmback.infrastructure.exception.RsaKeyParserException;
import org.crm.crmback.infrastructure.utils.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class RsaPkcs8RsaKeyParser implements RsaKeyParser {

  public RSAPublicKey parsePublicKey(String pem) {
    try {
      String publicKey =
          StringUtils.removeFromString(
              pem,
              RsaConstants.RSA_PUBLIC_KEY_PEM_START,
              RsaConstants.RSA_PUBLIC_KEY_PEM_END,
              "\n");
      byte[] byteKey = Base64.getDecoder().decode(publicKey);
      X509EncodedKeySpec keySpec = new X509EncodedKeySpec(byteKey);
      KeyFactory keyFactory = KeyFactory.getInstance(RsaConstants.RSA_ALGORITHM);
      return (RSAPublicKey) keyFactory.generatePublic(keySpec);
    } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
      throw new RsaKeyParserException("error while parsing X509 public key", ex);
    }
  }

  public RSAPrivateKey parsePrivateKey(String pem) {
    try {
      this.validatePkcs8PrivateKey(pem);
      String privateKey =
          StringUtils.removeFromString(
              pem,
              RsaConstants.RSA_PRIVATE_KEY_PKCS8_PEM_START,
              RsaConstants.RSA_PRIVATE_KEY_PKCS8_PEM_END,
              "\n");
      byte[] byteKey = Base64.getDecoder().decode(privateKey);
      PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(byteKey);
      KeyFactory keyFactory = KeyFactory.getInstance(RsaConstants.RSA_ALGORITHM);
      return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
    } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
      throw new RsaKeyParserException("error while parsing PKCS8 private key", ex);
    }
  }

  private void validatePkcs8PrivateKey(String pem) {
    if (pem.contains(RsaConstants.RSA_PRIVATE_KEY_PKCS1_PEM_START)
        || pem.contains(RsaConstants.RSA_PRIVATE_KEY_PKCS1_PEM_END)) {
      throw new RsaKeyParserException("Unsupported PKCS1 format");
    }
  }
}
