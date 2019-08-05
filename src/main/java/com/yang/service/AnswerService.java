package com.yang.service;

import com.yang.entity.AnswerInfo;

import java.util.List;

public interface AnswerService {
    public List<AnswerInfo> getAnsInfos(Long[] ids) ;
}
