package com.yang.dao;

import com.yang.entity.DialogueInfo;

import java.util.List;

public interface DialogueInfoMapper  {
    int deleteByPrimaryKey(Long dId);

    int insert(DialogueInfo record);

    int insertSelective(DialogueInfo record);

    DialogueInfo selectByPrimaryKey(Long dId);

    int updateByPrimaryKeySelective(DialogueInfo record);

    int updateByPrimaryKey(DialogueInfo record);

    List<DialogueInfo> selectRankInfos(Integer num);
}