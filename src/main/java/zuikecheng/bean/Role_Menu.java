package zuikecheng.bean;

public class Role_Menu {
    private String r_id;
    private String m_id;

    public Role_Menu(String r_id, String m_id) {
        this.r_id = r_id;
        this.m_id = m_id;
    }

    public void setR_id(String r_id) {
        this.r_id = r_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public String getR_id() {
        return r_id;
    }

    public String getM_id() {
        return m_id;
    }

    public Role_Menu() {
    }
}
