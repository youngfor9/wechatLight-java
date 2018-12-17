package com.yang.service.impl;

import com.yang.dao.DialogueDao;
import com.yang.entity.DialogueInfo;
import com.yang.service.DialogueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DialogueServiceImpl  implements DialogueService {
    @Resource
    private DialogueDao dialogueDao;
    @Override
    public List<DialogueInfo> getDialogueInfos() {
        List<DialogueInfo> dialogueInfos =null;
        try {
             dialogueInfos = this.dialogueDao.getDialogueInfos();
        }catch (Exception e){
            e.printStackTrace();
        }
        return dialogueInfos;
    }
}
