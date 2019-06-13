package com.hern.manager.service.impl;

import com.hern.manager.bean.TMemeber;
import com.hern.manager.dao.TMemeberMapper;
import com.hern.manager.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    TMemeberMapper memeberMapper;
    
    @Override
    public TMemeber getMemberByTicket(String processInstanceId) {
        // TODO Auto-generated method stub
        
        
        return memeberMapper.getMemberByTicket(processInstanceId);
    }

}
