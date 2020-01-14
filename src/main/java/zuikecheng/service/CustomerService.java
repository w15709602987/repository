package zuikecheng.service;

import zuikecheng.bean.Customer;
import zuikecheng.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerDao customerDao;
    public Customer getCustomer() {
        return customerDao.findCustomer();
    }



}
