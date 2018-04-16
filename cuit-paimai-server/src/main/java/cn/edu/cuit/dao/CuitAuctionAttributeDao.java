package cn.edu.cuit.dao;

import cn.edu.cuit.model.CuitAuctionAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 商品描述表
 * @author sunshixiong on 2018/01/30.
 */
public interface CuitAuctionAttributeDao extends JpaRepository<CuitAuctionAttribute,Integer>{

    /**
     * 通过商品id查找
     * @param commdoityId
     * @return
     */
    public CuitAuctionAttribute findByCuitCommodityId(String commdoityId);
}