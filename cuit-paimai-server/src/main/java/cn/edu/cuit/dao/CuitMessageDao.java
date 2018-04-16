package cn.edu.cuit.dao;

import cn.edu.cuit.model.CuitMessage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ApplicationPower.
 * @author sunshixiong on 2018/01/30.
 */
public interface CuitMessageDao extends JpaRepository<CuitMessage,Integer> {

}