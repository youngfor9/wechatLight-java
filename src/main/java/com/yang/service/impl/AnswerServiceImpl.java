package com.yang.service.impl;

import com.yang.dao.AnswerMapper;
import com.yang.entity.AnswerInfo;
import com.yang.service.AnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Resource
    private AnswerMapper answerDao;

    @Override
    public List<AnswerInfo> getAnsInfos(Long[] ids) {
        return answerDao.selectInfos(ids);
    }
}
