package com.yr.Mybatis;

import com.yr.PoJo.Order;
import com.yr.PoJo.OrderUser;
import com.yr.PoJo.QueryVo;
import com.yr.PoJo.User;
import com.yr.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UserMapperTest {

    private UserMapper UserMapper;
    private SqlSession sqlSession;

    @Before
    public void  before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        this.sqlSession = factory.openSession();
        this.UserMapper  = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void  testFindUserByUsername(){
        QueryVo vo = new QueryVo();
        User user1 = new User();
        user1.setUsername("王");
        vo.setUser(user1);
        List<User> list = UserMapper.testFindUserByUsername(vo);
        for (User user : list) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void  queryUserByWhere(){

        User user1 = new User();
        user1.setUsername("王");
        List<User> list = UserMapper.queryUserByWhere(user1);
        for (User user : list) {
            System.out.println(user);
        }
        sqlSession.close();

    }
    @Test
    public void  queryUserByIds(){
        QueryVo vo = new QueryVo();
        List<Integer> queryVos=new ArrayList<Integer>();
        queryVos.add(31);
        queryVos.add(32);
        queryVos.add(33);
        vo.setIds(queryVos);
        List<User> list = UserMapper.queryUserByIds(vo);
        for (User user : list) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void  queryOrderUser(){
        List<OrderUser> users = UserMapper.queryOrderUser();
        for (OrderUser user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void  queryOrderUserResultMap(){
        List<Order> users = UserMapper.queryOrderUserResultMap();
        for (Order user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void  queryUserOrder(){
        List<User> users = UserMapper.queryUserOrder();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
