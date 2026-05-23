package class5.package2;

import class5.role.Role;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    void save(Role member);
    List<Role> findAll();
    Optional<Role> findByName(String name);
    boolean existsByName(String name);
}
