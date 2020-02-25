package zuikecheng.bean;

import java.util.List;

public class pageBean_User implements Page{
    private int pageNum;    //当前页的页码
    private int pageSize;   //每一页所显示的记录条数
    private int totalCount; //总的数据条数
    private int totalPageNume; //总页数
    private String conditionName; //条件名
    private String conditionValue;//条件值
    private String orderByMethod;//排序方式
    private List<User> list;

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

    public void setOrderByMethod(String orderByMethod) {
        this.orderByMethod = orderByMethod;
    }

    public void setList(List<User> list) {
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

    public String getOrderByMethod() {
        return orderByMethod;
    }

    public List<User> getList() {
        return list;
    }

    public pageBean_User() {
    }
}
