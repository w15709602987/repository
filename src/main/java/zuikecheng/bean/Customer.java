package zuikecheng.bean;


import java.util.Date;
public class Customer {
    private int id;
    private String customername;
    private String companyname;
    private String addtime;
    private Date modtime;
    private String cellphone;
    private String companyaddress;
    private String landline;
    private String introduction;
    private String remarks;


    public void setModtime(Date modtime) {
        this.modtime = modtime;
    }

    public Date getModtime() {
        return modtime;
    }

    public int getId() {
        return id;
    }

    public String getCustomername() {
        return customername;
    }

    public String getCompanyname() {
        return companyname;
    }

    public String getAddtime() {
        return addtime;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getCompanyaddress() {
        return companyaddress;
    }

    public String getLandline() {
        return landline;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public void setCompanyaddress(String companyaddress) {
        this.companyaddress = companyaddress;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
