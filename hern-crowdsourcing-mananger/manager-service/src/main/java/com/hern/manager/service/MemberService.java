package com.hern.manager.service;

import com.hern.manager.bean.TMemeber;

public interface MemberService {

    TMemeber getMemberByTicket(String processInstanceId);

}
