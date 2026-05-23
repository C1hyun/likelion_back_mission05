package class5.role;

import class5.policy.SubmissionPolicy;

public abstract class Role {

    private final String name;
    private final String major;
    private final int    generation;
    private final String part;

    public Role(String name, String major, int generation, String part) {
        this.name       = name;
        this.major      = major;
        this.generation = generation;
        this.part       = part;
    }

    public String getName()       { return name; }
    public String getMajor()      { return major; }
    public int    getGeneration() { return generation; }
    public String getPart()       { return part; }

    public abstract SubmissionPolicy getSubmissionPolicy();
    public abstract String getDetailInfo();

    public boolean canSubmit() {
        return getSubmissionPolicy().canSubmit();
    }

    protected String getCommonInfo() {
        return "이름    : " + name       + "\n"
             + "전공    : " + major      + "\n"
             + "기수    : " + generation + "기\n"
             + "파트    : " + part;
    }
}
