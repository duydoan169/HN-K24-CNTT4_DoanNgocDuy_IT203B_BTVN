package bai06;

import java.time.LocalDate;
import java.util.List;

public class UserService {

    public static User updateProfile(User existingUser,
                                     UserProfile newProfile,
                                     List<User> allUsers) {

        // kiểm tra ngày sinh tương lai
        if (newProfile.getBirthDate().isAfter(LocalDate.now())) {
            return null;
        }

        String newEmail = newProfile.getEmail();

        // kiểm tra email trùng
        for (User u : allUsers) {
            if (u != existingUser &&
                    u.getEmail().equalsIgnoreCase(newEmail)) {
                return null;
            }
        }

        // cập nhật thông tin
        existingUser.setEmail(newEmail);
        existingUser.setBirthDate(newProfile.getBirthDate());

        return existingUser;
    }
}