package zuikecheng.utils;

import zuikecheng.bean.Customer;
import zuikecheng.bean.Menu;
import zuikecheng.bean.Role;
import zuikecheng.bean.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ControllerUtil {
    public static String gettime() {
        Calendar c = Calendar.getInstance(Locale.CHINA);//默认是当前日期
        // 获得年份
        int year = c.get(Calendar.YEAR) - 1900;
        // 获得月份
        int month = c.get(Calendar.MONTH);
        // 获得日期
        int date = c.get(Calendar.DATE);
        //获得小时,并换算成北京时间
        int h = c.get(Calendar.HOUR_OF_DAY);
        //获得分钟
        int mi = c.get(Calendar.MINUTE);
        //获得秒
        int s = c.get(Calendar.SECOND);
        //将获得的参数添加到addtime中；
        java.util.Date at = new java.util.Date(year, month, date, h, mi, s);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf2.format(at);
        return time;
    }

    public static Customer fromCustomer(String customername, String companyname, String addtime, String cellphone, String companyaddress, String landline, String introduction, String remarks, String modtime) {
        Customer customer = new Customer();
        customer.setCustomername(customername);
        customer.setCompanyname(companyname);
        customer.setAddtime(addtime);
        customer.setCellphone(cellphone);
        customer.setCompanyaddress(companyaddress);
        customer.setLandline(landline);
        customer.setIntroduction(introduction);
        customer.setRemarks(remarks);
        customer.setModtime(modtime);
        return customer;
    }

    public static Menu fromMenu(String m_id, String menuName, String fatherMenuName, String menuPath, String remarks) {
        Menu menu = new Menu();
        menu.setM_id(m_id);
        menu.setMenuName(menuName);
        menu.setFatherMenuName(fatherMenuName);
        menu.setMenuPath(menuPath);
        menu.setRemarks(remarks);
        return menu;
    }

    public static User fromUser(String position,String userName,String gender,int age,String cellPhone,String addTime,String idCard,String remarks,String u_id) {
        User user = new User();
        user.setPosition(position);
        user.setUsername(userName);
        user.setGender(gender);
        user.setAge(age);
        user.setCellphone(cellPhone);
        user.setInitiationtime(addTime);
        user.setIdcard(idCard);
        user.setRemarks(remarks);
        user.setU_id(u_id);
        return user;
    }
    public static Role fromRole(String r_id,String roleName,String state,String remarks) {
        Role role = new Role();
        role.setR_id(r_id);
        role.setRoleName(roleName);
        role.setState(state);
        role.setRemarks(remarks);
        return role;
    }
}

