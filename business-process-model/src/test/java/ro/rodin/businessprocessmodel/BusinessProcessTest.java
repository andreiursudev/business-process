package ro.rodin.businessprocessmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ro.rodin.businessprocessmodel.flowobject.Activity;

public class BusinessProcessTest {

    @Test
    void businessProcessWithOneActivity() {
        Activity activity = new Activity(){};
        BusinessProcess businessProcess = new BusinessProcess(activity);

        assertEquals(activity, businessProcess.getActivities().get(0));
    }
}
