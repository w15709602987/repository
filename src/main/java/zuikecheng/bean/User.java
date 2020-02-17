package zuikecheng.bean;

import java.util.List;

public class User {
    private String u_id;
    private String username;
    private String position;
    private String gender;
    private int age;
    private String cellphone;
    private String initiationtime;
    private String idcard;
    private String remarks;
    private String password;
    private String roleName;
    private String r_id;
    private  List<Menu> Menus;
    public String getRoleName(User user) {
        return this.roleName;
    }

    public void setRoleName(final String roleName) {
        this.roleName = roleName;
    }

    public User(String u_id, String username, String position, String gender, int age, String cellphone, String initiationtime, String idcard, String remarks, String password) {
        this.u_id = u_id;
        this.username = username;
        this.position = position;
        this.gender = gender;
        this.age = age;
        this.cellphone = cellphone;
        this.initiationtime = initiationtime;
        this.idcard = idcard;
        this.remarks = remarks;
        this.password = password;

    }

    public String getU_id() {
        return u_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPosition() {
        return position;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getInitiationtime() {
        return initiationtime;
    }

    public String getIdcard() {
        return idcard;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getPassword() {
        return password;
    }



    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public void setInitiationtime(String initiationtime) {
        this.initiationtime = initiationtime;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }


    public List<Menu> getMenus() {
        return this.Menus;
    }

    public void setMenus(final List<Menu> menus) {
        this.Menus = menus;
    }


    public String getRoleName() {
        return this.roleName;
    }
}
