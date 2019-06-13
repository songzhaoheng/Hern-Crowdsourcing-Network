package com.hern.manager.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hern.commons.MD5Util;
import com.hern.commons.StringUtils;
import com.hern.manager.bean.TUser;
import com.hern.manager.bean.TUserExample;
import com.hern.manager.dao.TRoleMapper;
import com.hern.manager.dao.TUserMapper;
import com.hern.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    TUserMapper userMapper;
    @Autowired
    TRoleMapper roleMapper;

    /**
     * 注册用户方法
     */
    @Override
    public boolean register(TUser user) {
        // user好多属性数据库默认不能为空
        // 1、拿到用户信息，先加密密码
        // 第一个参数是我们加密的密码，第二个参数是盐值
        //

        // String crypt = Md5Crypt.md5Crypt(user.getUserpswd().getBytes());
        String digest = MD5Util.digest(user.getUserpswd());
        System.out.println(digest);
        user.setUserpswd(digest);

        // 2、在将用户的其他信息设置默认值
        // 设置昵称、创建时间(String)等
        user.setUsername(user.getLoginacct());

        user.setCreatetime(StringUtils.formatSimpleDate(new Date()));
        // 3、去数据库保存用户；
        int i = 0;
        try {
            i = userMapper.insertSelective(user);
        } catch (Exception e) {
            // 保存失败的原因就是用户重复
            System.out.println(e);
            return false;
        }

        return i == 1 ? true : false;

    }

    @Override
    public TUser login(TUser user) {
        // 1、拿到用户名和密码

        // 2、去数据库查询是否存在
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        // 设置查询条件
        criteria.andLoginacctEqualTo(user.getLoginacct());
        criteria.andUserpswdEqualTo(MD5Util.digest(user.getUserpswd()));
        // 可能会查询多个用户
        List<TUser> list = null;
        try {
            list = userMapper.selectByExample(example);
        } catch (Exception e) {
            System.out.println(e);
        }

        return list.size() == 1 ? list.get(0) : null;
    }

    @Override
    public List<TUser> getAll() {

        return userMapper.selectByExample(null);
    }

    @Override
    public List<TUser> getAllByCondition(TUserExample example) {
        // TODO Auto-generated method stub
        return userMapper.selectByExample(example);
    }

    @Override
    public void deleteBatchOrSingle(String ids) {
        // TODO Auto-generated method stub
        if (ids.contains(",")) {
            String[] split = ids.split(",");
            List<Integer> list = new ArrayList<Integer>();
            for (String s : split) {
                int i = 0;
                try {
                    i = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                }
                list.add(i);
            }

            TUserExample example = new TUserExample();
            TUserExample.Criteria criteria = example.createCriteria();
            //删除id所在的集合
            criteria.andIdIn(list);
            userMapper.deleteByExample(example);
        }else{
            userMapper.deleteByPrimaryKey(Integer.parseInt(ids));
        }
    }

}
