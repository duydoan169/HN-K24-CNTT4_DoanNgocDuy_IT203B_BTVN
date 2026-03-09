package bai03;

public interface Authenticatable {
    String getPassword();
    default boolean isAuthenticated(){
        return getPassword() != null && !getPassword().isEmpty();
    }
    default String encryptPassword(String rawPassword){
        return rawPassword;
    }
}