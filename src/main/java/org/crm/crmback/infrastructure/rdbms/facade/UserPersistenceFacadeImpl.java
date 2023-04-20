package org.crm.crmback.infrastructure.rdbms.facade;

import lombok.RequiredArgsConstructor;
import org.crm.crmback.domain.model.security.User;
import org.crm.crmback.infrastructure.exception.ItemNotFoundException;
import org.crm.crmback.infrastructure.rdbms.entity.UserEntity;
import org.crm.crmback.infrastructure.rdbms.mapper.UserMapper;
import org.crm.crmback.infrastructure.rdbms.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPersistenceFacadeImpl implements UserPersistenceFacade {

  private final UserRepository userRepository;

  private final UserMapper userMapper;

  public User findByUsername(String username) {
    UserEntity foundUser =
        userRepository
            .findByUsername(username)
            .orElseThrow(() -> new ItemNotFoundException("user " + username + " not found"));
    return userMapper.userEntityToUser(foundUser);
  }

  @Override
  public void save(User newUser) {
    userRepository.save(userMapper.userToUserEntity(newUser));
  }

  @Override
  public boolean isExistingUser(String username) {
    return userRepository.findByUsername(username).isPresent();
  }
}
