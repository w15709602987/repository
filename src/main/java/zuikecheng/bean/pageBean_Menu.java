package zuikecheng.bean;

import java.util.List;

public class pageBean_Menu implements Page {

    private int pageNum;
    private int pageSize;
    private int totalCount;
    private int totalPageNume;
    private String conditionName;
    private String conditionValue;
    private List<Menu> list;

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

    @Override
    public void setCustomers(List<Customer> customers) {

    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public void setConditionValue(String conditionValue) {
        this.conditionValue = conditionValue;
    }

    @Override
    public void setOrderByMethod(String orderByMethod) {

    }

    public void setList(List<Menu> list) {
        this.list = list;
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

    @Override
    public List<Customer> getCustomers() {
        return null;
    }

    public String getConditionName() {
        return conditionName;
    }

    public String getConditionValue() {
        return conditionValue;
    }

    @Override
    public String getOrderByMethod() {
        return null;
    }

    public List<Menu> getList() {
        return list;
    }

    public pageBean_Menu() {
    }
}
