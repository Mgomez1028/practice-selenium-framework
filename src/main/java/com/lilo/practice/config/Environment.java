package com.lilo.practice.config;

import java.util.Map;

public class Environment {

    private Environment() {
    }

    private static final String ENV_VARIABLE = "env";
    private static final String ENV_KEY = "${env}";
    private static final String BROWSER_VARIABLE = "browser";
    private static final String BROWSER_KEY = "${browser}";
    public static final  Map<String,String> envVariables = System.getenv();

    public static String getEnvVariable(String envName){
        return System.getProperty(envName);
    }
}
