package cn.edu.cuit.service.impl;

import cn.edu.cuit.dao.CuitAdminDao;
import cn.edu.cuit.model.CuitAdmin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author sunshixiong
 * @date 2018/2/28 16:58
 */
@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CuitAdminDao cuitAdminDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     *自定义用户登录认证（AuthorityUtils.commaSeparatedStringToAuthorityList())赋予权限）
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CuitAdmin user = cuitAdminDao.findByName(username);
        String password = user.getPassWord();
        return new User(username,password,true,true,true,true, AuthorityUtils.commaSeparatedStringToAuthorityList(user.getType()+",ROLE_USER"));
    }
}
