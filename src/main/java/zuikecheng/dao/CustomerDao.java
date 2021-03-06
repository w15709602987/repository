package zuikecheng.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import zuikecheng.bean.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CustomerDao {
//    @Select("select * from customer")
//    List<Customer> findCustomer();

    @Select("select * from customer where ${conditionName} like concat('%',#{conditionValue},'%') order by ${orderByMethod} desc limit #{pageNum1},#{pageSize}")
    List<Customer> CodAndPageQueCustomer(@Param("pageNum1")int pageNum1,@Param("pageSize")int pageSize,@Param("conditionName") String conditionName,@Param("conditionValue")String conditionValue,@Param("orderByMethod")String orderByMethod);

    @Select("select count(*) from customer where #{conditionName} like concat('%',#{conditionValue})")
    int findCount(@Param("conditionName")String conditionName,@Param("conditionValue")String conditionValue);

    @Select("select * from customer where id=#{id}")
    Customer customerLook(String id);

    @Insert("insert into customer values(#{customer.id},#{customer.customername},#{customer.companyname},#{customer.addtime},#{customer.modtime},#{customer.cellphone},#{customer.companyaddress},#{customer.landline},#{customer.introduction},#{customer.remarks})")
    void addCustomer(@Param("customer") Customer customer);

    @Delete("<script>\n" +
            "         delete from customer where id in\n" +
            "        <foreach collection=\"ids\" index=\"index\" item=\"item\" open=\"(\" separator=\",\" close=\")\">\n" +
            "                #{item}       \n" +
            "        </foreach>    \n" +
            "</script>")
    void delCustomer(@Param("ids")String[] ids);

    @Update("update customer set customername= #{customer.customername},companyname= #{customer.companyname},companyaddress= #{customer.companyaddress},cellphone= #{customer.cellphone},landline= #{customer.landline},introduction= #{customer.introduction},remarks= #{customer.remarks},modtime= #{customer.modtime} where id=#{id} ")
    void updateCustomer(@Param("customer") Customer customer,@Param("id") String id);

    @Insert("<script> \n" +
            "        insert into customer(customername,companyname,addtime,modtime,cellphone,companyaddress,landline,introduction,remarks) values " +
            "        <foreach collection=\"customerList\" index=\"index\" item=\"customer\"  separator=\",\" > " +
            "        (#{customer.customername,jdbcType=VARCHAR},#{customer.companyname,jdbcType=VARCHAR},#{customer.addtime,jdbcType=DATE},#{customer.modtime,jdbcType=DATE},#{customer.cellphone,jdbcType=VARCHAR},#{customer.companyaddress,jdbcType=VARCHAR},#{customer.landline,jdbcType=VARCHAR},#{customer.introduction,jdbcType=VARCHAR},#{customer.remarks,jdbcType=VARCHAR})" +
            "        </foreach> \n" +
            "</script>")
    void addMany(@Param("customerList")List<Customer> customerList);
}
// order By orderByMethod=#{orderByMethod}@Param("ids")(#{customer.customername},#{customer.companyname},#{customer.addtime},#{customer.modtime},#{customer.cellphone},#{customer.companyaddress},#{customer.landline},#{customer.introduction},#{customer.remarks}
//        customer.setId(1);
//        customer.setCustomername("wei");
//        customer.setCompanyname("123");
//        customer.setAddtime(new Date(2020 - 1 - 9));
//        customer.setModtime(new Date(2020 - 1 - 9));
//        customer.setCellphone("1008611");
//        customer.setCompanyaddress("瀹忕¦忚嫅");
//        customer.setLandline("1212");
//        customer.setIntroduction("鐣¥");
//        customer.setRemarks("鐣¥");
//        return customer;
//@Select("select * from customer where id=#{id}")
//    public Customer findCustomer(Customer customer);}(id,customername,companyname,addtime,modtime,cellphone,companyaddress,landline,intruction,remarks)

/*
    //添加客户的数据库操作
    public void addCustomer(Customer customer) {
        QueryRunner queryRunner = new QueryRunner(C3P0UTil.getDataSource());
        String sql = "insert into customer values(?,?,?,?,?,?,?,?,?,?)";
        Object[] obj = {customer.getId(), customer.getCustomername(), customer.getCompanyname(), customer.getAddtime()
                , customer.getModtime(), customer.getCellphone(), customer.getCompanyaddress(), customer.getLandline(), customer.getIntroduction()
                , customer.getRemarks()};
        try {
            queryRunner.update(sql, obj);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    //条件、分页查询时的数据库操作！
    public List<Customer> CodAndPageQueUser(int start, int pageSize, String conditionName, String conditionValue, String orderByMethod) {


        String sql = "select * from customer where " + conditionName + " like ? order By " + orderByMethod + " desc limit ?,?";
        Object[] args = {"%" + conditionValue + "%", start, pageSize};
        QueryRunner queryRunner = new QueryRunner(C3P0UTil.getDataSource());
        try {
            List<Customer> List = queryRunner.query(sql, new BeanListHandler<>(Customer.class), args);
            return List;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);//转换为运行时期异常抛出
        }
    }


    //查询总的记录条数客户信息表的
    public int findCount(String conditionName, String conditionValue) {
        String sql = "select count(*) from customer where " + conditionName + " like ?";
        Object[] args = {"%" + conditionValue + "%"};
        QueryRunner queryRunner = new QueryRunner(C3P0UTil.getDataSource());
        try {
            long totalCount = (Long) queryRunner.query(sql, new ScalarHandler(1), args);
            return (int) totalCount;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);//转换为运行时期异常抛出
        }
    }


    //删除客户操作数据库
    public void delCustomer(String[] ids) {

        QueryRunner queryRunner = new QueryRunner(C3P0UTil.getDataSource());
        for (String s : ids

        ) {
            try {
                queryRunner.update("delete from customer where id= ?", s);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);//转换为运行时期异常抛出
            }
        }
    }


    //修改时查询数据库
    public Customer customerEdit(String id) {
        QueryRunner queryRunner = new QueryRunner(C3P0UTil.getDataSource());
        String sql = "select * from customer where id= ?";
        Object[] args = {id};
        try {
            Customer customer = queryRunner.query(sql, new BeanHandler<>(Customer.class), args);
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);//转换为运行时期异常抛出
        }
    }

    //更新数据库中的数据，即修改客户信息
    public void updateCustomer(Customer customer, String id) {
        QueryRunner queryRunner = new QueryRunner(C3P0UTil.getDataSource());
        /* String sql = "update user set name=?,gender=?,birthday=?,cellphone=?,email=?,hobby=?,type=?,description=? where id=?";*/
 /*       String sql = "update customer set customername= ?,companyname= ?,companyaddress= ?,cellphone= ?,landline= ?,introduction= ?,remarks= ?,modtime= ? where id= ?";
        Object[] args = {customer.getCustomername(), customer.getCompanyname(), customer.getCompanyaddress(),
                customer.getCellphone(), customer.getLandline()
                , customer.getIntroduction(), customer.getRemarks(), customer.getModtime(), id};
        try {
            queryRunner.update(sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);//转换为运行时期异常抛出
        }
    }

    //导出Excel时查询数据库！
    public List<Customer> finCustomer(String conditionname, String conditionValue, String orderByMethod) {
        QueryRunner queryRunner = new QueryRunner(C3P0UTil.getDataSource());
        String sql = "select * from customer where " + conditionname + " like ? order By " + orderByMethod + " desc";

        Object[] args = {"%" + conditionValue + "%"};
        try {
            List<Customer> List = queryRunner.query(sql, new BeanListHandler<>(Customer.class), args);
            return List;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);//转换为运行时期异常抛出
        }
    }   */