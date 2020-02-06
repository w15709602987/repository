package zuikecheng.service;

import zuikecheng.bean.Customer;
import zuikecheng.bean.PageBean;
import zuikecheng.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service("CustomerService")
public class CustomerService {
    @Autowired
    CustomerDao customerDao;

    public PageBean CodAndPageQueCustomer(int pageNum, String conditionName, String conditionValue, String orderByMethod) {

        //处理业务逻辑和业务处理所需的数据
        int pageSize = 5;

        //每一页的记录开始的索引
        int pageNum1 = (pageNum - 1) * pageSize;

        //调用Dao层查询数据库获取当前页面的数据；
        List<Customer> list = customerDao.CodAndPageQueCustomer(pageNum1, pageSize,conditionName,conditionValue, orderByMethod);


        //调用Dao层查询当前数据库的总记录条数以便后面获取总的分页的页码数pageNum1, pageSize, , conditionValue, orderByMethod

        int totalCount = customerDao.findCount(conditionName,conditionValue);
        // System.out.println(totalCount+"CustomerService中的totalCount");, conditionValue

        //计算总的页码页数
        int totalPageNume = (totalCount + pageSize - 1) / pageSize;

        //将所有的分页查询数据分装到pageBean中；
        PageBean pageBean = new PageBean();
        pageBean.setPageNum(pageNum);                   // 当前页码的页数
        pageBean.setPageSize(pageSize);                //每页显示的记录条数
        pageBean.setTotalCount(totalCount);           //总的记录条数
        pageBean.setTotalPageNume(totalPageNume);    //总的页码数
        pageBean.setCustomers(list);                     //查询后的customer的集合
        return pageBean;
    }
    public Customer customerLook(String id) {
        return customerDao.customerLook(id);
    }

    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    public void delCustomer(String[] ids) {
        customerDao.delCustomer(ids);
    }

    public void updateCustomer(Customer customer, String id) {
        customerDao.updateCustomer(customer, id);
    }

    public Customer customerEdit(String id) {
        return customerDao.customerLook(id);
    }

    public void addMany(List<Customer> customerList) {
        customerDao.addMany(customerList);
    }
//
//    public List<Customer> findCustomer() {
//        return customerDao.findCustomer();
//    }



}
