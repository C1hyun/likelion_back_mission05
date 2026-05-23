package class5.package2;

import class5.role.Role;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public String register(Role member) {
        if (repository.existsByName(member.getName())) {
            return "등록 실패: '" + member.getName() + "' 은(는) 이미 존재하는 이름입니다.";
        }
        repository.save(member);
        return "등록 완료: " + member.getName();
    }

    public List<Role> findAll() {
        return repository.findAll();
    }

    public Optional<Role> findByName(String name) {
        return repository.findByName(name);
    }
}
