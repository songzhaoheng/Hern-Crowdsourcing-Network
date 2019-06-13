package com.hern.manager.service.impl;

import java.util.List;

import com.hern.manager.bean.TMemberCert;
import com.hern.manager.dao.TMemberCertMapper;
import com.hern.manager.service.MemberCertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberCertServiceImpl implements MemberCertService {
    
    @Autowired
    TMemberCertMapper certMapper;

    @Override
    public List<TMemberCert> getCertsByTicketId(String processInstanceId) {
        
        return certMapper.getCertsByTicketId(processInstanceId);
    }

}
