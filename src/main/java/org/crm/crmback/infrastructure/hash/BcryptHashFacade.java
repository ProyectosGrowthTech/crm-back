package org.crm.crmback.infrastructure.hash;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;

@RequiredArgsConstructor
public class BcryptHashFacade implements HashFacade {

  private final Integer logRounds;

  @Override
  public String hash(String input) {
    return BCrypt.hashpw(input, BCrypt.gensalt(logRounds));
  }

  @Override
  public boolean check(String hash, String plainText) {
    return BCrypt.checkpw(plainText, hash);
  }
}
