package kr.pe.karsei.springbatchexample.scheduler;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static org.quartz.JobBuilder.newJob;

public abstract class JobRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        doRun(args);
    }

    protected abstract void doRun(ApplicationArguments args);

    public JobDetail buildJobDetail(Class job, String name, String group, Map params) {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.putAll(params);

        return newJob(job)
                .withIdentity(name, group)
                .usingJobData(jobDataMap)
                .build();
    }

    public Trigger buildJobTrigger(String scheduleExp) {
        return TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule(scheduleExp))
                .build();
    }
}
