package com.epam.rp.tests.logging;

import com.epam.rp.tests.MagicRandomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import rp.com.google.common.io.BaseEncoding;
import rp.com.google.common.io.Resources;

import java.io.IOException;

/**
 * Logs image
 *
 * @author Andrei Varabyeu
 */
public class LuckyPugTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LuckyPugTest.class);

    @Test
    public void logImageBase64() throws IOException {

        /* Generate 10 logs with pugs. Pug may be lucky or unlucky based on randomizer */
        for (int i = 0; i < 20; i++) {
            /* 50 percents. So we should have approximately same count of lucky and unlucky pugs */
            boolean happy = MagicRandomizer.checkYourLucky(30);
            String image = getImageResource(happy);

            LOGGER.info("RP_MESSAGE#BASE64#{}#{}",
                    BaseEncoding.base64().encode(Resources.asByteSource(Resources.getResource(image)).read()),
                    "Pug is " + (happy ? "HAPPY" : "NOT HAPPY"));
        }

    }

    private String getImageResource(boolean lucky) {
        return "pug/" + (lucky ? "lucky.jpg" : "unlucky.jpg");
    }
}
