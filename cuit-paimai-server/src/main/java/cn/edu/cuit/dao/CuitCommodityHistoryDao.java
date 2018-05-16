package cn.edu.cuit.dao;

import cn.edu.cuit.model.CuitCommodityHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sunshixiong
 * @date 2018/5/14 15:16
 */
public interface CuitCommodityHistoryDao extends JpaRepository<CuitCommodityHistory,Integer> {
}
