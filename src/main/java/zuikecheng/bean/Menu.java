package zuikecheng.bean;

public class Menu {
    private String m_id;
    private String menuName;
    private String fatherMenuName;
    private String menuPath;
    private String remarks;
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setFatherMenuName(String fatherMenuName) {
        this.fatherMenuName = fatherMenuName;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public String getM_id() {
        return m_id;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getFatherMenuName() {
        return fatherMenuName;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public Menu() {
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }
}
