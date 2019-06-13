package com.hern.manager.service.impl;

import com.hern.manager.bean.TUserRole;
import com.hern.manager.bean.TUserRoleExample;
import com.hern.manager.dao.TUserRoleMapper;
import com.hern.manager.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    TUserRoleMapper userRoleMapper;

    @Override
    public void addRole(String ids, Integer userId) {
        // TODO Auto-generated method stub
        // 如果没有 包含，直接添加

        if (ids.contains(",")) {
            String[] split = ids.split(",");
            for (String rid : split) {
                // 创建一个中间表的数据对象
                TUserRole role = new TUserRole();
                int i = Integer.parseInt(rid);
                role.setRoleid(i);
                role.setUserid(userId);
                userRoleMapper.insertSelective(role);
            }
        } else {
            TUserRole role = new TUserRole();
            int i = Integer.parseInt(ids);
            role.setRoleid(i);
            role.setUserid(userId);
            userRoleMapper.insertSelective(role);
        }
    }

    @Override
    public void removeRole(String ids, Integer userId) {
        // TODO Auto-generated method stub
        if (ids.contains(",")) {
            String[] split = ids.split(",");
            for (String rid : split) {
                int i = Integer.parseInt(rid);

                TUserRoleExample example = new TUserRoleExample();
                TUserRoleExample.Criteria criteria = example.createCriteria();
                criteria.andRoleidEqualTo(i);
                criteria.andUseridEqualTo(userId);
                userRoleMapper.deleteByExample(example);
            }
        } else {
            int i = Integer.parseInt(ids);
            TUserRoleExample example = new TUserRoleExample();
            TUserRoleExample.Criteria criteria = example.createCriteria();
            criteria.andRoleidEqualTo(i);
            criteria.andUseridEqualTo(userId);
            userRoleMapper.deleteByExample(example);
        }
    }

}
