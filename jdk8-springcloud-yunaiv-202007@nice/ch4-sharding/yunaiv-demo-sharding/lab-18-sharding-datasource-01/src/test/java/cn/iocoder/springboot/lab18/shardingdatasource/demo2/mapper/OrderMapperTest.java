package cn.iocoder.springboot.lab18.shardingdatasource.demo2.mapper;

import cn.iocoder.springboot.lab18.shardingdatasource.demo2.Application;
import cn.iocoder.springboot.lab18.shardingdatasource.demo2.dataobject.OrderDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testInsert() {
        OrderDO order = new OrderDO();
        order.setUserId(1);
        orderMapper.insert(order);
        Assert.assertNotNull(order.getId());
    }

    @Test
    public void testSelectById() {
        OrderDO order = orderMapper.selectById(1);

        Assert.assertNull(order);
    }

    @Test
    public void testSelectListByUserId() {
        List<OrderDO> orders = orderMapper.selectListByUserId(1);
//        System.out.println(orders.size());
        Assert.assertEquals(1, orders.size());
    }



}
