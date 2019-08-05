package com.yang.controller;

import com.yang.Utils.JsonUtils;
import com.yang.entity.DialogueInfo;
import com.yang.service.DialogueService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@EnableAutoConfiguration
@RequestMapping("/dialogue")
public class DialogueController {
    @Resource
    private DialogueService dialogueService;

    @RequestMapping("/getDialogueInfos")
    public String getDialogueInfos(Integer num) {
    return JsonUtils.toJsonString(this.dialogueService.getDialogueInfos(num));
    }

    @RequestMapping(value = "/selectDialogueById",produces = "application/json;charset=utf-8")
    public String selectDialogueById(Long did) {
        DialogueInfo dialogueInfo = this.dialogueService.selectDialogueById(did);
        return JsonUtils.toJsonString(dialogueInfo);
    }

}
