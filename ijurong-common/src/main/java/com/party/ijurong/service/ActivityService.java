package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.dto.ActivityDto;
import com.party.ijurong.mapper.ActivityMapper;
import com.party.ijurong.mapper.ActivityMemberMapper;
import com.party.ijurong.mapper.StaffMapper;
import com.party.ijurong.pojo.Activity;
import com.party.ijurong.pojo.ActivityMember;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Cloud on 2017/6/7.
 */
@Service
public class ActivityService extends BaseService<Activity> {
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private ActivityMemberMapper activityMemberMapper;
    @Autowired
    private StaffMapper staffMapper;

    public PageInfo<Activity> queryByActivity(Activity activity, int page, int rows) {
        Example example = new Example(Activity.class);
        Example.Criteria criteria = example.createCriteria();
        if(activity.getTitle() != null) {
            criteria.andLike("title", "%" + activity.getTitle() + "%");
        }
        if(activity.getPartyBranchId() != null) {
            criteria.andEqualTo("partyBranchId", activity.getPartyBranchId());
        }
        if(activity.getType() != null) {
            criteria.andEqualTo("type", activity.getType());
        }
        if(activity.getStartTime() != null) {
            criteria.andGreaterThanOrEqualTo("startTime", activity.getStartTime());
        }
        if(activity.getEndTime() != null) {
            criteria.andLessThanOrEqualTo("endTime", activity.getEndTime());
        }
        if(activity.getOrderType() == null || activity.getOrderType() == 1) {
            example.orderBy("id").desc();
        } else {
            example.orderBy("clickAmount").desc();
        }
        PageHelper.startPage(page, rows);
        List<Activity> activities = activityMapper.selectByExample(example);
        return new PageInfo<>(activities);
    }

    public PageInfo<ActivityDto> queryByDto(ActivityDto dto, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<ActivityDto> dtos = activityMapper.queryByDto(dto);
        return new PageInfo<>(dtos);
    }

    public void increaseClickAmount(Integer id) {
        activityMapper.increaseClickAmount(id);
    }

    public void add(Activity activity, String addStaffs) {
        activityMapper.insertSelective(activity);
        addStaffs(addStaffs, activity.getId());
    }

    private void addStaffs(String addStaffs, Integer activityId) {
        if(StringUtils.isEmpty(addStaffs)) return;
        String[] datas = addStaffs.split(",");
        for(String data : datas) {
            String[] staff = data.split(":");
            ActivityMember member = new ActivityMember();
            member.setStaffId(Integer.parseInt(staff[0]));
            member.setStaffName(staff[1]);
            member.setActivityId(activityId);
            activityMemberMapper.insert(member);
        }
    }

    private void deleteStaffs(String deleteStaffs, Integer activityId) {
        if(StringUtils.isEmpty(deleteStaffs)) return;
        String[] datas = deleteStaffs.split(",");
        List ids = new ArrayList();
        for(String data : datas) {
            String[] staff = data.split(":");
            ids.add(staff[0]);
        }
        Example example = new Example(ActivityMember.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("activityId", activityId);
        criteria.andIn("staffId", ids);
        activityMemberMapper.deleteByExample(example);
    }

    public void update(Activity activity, String addStaffs, String deleteStaffs) {
        activityMapper.updateByPrimaryKeySelective(activity);
        deleteStaffs(deleteStaffs, activity.getId());
        addStaffs(addStaffs, activity.getId());
    }

    public void delete(Integer id) {
        ActivityMember member = new ActivityMember();
        member.setActivityId(id);
        activityMemberMapper.delete(member);
        activityMapper.deleteByPrimaryKey(id);
    }

    public void finish(Integer id) {
        Activity activity = new Activity();
        activity.setId(id);
        activity.setFlag(1);
        activityMapper.updateByPrimaryKeySelective(activity);
        ActivityMember activityMember = new ActivityMember();
        activityMember.setActivityId(id);
        List<ActivityMember> members = activityMemberMapper.select(activityMember);
        int integral = activityMapper.getIntegral(id);
        for(ActivityMember member : members) {
            Map map = new HashMap();
            map.put("userId", member.getStaffId());
            map.put("integral", integral);
            staffMapper.updateIntegralByUserId(map);
        }
    }
}
