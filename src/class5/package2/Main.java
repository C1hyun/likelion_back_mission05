package class5.package2;

import class5.role.Lion;
import class5.role.Role;
import class5.role.Staff;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService service = appConfig.memberService();

        Scanner sc = new Scanner(System.in);

        System.out.println("멋사 멤버 관리 시스템 - Step 2 (IoC / DI)");
        System.out.println("※ 구현체: "
                + appConfig.memberRepository().getClass().getSimpleName() + "\n");

        while (true) {
            printMenu();
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1" -> registerMember(sc, service);
                case "2" -> printAllMembers(service);
                case "3" -> searchByName(sc, service);
                case "0" -> {
                    System.out.println("종료합니다.");
                    sc.close();
                    return;
                }
                default -> System.out.println("올바른 번호를 입력해주세요.\n");
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. 멤버 등록  2. 전체 조회  3. 이름 검색  0. 종료");
        System.out.print("선택 > ");
    }

    private static void registerMember(Scanner sc, MemberService service) {
        System.out.println("\n역할 선택: 1) 아기사자  2) 운영진");
        System.out.print("선택 > ");
        String roleChoice = sc.nextLine().trim();

        Role newMember;
        if (roleChoice.equals("1"))      newMember = inputLion(sc);
        else if (roleChoice.equals("2")) newMember = inputStaff(sc);
        else { System.out.println("올바른 역할을 선택해주세요.\n"); return; }

        System.out.println(service.register(newMember) + "\n");
    }

    private static void printAllMembers(MemberService service) {
        List<Role> members = service.findAll();
        if (members.isEmpty()) { System.out.println("등록된 멤버가 없습니다.\n"); return; }

        System.out.println("\n전체 멤버 (" + members.size() + "명)");
        for (Role m : members) {
            System.out.println(m.getDetailInfo());
        }
        System.out.println();
    }

    private static void searchByName(Scanner sc, MemberService service) {
        System.out.print("검색할 이름 > ");
        String name = sc.nextLine().trim();

        Optional<Role> result = service.findByName(name);
        if (result.isEmpty()) {
            System.out.println("'" + name + "' 에 해당하는 멤버가 없습니다.\n");
        } else {
            System.out.println("\n검색 결과");
            System.out.println(result.get().getDetailInfo());
        }
    }

    private static Lion inputLion(Scanner sc) {
        System.out.print("  이름  : "); String name       = sc.nextLine().trim();
        System.out.print("  전공  : "); String major      = sc.nextLine().trim();
        System.out.print("  기수  : "); int    generation = Integer.parseInt(sc.nextLine().trim());
        System.out.print("  파트  : "); String part       = sc.nextLine().trim();
        System.out.print("  학번  : "); String studentId  = sc.nextLine().trim();
        return new Lion(name, major, generation, part, studentId);
    }

    private static Staff inputStaff(Scanner sc) {
        System.out.print("  이름  : "); String name       = sc.nextLine().trim();
        System.out.print("  전공  : "); String major      = sc.nextLine().trim();
        System.out.print("  기수  : "); int    generation = Integer.parseInt(sc.nextLine().trim());
        System.out.print("  파트  : "); String part       = sc.nextLine().trim();
        System.out.print("  직책  : "); String position   = sc.nextLine().trim();
        return new Staff(name, major, generation, part, position);
    }
}
