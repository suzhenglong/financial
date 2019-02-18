package com.suzl.seller;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @Description:
 * @author: zhenglongsu@163.com
 * @date: 2018.08.27 19:53
 */
@Component
public class HazelcastMapTest {

    @Autowired
    private HazelcastInstance hazelcastInstance;

    //@PostConstruct
    public void put() {
        Map map = hazelcastInstance.getMap("suzl");
        map.put("name", "suzl");
        map.put("uppdb", "准生产");
    }
}
