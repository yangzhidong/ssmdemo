package com.yes.dl.shop.db.mapper;

import com.yes.dl.shop.db.domain.VO.FirstModule;
import com.yes.dl.shop.db.domain.VO.SecondModule;

import java.util.List;
import java.util.Map;

public interface IndexMapper {

    List<Map<String, Object>> findFirstAndSecondModule();
}
