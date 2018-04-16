package cn.edu.cuit.dao;

import cn.edu.cuit.model.CuitAnnouncement;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sunshixiong
 * @date 2018/4/16 22:00
 */
public interface CuitFormDao extends JpaRepository<CuitAnnouncement,Integer> {
}
