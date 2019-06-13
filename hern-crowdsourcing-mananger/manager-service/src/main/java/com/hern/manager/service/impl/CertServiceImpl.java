package com.hern.manager.service.impl;

import java.util.List;

import com.hern.manager.bean.TCert;
import com.hern.manager.dao.TCertMapper;
import com.hern.manager.service.CertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertServiceImpl implements CertService {
    
    @Autowired
    TCertMapper certMapper;

    @Override
    public List<TCert> getAllCert() {
        // TODO Auto-generated method stub
        return certMapper.selectByExample(null);
    }

}
