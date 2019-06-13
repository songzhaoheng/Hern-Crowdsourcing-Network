package com.hern.manager.service.impl;

import java.util.List;

import com.hern.manager.bean.TAccountTypeCert;
import com.hern.manager.dao.TAccountTypeCertMapper;
import com.hern.manager.service.CertTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertTypeServiceImpl implements CertTypeService {
    
    @Autowired
    TAccountTypeCertMapper mapper;

    @Override
    public List<TAccountTypeCert> getAll() {
        // TODO Auto-generated method stub
        return mapper.selectByExample(null);
    }

}
