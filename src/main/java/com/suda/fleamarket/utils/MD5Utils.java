package com.suda.fleamarket.utils;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

public class MD5Utils {
    private static final String SALT = "12d!!s@igHDG*325h89#%8dsEh@$%3f#%93h";

    public static String md5(String string) {
        return new String(DigestUtils.md5Digest(string.getBytes(StandardCharsets.UTF_8)));
    }

    public static String md5WithSalt(String string) {
        return md5(string + SALT);
    }

}
