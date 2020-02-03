package zuikecheng.service;

import zuikecheng.bean.Customer;
import zuikecheng.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CustomerService")
public class CustomerService {
    @Autowired
    CustomerDao customerDao;



    public List<Customer> getCustomer() {
        return customerDao.findCustomer();
    }



}
