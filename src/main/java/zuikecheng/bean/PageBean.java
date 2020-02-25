package zuikecheng.bean;

import java.util.List;

//存放分页查询的数据
public class PageBean implements Page{
    private int pageNum;    //当前页的页码
    private int pageSize;   //每一页所显示的记录条数
    private int totalCount; //总的数据条数
    private int totalPageNume; //总页数
    private String conditionName;
    private String conditionValue;
    private String orderByMethod;

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public void setConditionValue(String conditionValue) {
        this.conditionValue = conditionValue;
    }

    public void setOrderByMethod(String orderByMethod) {
        this.orderByMethod = orderByMethod;
    }

    public String getConditionName() {
        return conditionName;
    }

    public String getConditionValue() {
        return conditionValue;
    }

    public String getOrderByMethod() {
        return orderByMethod;
    }

    private List<Customer> customers; //当前页所需的记录数据


    public PageBean() {
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setTotalPageNume(int totalPageNume) {
        this.totalPageNume = totalPageNume;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getTotalPageNume() {
        return totalPageNume;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}

