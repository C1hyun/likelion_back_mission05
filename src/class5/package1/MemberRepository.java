package class5.package1;

import class5.role.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberRepository {

    private final List<Role> store = new ArrayList<>();

    public void save(Role member) {
        store.add(member);
    }

    public List<Role> findAll() {
        return List.copyOf(store);
    }

    public Optional<Role> findByName(String name) {
        return store.stream()
                .filter(m -> m.getName().equals(name))
                .findFirst();
    }

    public boolean existsByName(String name) {
        return store.stream()
                .anyMatch(m -> m.getName().equals(name));
    }
}
