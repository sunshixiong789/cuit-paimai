package cn.edu.cuit.dao;

import cn.edu.cuit.model.CuitFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sunshixiong
 * @date 2018/4/30 15:52
 */
public interface CuitFeedbackDao extends JpaRepository<CuitFeedback,Integer> {
}
