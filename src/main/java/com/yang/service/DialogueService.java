package com.yang.service;

import com.yang.entity.DialogueInfo;

import java.util.List;

public interface DialogueService {
    /**
     * 获取全部的台词
     */
    public List<DialogueInfo> getDialogueInfos();
}
