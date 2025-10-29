package org.example.session06;

import java.util.ArrayList;
import java.util.Arrays;

public class Validator {

    public static boolean validateCode(String code) {
        if (code == null || code.length() != 5) {
            return false;
        }

        if (!code.startsWith("RA")) {
            return false;
        }

        String digits = code.substring(2); // cắt chuỗi từ vị trí thứ 2

        try {
            Integer.parseInt(digits);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDuplicatedCode(String code, ArrayList<Course> courses) {
        return courses.stream().anyMatch(course -> course.getCode().equalsIgnoreCase(code));
    }

    public static boolean validateStatus(String status) {
        return status.equals("true") || status.equals("false");
    }

    public static boolean validateFlag(String flag) {
        if (flag == null) return false;
        String normalizedFlag = flag.trim();
        return Arrays.stream(Constant.ALLOWED_FLAGS).anyMatch(a -> a.equalsIgnoreCase(normalizedFlag));
    }

    public static boolean validateDuration(short duration) {
        return duration > 0;
    }
}