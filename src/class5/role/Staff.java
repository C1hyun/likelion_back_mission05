package class5.role;

import class5.policy.StaffSubmissionPolicy;
import class5.policy.SubmissionPolicy;

public class Staff extends Role {

    private final String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    public String getPosition() { return position; }

    @Override
    public SubmissionPolicy getSubmissionPolicy() {
        return new StaffSubmissionPolicy();
    }

    @Override
    public String getDetailInfo() {
        return "[운영진]\n"
             + super.getCommonInfo() + "\n"
             + "직책    : " + position + "\n"
             + "제출여부: " + (canSubmit() ? "제출 가능" : "제출 불가");
    }
}
