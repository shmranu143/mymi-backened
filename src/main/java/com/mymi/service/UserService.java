package com.mymi.service;

import com.mymi.dao.UserRepo;
import com.mymi.model.MyUserDetails;
import com.mymi.model.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo repo;

    public MyUserDetails getUserDetailsByUserName(String userName){
        Optional<TUser> User = repo.findByUserName(userName);
//        return new MyUserDetails(User.get());
        return User.map(MyUserDetails::new).get();
    }
}
