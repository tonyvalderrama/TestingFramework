package com.epam.training.tony_valderrama.service;

import com.epam.training.tony_valderrama.model.User;

public class UserCreator {
    public static final String USER_NAME = "user.name";
    public static final String USER_PASSWORD = "user.password";

    public static User withCredentialsFromProperty(){
        return new User(TestUserData.getTestData(USER_PASSWORD),
                TestUserData.getTestData(USER_NAME));
    }

    public static User withEmptyUsername(){
        return new User("", "");
    }

    public static User withEmptyPassword(){
        return new User("", TestUserData.getTestData(USER_PASSWORD));
    }
}
