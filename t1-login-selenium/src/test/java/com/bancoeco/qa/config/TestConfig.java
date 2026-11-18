package com.bancoeco.qa.config;

public final class TestConfig {

    public static final String BASE_URL = System.getProperty(
            "baseUrl",
            "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    public static final boolean VISUAL = Boolean.getBoolean("visual");
    public static final int TIMEOUT_SECONDS = Integer.getInteger("timeout", 20);

    private TestConfig() {
    }
}
