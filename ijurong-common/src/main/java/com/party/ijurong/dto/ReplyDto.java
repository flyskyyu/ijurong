package com.party.ijurong.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.party.ijurong.pojo.Reply;

/**
 * Created by Administrator on 2017/6/9 0009.
 */
public class ReplyDto extends Reply{
    private String staffName;
    private String avatar;
    private Integer isLiked;
    @JsonIgnore
    private boolean showMyReply;

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getIsLiked() {
        return isLiked;
    }

    public void setIsLiked(Integer isLiked) {
        this.isLiked = isLiked;
    }

    public boolean isShowMyReply() {
        return showMyReply;
    }

    public void setShowMyReply(boolean showMyReply) {
        this.showMyReply = showMyReply;
    }
}
