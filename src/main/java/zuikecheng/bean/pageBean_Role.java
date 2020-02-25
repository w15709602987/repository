package zuikecheng.bean;

import java.util.List;

public class pageBean_Role implements Page{
    private int pageNum;
    private int pageSize;
    private int totalCount;
    private int totalPageNume;
    private String conditionName;
    private String conditionValue;
    private List<Role> list;

    public pageBean_Role(int pageNum, int pageSize, int totalCount, int totalPageNume, String conditionName, String conditionValue, List<Role> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPageNume = totalPageNume;
        this.conditionName = conditionName;
        this.conditionValue = conditionValue;
        this.list = list;
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

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public void setConditionValue(String conditionValue) {
        this.conditionValue = conditionValue;
    }

    @Override
    public void setOrderByMethod(String orderByMethod) {

    }

    public void setList(List<Role> list) {
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

    public List<Role> getList() {
        return list;
    }

    public pageBean_Role() {
    }
}
