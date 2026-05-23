package class5.package2;

import class5.role.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository {

    private final List<Role> store = new ArrayList<>();

    @Override
    public void save(Role member) {
        store.add(member);
    }

    @Override
    public List<Role> findAll() {
        return List.copyOf(store);
    }

    @Override
    public Optional<Role> findByName(String name) {
        return store.stream()
                .filter(m -> m.getName().equals(name))
                .findFirst();
    }

    @Override
    public boolean existsByName(String name) {
        return store.stream()
                .anyMatch(m -> m.getName().equals(name));
    }
}
