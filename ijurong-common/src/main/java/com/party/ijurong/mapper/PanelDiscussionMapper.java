package com.party.ijurong.mapper;

import com.party.ijurong.dto.PanelDiscussionDto;
import com.party.ijurong.pojo.PanelDiscussion;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PanelDiscussionMapper extends Mapper<PanelDiscussion> {
    List<PanelDiscussionDto> findPanelDiscussionsByIsShadow(@Param("isShadow") int isShadow);
}