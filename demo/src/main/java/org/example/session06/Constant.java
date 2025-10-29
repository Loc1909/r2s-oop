package org.example.session06;

public final class Constant {
    private Constant() {
    }

    public static final String FLAG_OPTIONAL = "optional";
    public static final String FLAG_PREREQUISITE = "prerequisite";
    public static final String FLAG_NA = "N/A";
    public static final String[] ALLOWED_FLAGS = {FLAG_OPTIONAL, FLAG_PREREQUISITE, FLAG_NA};

    public static final String SEARCH_BY_CODE = "code";
    public static final String SEARCH_BY_NAME = "name";
    public static final String SEARCH_BY_STATUS = "status";
    public static final String SEARCH_BY_DURATION = "duration";
    public static final String SEARCH_BY_FLAG = "flag";

    public static final int MENU_CREATE = 1;
    public static final int MENU_SEARCH = 2;
    public static final int MENU_DISPLAY_BY_FLAG = 3;
    public static final int MENU_QUIT = 4;
}
