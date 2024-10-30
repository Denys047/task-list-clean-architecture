package com.tasklist.task_list_clean_architecture.infrastructure.security.consts;

public class JwtExceptions {

    public static final String INVALID_JWT_TOKEN = "Invalid JWT token: {}";

    public static final String JWT_EXPIRED = "JWT token is expired: {}";

    public static final String JWT_UNSUPPORTED = "JWT token is unsupported: {}";

    public static final String JWT_EMPTY = "JWT claims string is empty: {}";

    private JwtExceptions() {

    }

}
