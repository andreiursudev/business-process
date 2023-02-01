package ro.rodin.businessprocessmodel;

import java.util.ArrayList;
import java.util.List;

import ro.rodin.businessprocessmodel.flowobject.Activity;

public class BusinessProcess {
    private List<Activity> activities = new ArrayList<>();

    public BusinessProcess(Activity activity) {
        activities.add(activity);
    }

    public List<Activity> getActivities() {
        return activities;
    }
}
