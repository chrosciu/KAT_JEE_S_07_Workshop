package com.chrosciu.admin;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptTest {
    public static void main(String[] args) {
        String password = "test";
        String salt = BCrypt.gensalt();
        System.out.println(salt);
        String hash = BCrypt.hashpw(password, salt);
        System.out.println(hash);
    }
}
