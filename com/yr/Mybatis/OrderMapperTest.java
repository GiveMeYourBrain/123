package com.yr.Mybatis;

import com.yr.PoJo.Order;
import com.yr.mapper.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OrderMapperTest {

    private OrderMapper OrderMapper;


    @Before
    public void  before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        OrderMapper  = session.getMapper(OrderMapper.class);
    }

    @Test
    public void queryOrderAll(){
        List<Order> orders = OrderMapper.queryOrderAll();
        for (Order order : orders) {
            System.out.println(order);
        }

    }
}
