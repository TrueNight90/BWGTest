package org.yjr.login.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.yjr.login.entity.User;
import org.yjr.login.entity.UserDetailsImpl;

@Component
public class AppUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(AppUserDetailsService.class);

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = new User();
        user.setUsername(s);
        User userInfo = userService.find(user);
        logger.info("username="+userInfo.getUsername());
        UserDetailsImpl userDetails = null;
        if(null!=userInfo){
            String roles = "";
            if (userInfo.getUsername().equals("sephiroth")){
                roles = "ROLE_ADMIN";
            }else{
                roles = "ROLE_USER";
            }
            userDetails = new UserDetailsImpl(userInfo.getUsername(),new BCryptPasswordEncoder().encode(userInfo.getPassword()), AuthorityUtils.commaSeparatedStringToAuthorityList(roles));
            //userDetails = new UserDetailsImpl(userInfo.getUsername(),userInfo.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        }
        //user = new User(s,"a65146002", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return userDetails;
    }
}
