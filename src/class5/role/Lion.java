package class5.role;

import class5.policy.LionSubmissionPolicy;
import class5.policy.SubmissionPolicy;

public class Lion extends Role {

    private final String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    public String getStudentId() { return studentId; }

    @Override
    public SubmissionPolicy getSubmissionPolicy() {
        return new LionSubmissionPolicy();
    }

    @Override
    public String getDetailInfo() {
        return "[아기사자]\n"
             + super.getCommonInfo() + "\n"
             + "학번    : " + studentId + "\n"
             + "제출여부: " + (canSubmit() ? "제출 가능" : "제출 불가");
    }
}
