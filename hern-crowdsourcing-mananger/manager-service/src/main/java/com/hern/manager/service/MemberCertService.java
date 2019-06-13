package com.hern.manager.service;

import com.hern.manager.bean.TMemberCert;

import java.util.List;

public interface MemberCertService {

    List<TMemberCert> getCertsByTicketId(String processInstanceId);

}
