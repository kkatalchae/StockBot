package com.bot.stock.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TokenUtil {

  private static TokenUtil instance;
  private static String PropsPath = "credential.properties";

  private TokenUtil() {
  }

  public static synchronized TokenUtil getInstance() {
    if (instance == null) {
      instance = new TokenUtil();
    }

    return instance;
  }

  public String getToken() {
    String token = null;

    Properties prop = new Properties();
    InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PropsPath);

    try {
      if (inputStream != null) {
        prop.load(inputStream);
        token = prop.getProperty("discord_token");

      } else {
        throw new FileNotFoundException("해당 파일을 찾을 수 없습니다" + PropsPath);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return token;
  }
}
