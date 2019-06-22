package com.hemika.service;


import com.hemika.model.UserDtoData;
import com.hemika.repository.CreateUserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;

@Service
public class HashPasswordSer {
    private CreateUserRep userData;
    private SecurityManager securityManager;

    @Autowired
    public HashPasswordSer(
            CreateUserRep userData,
            SecurityManager securityManager) {
        this.securityManager = securityManager;
        //this.userData = userData;
    }
    public String hashPassword(UserDtoData userData) throws Exception {
        String hashedPassword = securityManager.dm5Hash(userData.getPassword());
        //String hashedConfirmPassword = securityManager.dm5Hash(data.getConfirmPassword());
        return hashedPassword;
    }
    public String hashConfirmPassword(UserDtoData userData) throws Exception {
        //String hashedPassword = securityManager.dm5Hash(data.getPassword());
        String hashedConfirmPassword = securityManager.dm5Hash(userData.getConfirmPassword());
        return hashedConfirmPassword;
    }



}




