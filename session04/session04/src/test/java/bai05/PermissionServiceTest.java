package bai05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PermissionServiceTest {

    private User user;

    @AfterEach
    void tearDown() {
        user = null; // dọn dẹp object giả
    }

    // admin

    @Test
    void adminCanDeleteUser() {
        user = new User("Admin", Role.ADMIN);
        boolean result = PermissionService.canPerformAction(user, Action.DELETE_USER);

        assertTrue(result);
    }

    @Test
    void adminCanLockUser() {
        user = new User("Admin", Role.ADMIN);
        boolean result = PermissionService.canPerformAction(user, Action.LOCK_USER);

        assertTrue(result);
    }

    @Test
    void adminCanViewProfile() {
        user = new User("Admin", Role.ADMIN);
        boolean result = PermissionService.canPerformAction(user, Action.VIEW_PROFILE);

        assertTrue(result);
    }

    // mod

    @Test
    void moderatorCannotDeleteUser() {
        user = new User("Mod", Role.MODERATOR);
        boolean result = PermissionService.canPerformAction(user, Action.DELETE_USER);

        assertFalse(result);
    }

    @Test
    void moderatorCanLockUser() {
        user = new User("Mod", Role.MODERATOR);
        boolean result = PermissionService.canPerformAction(user, Action.LOCK_USER);

        assertTrue(result);
    }

    @Test
    void moderatorCanViewProfile() {
        user = new User("Mod", Role.MODERATOR);
        boolean result = PermissionService.canPerformAction(user, Action.VIEW_PROFILE);

        assertTrue(result);
    }

    // user

    @Test
    void userCannotDeleteUser() {
        user = new User("User", Role.USER);
        boolean result = PermissionService.canPerformAction(user, Action.DELETE_USER);

        assertFalse(result);
    }

    @Test
    void userCannotLockUser() {
        user = new User("User", Role.USER);
        boolean result = PermissionService.canPerformAction(user, Action.LOCK_USER);

        assertFalse(result);
    }

    @Test
    void userCanViewProfile() {
        user = new User("User", Role.USER);
        boolean result = PermissionService.canPerformAction(user, Action.VIEW_PROFILE);

        assertTrue(result);
    }
}