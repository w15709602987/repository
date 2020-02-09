package zuikecheng.bean;

public class Role {
    private String r_id;
    private String roleName;
    private String state;
    private String remarks;

    public void setR_id(String r_id) {
        this.r_id = r_id;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getR_id() {
        return r_id;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getState() {
        return state;
    }

    public String getRemarks() {
        return remarks;
    }

    public Role() {
    }

    public Role(String r_id, String roleName, String state, String remarks) {
        this.r_id = r_id;
        this.roleName = roleName;
        this.state = state;
        this.remarks = remarks;
    }
}
