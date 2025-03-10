package dev.elibertocastro.usermanagement.domain.user;

import java.util.List;
import java.util.UUID;

public interface UserRepository {
    User save(User user);
    User findById(UUID id);
    User findByEmail(String email);
    List<User> findAll();
//    User update(User user);
    void delete(String id);
}
