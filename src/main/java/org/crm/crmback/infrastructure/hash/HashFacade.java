package org.crm.crmback.infrastructure.hash;

public interface HashFacade {

  String hash(String input);

  boolean check(String hash, String plainText);
}
