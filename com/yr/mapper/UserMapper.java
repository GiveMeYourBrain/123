package com.yr.mapper;

import com.yr.PoJo.Order;
import com.yr.PoJo.OrderUser;
import com.yr.PoJo.QueryVo;
import com.yr.PoJo.User;

import java.util.List;

public interface UserMapper {
    //四大原则
    //接口的返回值要与Mapper文件中的返回值类型保持一致
    //接口的方法名要与Mapper文件中的statementId保持一致
    //接口的方法形参的数据类型要与Mapper文件 中的入参类型保持一致
    //接口的类路径名要与Mapper的namespace要保持一致

    List<User> testFindUserByUsername(QueryVo queryVo);

    List<User> queryUserByWhere(User user);

    List<User> queryUserByIds(QueryVo queryVo);

    List<OrderUser> queryOrderUser();

    List<User> queryUserOrder();

    List<Order> queryOrderUserResultMap();
}
