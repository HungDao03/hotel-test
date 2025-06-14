package com.hoteltest.service.user;

import com.hoteltest.model.User;
import com.hoteltest.service.IGenericService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface IUserService extends IGenericService<User> {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
