package bai05;

public class SuperAdmin implements AdminActions , UserActions{
    // Class phải override method đó.
    @Override
    public void logActivity(String activity) {
        System.out.println("SuperAdmin activity: " + activity);
    }
}