package com.hern.manager.service.impl;

import com.hern.manager.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImple implements TokenService {

    @Autowired
    TUserTokenMapper tokenMapper;

    @Override
    public boolean saveToken(TUserToken tBean) {
        int insertSelective = tokenMapper.insertSelective(tBean);
        return insertSelective > 0;
    }

}
