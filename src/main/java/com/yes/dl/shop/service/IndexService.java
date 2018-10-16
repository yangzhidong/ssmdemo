package com.yes.dl.shop.service;

import com.yes.dl.shop.db.domain.VO.FirstModule;
import com.yes.dl.shop.db.domain.VO.SecondModule;

import java.util.List;

public interface IndexService {

    List<FirstModule> findFirstAndSecondModule();


}
