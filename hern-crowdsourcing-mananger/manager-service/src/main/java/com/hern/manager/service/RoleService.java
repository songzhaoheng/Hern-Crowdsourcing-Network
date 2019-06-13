package com.hern.manager.service;

import java.util.List;
import com.hern.manager.bean.TRole;

public interface RoleService {

    List<TRole> getAllRole();

    List<TRole> getUserRole(Integer userId);

}
