package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class JobsScheduler {
    private List<Job> mJobs = new LinkedList<Job>();

    public void registerJob(String jobName) {
        Job job = new Job(jobName);
        if (!mJobs.contains(job)) {
            mJobs.add(job);
        }
    }

    public void sort() {
        mJobs.sort(Job::compareTo);
    }

    public String getList() {
        StringBuilder str = new StringBuilder();
        for (Job job : mJobs) {
            str.append(job.toString());
        }
        return str.toString();
    }

    public void registerJob(String dependentJob, String independentJob) {


        Job independent = mJobs.stream()
                .filter(j -> j.getName().equals(independentJob))
                .findAny()
                .orElse(null);
        if (independent == null) {
            independent = new Job(independentJob);
            mJobs.add(independent);
        }


        Job dependent = mJobs.stream()
                .filter(j -> j.getName().equals(dependentJob))
                .findAny()
                .orElse(null);
        if (dependent == null) {
            dependent = new Job(dependentJob);
            mJobs.add(dependent);
        }

        dependent.mDependsOn = independent;
    }
}
