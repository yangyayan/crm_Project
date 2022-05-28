package com.yang.crm.workbench.service;

import com.yang.crm.workbench.domain.Activity;

import java.util.List;
import java.util.Map;

public interface ActivityService {

    int saveCreateActivity(Activity activity);
    List<Activity> queryActicityByConditionForPage(Map<String,Object> map);
    int queryCountOfActivityByCondition(Map<String,Object> map);
}
