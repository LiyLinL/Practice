package com.liy.generator.quartz.util;

import org.quartz.*;

import java.util.Map;

public class ScheduleUtil {

    /**
     * 創建任務
     *
     * @param scheduler
     * @param jobName
     * @param jobClass
     * @param jobGroupName
     * @param description
     * @param cronExpression
     * @param jobParam
     */
    public static void createScheduleJob( Scheduler scheduler, String jobName, String jobClass, String jobGroupName,
                                          String description, String cronExpression, Map<String, Object> jobParam ) {
        try {
            // 构建job信息
            JobDetail jobDetail = createJobDetail(jobName, jobClass, jobGroupName, description);

            // 表达式调度构建器
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

            // 按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity(TriggerKey.triggerKey(jobName, jobGroupName))
                    .withSchedule(cronScheduleBuilder)
                    .build();

            // 放入参数，运行时的方法可以获取
            jobDetail.getJobDataMap().putAll(jobParam);
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     * 更新任務
     *
     * @param scheduler
     * @param jobId
     * @param jobGroupName
     * @param cronExpression
     * @param jobParam
     */
    public static void updateScheduleJob( Scheduler scheduler, String jobId, String jobGroupName, String cronExpression, Map<String, Object> jobParam ) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(jobId, jobGroupName);

            // 表达式调度构建器
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            // 按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(cronScheduleBuilder).build();
            // 参数
            trigger.getJobDataMap().putAll(jobParam);

            // 按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey, trigger);
        } catch (SchedulerException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * 立即執行一次
     *
     * @param scheduler
     * @param jobId
     * @param jobGroupName
     * @param jobParam
     */
    public static void runScheduleJob( Scheduler scheduler, String jobId, String jobGroupName, Map<String, Object> jobParam ) {
        try {
            // 参数
            JobDataMap dataMap = new JobDataMap();
            dataMap.putAll(jobParam);
            scheduler.triggerJob(JobKey.jobKey(jobId, jobGroupName), dataMap);
        } catch (SchedulerException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * 暫停
     *
     * @param scheduler
     * @param jobId
     * @param jobGroupName
     */
    public static void pauseScheduleJob( Scheduler scheduler, String jobId, String jobGroupName ) {
        try {
            JobKey j = JobKey.jobKey(jobId, jobGroupName);
            scheduler.pauseJob(JobKey.jobKey(jobId, jobGroupName));
        } catch (SchedulerException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * 恢復
     *
     * @param scheduler
     * @param jobId
     * @param jobGroupName
     */
    public static void resumeScheduleJob( Scheduler scheduler, String jobId, String jobGroupName ) {
        try {
            scheduler.resumeJob(JobKey.jobKey(jobId, jobGroupName));
        } catch (SchedulerException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * 刪除
     *
     * @param scheduler
     * @param jobId
     * @param jobGroupName
     */
    public static void deleteScheduleJob( Scheduler scheduler, String jobId, String jobGroupName ) {
        try {
            //先暂停任务
            scheduler.pauseTrigger(TriggerKey.triggerKey(jobId, jobGroupName));
            //停止任务
            scheduler.unscheduleJob(TriggerKey.triggerKey(jobId, jobGroupName));
            //删除任务
            scheduler.deleteJob(JobKey.jobKey(jobId, jobGroupName));
        } catch (SchedulerException e) {
            System.out.println(e.toString());
        }
    }

    public static JobDetail createJobDetail( String jobName, String jobClass, String jobGroupName, String description ) throws Exception {
        Class aClass = Class.forName(jobClass);

        JobDetail jobDetail = JobBuilder.newJob(aClass)
                .withIdentity(JobKey.jobKey(jobName, jobGroupName))
                .withDescription(description)
                .build();

        return jobDetail;
    }
}
