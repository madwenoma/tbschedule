package com.test.schedule.task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;
import com.test.schedule.domain.User;
import com.test.schedule.domain.UserRepository;

@Component("demoTaskBeancd")
public class DemoTaskBeancd implements IScheduleTaskDealSingle<User> {

    private static int count = 0;

    private static Logger logger = Logger.getLogger(DemoTaskBeancd.class);

    @Autowired
    private UserRepository userRepository;

    private void printUserInfo(User user) {
        logger.info("=============job start=============");
        try {
            logger.info("userid: " + user.getId());
        } catch (Exception e) {
            logger.error("syncAccessToken::" + e);
        }
        logger.info("=============job end=============");
    }

    /**
     * 处理自己的业务
     */
    @Override
    public boolean execute(User subDetail, String ownSign) throws Exception {
        try {
            logger.info("=============execute biz logic=============");
            printUserInfo(subDetail);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    @Override
    public List<User> selectTasks(String taskParameter, String ownSign, int taskItemNum,
                                  List<TaskItemDefine> taskItemList, int eachFetchDataNum) throws Exception {
        System.out.println("count++ " + ++count);
        try {
            logger.info("=============taskParameter=============" + taskParameter);
            logger.info("=============ownSign=============" + ownSign);
            logger.info("=============taskItemNum=============" + taskItemNum);
            List<String> itemIds = taskItemList.stream().map(TaskItemDefine::getTaskItemId).collect(Collectors.toList());
            logger.info("=============taskItemList ids:=============" + itemIds.stream().collect(Collectors.joining(",")));
            logger.info("=============eachFetchDataNum=============" + eachFetchDataNum);
            List<User> list = new ArrayList<>();
            for (int i = 0; i < taskItemList.size(); i++) {
                TaskItemDefine item = taskItemList.get(i);
                long id = Long.parseLong(item.getTaskItemId());
                logger.info("=============id:=============-" + id);
//				list.addAll(userRepository.findAll((long)taskItemNum, id));    // 具体的 拿到的 id 是由  UserRepository 里面的 SQL决定
                list.add(new User(id));

            }
            if (count > 3) {
                return new ArrayList<>();
            }

            logger.info("=============list.size:=============" + list.size());
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Comparator<User> getComparator() {
        return new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };
    }

}
