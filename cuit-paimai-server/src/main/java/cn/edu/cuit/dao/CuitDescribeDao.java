package cn.edu.cuit.dao;


import cn.edu.cuit.model.CuitDescribe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ApplicationPower.
 * @author sunshixiong on 2018/01/30.
 */
public interface CuitDescribeDao extends JpaRepository<CuitDescribe,Integer> {

    public List<CuitDescribe> findByCuitCommodityId(Integer id);
}