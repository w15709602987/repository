package zuikecheng.bean;
import zuikecheng.bean.Menu;
import java.util.List;

public class R_id_M_id {
    private String r_id;
    private String m_id;



    public void setMenus(final List<Menu> menus) {
        this.menus = menus;
    }

    private List<Menu> menus;
    public void setR_id(String r_id) {
        this.r_id = r_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public R_id_M_id() {
    }

    public String getR_id() {
        return r_id;
    }

    public String getM_id() {
        return m_id;
    }
}
