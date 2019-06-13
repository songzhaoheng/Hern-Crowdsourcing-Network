package com.hern.manager.service.impl;

import com.hern.manager.bean.TRole;
import com.hern.manager.dao.TRoleMapper;
import com.hern.manager.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    TRoleMapper roleMapper;

    @Override
    public List<TRole> getAllRole() {
        // TODO Auto-generated method stub

        return  roleMapper.selectByExample(null);
    }

    @Override
    public List<TRole> getUserRole(Integer userId) {
        // TODO Auto-generated method stub
        return roleMapper.getUserRole(userId);
    }

}
