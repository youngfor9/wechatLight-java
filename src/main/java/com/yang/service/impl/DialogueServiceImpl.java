package com.yang.service.impl;

import com.yang.dao.AnswerMapper;
import com.yang.dao.DialogueInfoMapper;
import com.yang.entity.AnswerInfo;
import com.yang.entity.DialogueInfo;
import com.yang.service.DialogueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class DialogueServiceImpl implements DialogueService {
    @Resource
    private DialogueInfoMapper dialogueDao;
    @Resource
    private AnswerMapper answerMapper;

    //[
    //    {
    //        "info":{
    //
    //        },
    //        "ans":[
    //
    //        ]
    //    }
    //]
    @Override
    public Object[] getDialogueInfos(Integer num) {
        //随机获取内容
        List<DialogueInfo> dialogueInfos = null;
        Object[] res = new Object[num];
        try {
            dialogueInfos = this.dialogueDao.selectRankInfos(num);
            List<AnswerInfo> answerInfos = answerMapper.selectRankInfos(num*2);
            Long[] ids = new Long[num];
            for (int i = 0; i < num; i++) {
                DialogueInfo dialogueInfo = dialogueInfos.get(i);
                ids[i] =dialogueInfo.getaId();
            }
            List<AnswerInfo> answers  = answerMapper.selectInfos(ids);
            Random random = new Random();
            Map<String,Object> ansMap = new HashMap<String,Object>();
            Set<AnswerInfo> ansSet = new HashSet<>();
            for (int i = 0; i < num; i++) {
                DialogueInfo dialogueInfo = dialogueInfos.get(i);
                //set中装进3个选项
                while (ansSet.size() > 2) {
                    int randomNum = random.nextInt(num);
                    AnswerInfo answerInfo = answerInfos.get(randomNum);
                    Long aId = answerInfo.getId();
                    if (aId != dialogueInfo.getaId() && !ansSet.contains(answerInfo)) {
                        ansSet.add(answerInfo);
                    }
                }
                ansSet.add(answers.get(i));
                ansMap.put("ans",ansSet);
                ansMap.put("info",dialogueInfo);
                res[i] =ansMap;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public DialogueInfo selectDialogueById(Long did) {
        DialogueInfo dialogueInfo = null;
        try {
            dialogueInfo = this.dialogueDao.selectByPrimaryKey(did);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dialogueInfo;
    }
}
