package com.testdroid.appium;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.interactions.HasTouchScreen;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteTouchScreen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Testdroid Appium driver
 *
 * https://git@github.com/bitbar/testdroid-appium-driver
 *
 * Usage:
 *
 * @TODO
 *
 * @author Henri Kivelä <henri.kivela@bitbar.com>
 */

public class TestdroidAppiumDriverAndroid extends AndroidDriver implements HasTouchScreen {

    public static final String CAPABILITY_TESTDROID_USERNAME = "testdroid_username";
    public static final String CAPABILITY_TESTDROID_PASSWORD = "testdroid_password";
    private static final Logger logger = LoggerFactory.getLogger(TestdroidAppiumDriverAndroid.class);

    public RemoteTouchScreen touch;

    public TestdroidAppiumDriverAndroid(URL url, DesiredCapabilities capabilities) {
        super(url, capabilities);
        touch = new RemoteTouchScreen(getExecuteMethod());
    }

    public TouchScreen getTouch() {
        return touch;
    }

    public void takeScreenshot(String filePath) throws Exception {
        File f = getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f, new File(filePath));
        logger.info("Screenshot captured: {}", filePath);
    }
}