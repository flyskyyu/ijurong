package com.party.ijurong.mapper;

import com.party.ijurong.dto.ExamPaperDto;
import com.party.ijurong.dto.ResearchDto;
import com.party.ijurong.pojo.Research;
import com.party.ijurong.pojo.ResearchExam;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ResearchExamMapper extends Mapper<ResearchExam> {

    List<ResearchDto> getResearchByResearchId(int researchId);

    List<ExamPaperDto> getExamPaperByResearchId(int researchId);

}