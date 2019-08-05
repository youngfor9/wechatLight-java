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
            List<AnswerInfo> answerInfos = answerMapper.selectRankInfos(num*3);
            Long[] ids = new Long[num];
            for (int i = 0; i < num; i++) {
                DialogueInfo dialogueInfo = dialogueInfos.get(i);
                ids[i] =dialogueInfo.getaId();
            }
            List<AnswerInfo> answers  = answerMapper.selectInfos(ids);
            int aSize = answerInfos.size();
            Random random = new Random();
            for (int i = 0; i < num; i++) {
                Map<String,Object> ansMap = new HashMap<String,Object>();
                Set<AnswerInfo> ansSet = new HashSet<>();
                DialogueInfo dialogueInfo = dialogueInfos.get(i);
                //set中装进3个选项
                while (ansSet.size() < 3) {
                    int randomNum = random.nextInt(aSize);
                    AnswerInfo answerInfo = answerInfos.get(randomNum);
                    Long aId = answerInfo.getId();
                    if (aId != dialogueInfo.getaId() && !ansSet.contains(answerInfo)) {
                        ansSet.add(answerInfo);
                    }
                }
                for (int j = 0; j < answers.size(); j++) {
                    if (answers.get(j).getId()==dialogueInfo.getaId()) {
                        ansSet.add(answers.get(j));
                        break;
                    }
                }
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
