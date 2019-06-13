package com.hern.manager.service;

import com.hern.manager.bean.TAdvertisement;

import java.util.List;

public interface AdvertisService {

    boolean addAdver(TAdvertisement advertisement);

    List<TAdvertisement> getAll();

    

}
