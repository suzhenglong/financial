package org.springframework.data.repository.config;

import java.lang.annotation.*;

/**
 * @Description:repository bean 名称的前缀  参考 EnableJpaRepositories
 * @author: zhenglongsu@163.com
 * @date: 2018.08.29 16:11
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface RepositoryBeanNamePrefix {
    String value();
}