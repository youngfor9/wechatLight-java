package com.yang.service.impl;

import com.yang.dao.DialogueInfoMapper;
import com.yang.entity.DialogueInfo;
import com.yang.service.DialogueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DialogueServiceImpl  implements DialogueService {
    @Resource
    private DialogueInfoMapper dialogueDao;
    @Override
    public List<DialogueInfo> getDialogueInfos() {
        List<DialogueInfo> dialogueInfos =null;
        try {
            // dialogueInfos = this.dialogueDao.selectByPrimaryKey();
        }catch (Exception e){
            e.printStackTrace();
        }
        return dialogueInfos;
    }
    @Override
    public DialogueInfo  selectDialogueById(Long did) {
        DialogueInfo dialogueInfo =null;
        try {
            dialogueInfo = this.dialogueDao.selectByPrimaryKey(did);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dialogueInfo;
    }
}
