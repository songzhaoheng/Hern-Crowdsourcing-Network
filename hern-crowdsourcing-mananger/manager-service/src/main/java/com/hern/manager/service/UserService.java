package com.hern.manager.service;

import java.util.List;
import com.hern.manager.bean.TUser;
import com.hern.manager.bean.TUserExample;


public interface UserService {

    boolean register(TUser user);

    TUser login(TUser user);

    //查询所有用户
    List<TUser> getAll();

    List<TUser> getAllByCondition(TUserExample example);

    void deleteBatchOrSingle(String ids);

}
