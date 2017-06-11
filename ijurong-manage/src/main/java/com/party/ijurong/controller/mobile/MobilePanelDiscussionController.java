package com.party.ijurong.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.Page;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.constants.ConstantOrigin;
import com.party.ijurong.dto.PanelDiscussionDto;
import com.party.ijurong.pojo.*;
import com.party.ijurong.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/28 0028.
 */
@Controller
@RequestMapping("mobile/discussion")
public class MobilePanelDiscussionController {
    @Autowired
    private PanelDiscussionService panelDiscussionService;

    @Autowired
    private MobileShiroService shiroService;

    @Autowired
    private ReplyService replyService;

    @Autowired
    private AttachmentService attachmentService;

    @RequestMapping("addDiscussion")
    @ResponseBody
    public MobileResult addDiscussion(String title,int isShadow,String url) {
        MobileResult result = new MobileResult();
        try {

            SimpleUser user = shiroService.getUser();
            PanelDiscussion panelDiscussion=new PanelDiscussion();
            panelDiscussion.setUserId(user.getUserId());
            panelDiscussion.setCreateTime(new Date());
            panelDiscussion.setTitle(title);
            panelDiscussion.setIsShadow(isShadow);
            panelDiscussionService.insertPanelDiscussion(panelDiscussion);
            //附件
            String[] str=url.split(",");
            for(int i=0;i<str.length;i++)
            {
                Attachment attachment=new Attachment();
                attachment.setFunctionId(panelDiscussion.getId());
                attachment.setFunctionType(ConstantOrigin.C9_DISCUSSION);
                attachment.setUrl(str[i]);
                attachment.setCreateTime(new Date());
                attachment.setCreateUserId(user.getUserId());
                attachment.setType(str[i].replace(".", "-----").split("-----")[str[i].replace(".", "-----").split("-----").length - 1].toString());
                attachment.setFilename(str[i].split("/")[str[i].split("/").length-1].toString());
                attachmentService.insertAttachment(attachment);
            }

            result.setCode(200);
            result.setMsg("发布成功！");

        }
        catch (Exception e)
        {
            e.printStackTrace();
            result.setCode(404);
            result.setMsg("系统异常！");
        }
        return result;
    }

    @RequestMapping("getList")
    @ResponseBody
    public MobileResult getList(HttpServletRequest httpServletRequest,int isShadow, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        MobileResult result = new MobileResult();
        try {

            SimpleUser user = shiroService.getUser();
            PageInfo<PanelDiscussionDto> p= panelDiscussionService.findPanelDiscussionsByIsShadow(isShadow, page, rows);
            //图片
            for(int i=0;i<p.getList().size();i++)
            {
                String url="";
                int id=p.getList().get(i).getId();
                List<Attachment> list= attachmentService.findAttachmentByFunction(ConstantOrigin.C9_DISCUSSION, id);
                if(list.size()>0)
                {
                    for(int j=0;j<list.size();j++)
                    {
                        url+=list.get(j).getUrl()+",";
                    }
                    p.getList().get(i).setUrl(url.substring(0,url.length()-1));
                }
            }
            //回复数量
//            Reply reply=new Reply();
//            reply.set
//            replyService.queryByReply()
            //收藏数量

            //点赞数量


//            Map<String ,Object> map=new HashMap<String ,Object>();
//            map.put("list",p.getList());
            result.setCode(200);
            result.setData(p.getList());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            result.setCode(404);
            result.setMsg("系统异常！");
        }
        return result;
    }
}
