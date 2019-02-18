package com.suzl.manager;

import com.suzl.entity.Product;
import com.suzl.entity.enums.ProductStatus;
import org.junit.Test;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * @Description:
 * @author: zhenglongsu@163.com
 * @date: 2018.08.21 20:54
 */
public class ManagerTest {

    @Test
    public void testBigDecimal() {
        Product product = new Product();
        product.setStepAmount(new BigDecimal(23));
        System.out.println(BigDecimal.valueOf(product.getStepAmount().longValue()));
        System.out.println(product.getStepAmount());
        System.out.println(BigDecimal.valueOf(product.getStepAmount().longValue()).compareTo(product.getStepAmount()) == 0);
        Assert.isTrue(BigDecimal.valueOf(product.getStepAmount().longValue()).compareTo(product.getStepAmount()) == 0, "投资步长需要调整为整数");

        System.out.println(ProductStatus.AUDITING.name());
        System.out.println(ProductStatus.AUDITING.getDesc());

        System.out.println("create".hashCode());

    }


    @Test
    public void testString() throws Exception {
        ArrayList list = new ArrayList(Arrays.asList("1", "2", "3", "4"));
        String s = null;
        System.out.println(list.contains("1"));
        System.out.println(list.contains("7"));
        System.out.println(list.contains(""));
        System.out.println(list.contains(s));
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDDhhmmss");
        String s1 = sdf.format(new Date());
        System.out.println(s1);

        Date date = sdf.parse(s1);
        System.out.println(date);
        String dateString = "20191128175545";
        Date date1 = sdf.parse(dateString);
        System.out.println(date1);
        System.out.println(date.compareTo(date1));
        System.out.println(new Date().compareTo(sdf.parse("20171128175545"))!=-1);

    }

}
