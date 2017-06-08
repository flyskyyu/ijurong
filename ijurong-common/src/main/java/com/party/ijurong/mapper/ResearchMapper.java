package com.party.ijurong.mapper;

import com.party.ijurong.pojo.Research;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ResearchMapper extends Mapper<Research> {

    List<Research> getResearchsDoing();

    List<Research> getResearchsStart();

    List<Research> getResearchsOver();
}