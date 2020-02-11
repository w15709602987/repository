package zuikecheng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zuikecheng.bean.Test;
import zuikecheng.dao.TestDao;

import java.util.List;

@Service
public class TestService {
    @Autowired
    TestDao testDao;

    public void sendTest(String[] ids) {
        testDao.delTest(ids);
    }

    public List<Test> findTest() {
        return testDao.findTest();
    }
}
