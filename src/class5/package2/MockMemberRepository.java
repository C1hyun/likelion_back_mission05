package class5.package2;

import class5.role.Lion;
import class5.role.Role;
import class5.role.Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MockMemberRepository implements MemberRepository {

    private final List<Role> store = new ArrayList<>();

    public MockMemberRepository() {
        store.add(new Lion("ABC", "컴퓨터공학", 13, "백엔드", "20230001"));
        store.add(new Lion("DEF", "인공지능공학", 13, "프론트엔드", "20230042"));
        store.add(new Staff("GHI", "전자공학", 12, "백엔드", "회장"));
        store.add(new Lion("JKL", "컴퓨터공학", 13, "디자인", "20230077"));
    }

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
