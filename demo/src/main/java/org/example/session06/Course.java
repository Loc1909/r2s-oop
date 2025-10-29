package org.example.session06;

import java.util.ArrayList;
import java.util.Scanner;

public class Course {
    private String code;
    private String name;
    private boolean status;
    private short duration;
    private String flag;

    public Course() {
    }

    public Course(String code, String name, boolean status, short duration, String flag) {
        this.code = code;
        this.name = name;
        this.status = status;
        this.duration = duration;
        this.flag = flag;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-30s | %-10s | %-10d | %-15s",
                code, name, status ? "Active" : "Inactive", duration, flag);
    }

    public void input(Scanner sc, ArrayList<Course> courses) {
        while (true) {
            System.out.print("Nhập code (RA + 3 chữ số, VD: RA001): ");
            code = sc.nextLine().trim();
            if (Validator.validateCode(code)) {
                if (Validator.isDuplicatedCode(code, courses)) {
                    System.out.println("Lỗi: Code đã tồn tại! Vui lòng nhập lại.");
                }
                else
                    break;
            }
            else {
                System.out.println("Lỗi: Code phải bắt đầu bằng 'RA' và theo sau là 3 chữ số!");
            }
        }

        while (true) {
            System.out.print("Nhập tên khóa học: ");
            name = sc.nextLine().trim();
            if (!name.isEmpty()) {
                break;
            }
            System.out.println("Lỗi: Tên không được để trống!");
        }

        while (true) {
            System.out.print("Nhập trạng thái (true/false): ");
            String statusInput = sc.nextLine().trim().toLowerCase();
            if (Validator.validateStatus(statusInput)) {
                status = statusInput.equals("true");
                break;
            }
            else {
                System.out.println("Lỗi: Trạng thái chỉ được nhập 'true' hoặc 'false'!");
            }
        }

        while (true) {
            System.out.print("Nhập thời lượng (giờ): ");
            try {
                String durationInput = sc.nextLine().trim();
                short tempDuration = Short.parseShort(durationInput);
                if (Validator.validateDuration(tempDuration)) {
                    duration = tempDuration;
                    break;
                }
                else {
                    System.out.println("Lỗi: Thời lượng phải lớn hơn 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số hợp lệ!");
            }
        }

        while (true) {
            System.out.print("Nhập flag (optional / prerequisite / N/A): ");
            flag = sc.nextLine().trim();
            if (Validator.validateFlag(flag)) {
                break;
            } else {
                System.out.println("Lỗi: Flag chỉ được nhập 'optional', 'prerequisite' hoặc 'N/A'!");
            }
        }
    }
}

