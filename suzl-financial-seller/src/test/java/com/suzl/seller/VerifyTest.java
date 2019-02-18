package com.suzl.seller;

/**
 * @Description:
 * @author: zhenglongsu@163.com
 * @date: 2018.08.28 20:27
 */

import com.suzl.seller.repository.OrderRepository;
import com.suzl.seller.service.VerifyService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * 对账测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VerifyTest {
    @Autowired
    private VerifyService verifyService;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    @Qualifier("backupOrderRepository")
    private OrderRepository backOrderRepository;

    @Autowired
    @Qualifier("readorderRepository")
    private OrderRepository readOrderRepository;

    @Test
    public void makeVerificationTest() {
        Date day = new GregorianCalendar(2018, 7, 28).getTime();
        System.out.println(day);
        File file = verifyService.makeVerificationFile("111", day);
        System.out.println(file.getAbsolutePath());
    }

    @Test
    public void saveVerificationOrders() {
        Date day = new GregorianCalendar(2018, 7, 28).getTime();
        verifyService.saveChanOrders("111", day);
    }

    @Test
    public void verifyOrder() {
        Date day = new GregorianCalendar(2018, 7, 28).getTime();
        List<String> verifyOrder = verifyService.verifyOrder("111", day);
        System.out.println(String.join(",", verifyOrder));
    }

    @Test
    public void queryOrder() {
        System.out.println(orderRepository.findAll());
        System.out.println(backOrderRepository.findAll());
        System.out.println(readOrderRepository.findAll());

    }
}


