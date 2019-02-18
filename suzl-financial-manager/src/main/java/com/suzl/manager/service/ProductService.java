package com.suzl.manager.service;

import com.suzl.entity.Product;
import com.suzl.entity.enums.ProductStatus;
import com.suzl.manager.error.ErrorEnum;
import com.suzl.manager.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:产品服务
 * @author: zhenglongsu@163.com
 * @date: 2018.08.21 17:07
 */
@Service
public class ProductService {

    private static Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    /**
     * 创建产品
     *
     * @param product
     * @return
     */
    public Product addProduct(Product product) {
        log.debug("创建产品,参数:{}", product);
        //数据校验
        checkProduct(product);

        //设置默认值
        setDefault(product);
        Product result = productRepository.save(product);
        log.debug("创建产品,结果:{}", result);
        return result;
    }

    /**
     * 设置默认值
     * 1.创建时间,更新时间
     * 2.投资步长,锁定期,状态
     *
     * @param product
     */
    private void setDefault(Product product) {
        if (product.getCreateAt() == null) {
            product.setCreateAt(new Date());
        }
        if (product.getUpdateAt() == null) {
            product.setUpdateAt(new Date());
        }
        if (product.getStepAmount() == null) {
            product.setStepAmount(BigDecimal.ZERO);
        }
        if (product.getLockTerm() == null) {
            product.setLockTerm(0);
        }
        if (product.getStatus() == null) {
            product.setStatus(ProductStatus.AUDITING.name());
        }
    }

    /**
     * 产品数据校验:
     * 1.非空数据
     * 2.收益率要在0~30之内
     * 3.投资步长需为整数
     *
     * @param product
     */
    private void checkProduct(Product product) {
        Assert.notNull(product.getId(), ErrorEnum.ID_NOT_NULL.getCode());
        //其他非空校验
        //此方法，如果BigDecimal为小于val返回-1，如果BigDecimal为大于val返回1，如果BigDecimal为等于val返回0,
        Assert.isTrue(BigDecimal.ZERO.compareTo(product.getRewardRate()) < 0 && BigDecimal.valueOf(30).compareTo(product.getRewardRate()) >= 0, ErrorEnum.REWARDRATE_RANGE.getCode());

        Assert.isTrue(BigDecimal.valueOf(product.getStepAmount().longValue()).compareTo(product.getStepAmount()) == 0, ErrorEnum.STEPAMOUNT_INT.getCode());

    }


    /**
     * 查询单个产品
     *
     * @param id
     * @return
     */
    public Product findOne(String id) {
        Assert.notNull(id, "需要产品编号参数");
        log.debug("查询单个产品,编号参数id={}", id);

        Product result = productRepository.findById(id).orElse(null);
        log.debug("查询单个产品,结果:{}", result);
        return result;
    }

    /**
     * 分页查询产品
     *
     * @param idList
     * @param minRewardRate
     * @param maxRewardRate
     * @param statusList
     * @param pageable
     * @return
     */
    public Page<Product> query(List<String> idList, BigDecimal minRewardRate, BigDecimal maxRewardRate, List<String> statusList, Pageable pageable) {
        log.debug("查询产品,idList={},minRewardRate={},maxRewardRate={},statusList={},pageable={}", idList, minRewardRate, maxRewardRate, statusList, pageable);
        Specification<Product> spec = new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //获取对应的列
                Expression<String> idCol = root.get("id");
                Expression<BigDecimal> rewardRateCol = root.get("rewardRate");
                Expression<String> statusCol = root.get("status");
                List<Predicate> predicates = new ArrayList<>();
                if (idList != null && idList.size() > 0) {
                    predicates.add(idCol.in(idList));
                }
                if (minRewardRate != null && BigDecimal.ZERO.compareTo(minRewardRate) < 0) {
                    predicates.add(cb.ge(rewardRateCol, minRewardRate));
                }
                if (maxRewardRate != null && BigDecimal.ZERO.compareTo(maxRewardRate) < 0) {
                    predicates.add(cb.le(rewardRateCol, maxRewardRate));
                }
                if (statusList != null && statusList.size() > 0) {
                    predicates.add(statusCol.in(statusList));
                }
                query.where(predicates.toArray(new Predicate[0]));

                return null;
            }
        };
        Page<Product> page = productRepository.findAll(spec, pageable);
        log.debug("查询产品,结果={}", page);
        return page;
    }
}
