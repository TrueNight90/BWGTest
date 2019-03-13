package org.yjr.login.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.yjr.login.entity.User;

import java.util.Optional;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public User find(User user){
        User userReturn = null;
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnorePaths("id");
        Example<User> example = Example.of(user,exampleMatcher);
        Optional<User> opt = userRepository.findOne(example);
        if(opt.isPresent()){
            userReturn = opt.get();
        }
        return userReturn;
    }
}
