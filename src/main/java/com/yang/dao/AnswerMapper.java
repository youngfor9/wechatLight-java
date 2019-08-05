package com.yang.dao;

import com.yang.entity.AnswerInfo;

import java.util.List;

public interface AnswerMapper {

    List<AnswerInfo> selectRankInfos(Integer num);

    List<AnswerInfo> selectInfos(Long[] ids);
}
