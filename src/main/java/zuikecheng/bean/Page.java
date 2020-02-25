package zuikecheng.bean;

import java.util.List;

public interface Page {
   void setConditionName(String conditionName);

   void setConditionValue(String conditionValue);

   void setOrderByMethod(String orderByMethod);

   String getConditionName();

   String getConditionValue();

   String getOrderByMethod();



    public void setPageNum(int pageNum);

    public void setPageSize(int pageSize);

    public void setTotalCount(int totalCount);

    public void setTotalPageNume(int totalPageNume);

    public int getPageNum();

    public int getPageSize();

    public int getTotalCount();

    public int getTotalPageNume();

}
