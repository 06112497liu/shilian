/*
 * Copyright (c) BrandBigData.com Inc.
 * All Rights Reserved 2017.
 */

package com.bbd.utils;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordParamUtil {

    private static final int    MAX_IMG_WIDTH = 400;
    private Logger              logger        = LoggerFactory.getLogger(getClass());
    private Map<String, Object> params;

    private WordParamUtil() {
        params = new HashMap<String, Object>();
    }

    public static WordParamUtil init() {
        return new WordParamUtil();
    }

    public WordParamUtil put(String key, Object value) {
        params.put(key, value);
        return this;
    }

    // 图像按比例缩放
    public WordParamUtil putImg(String key, String type, byte[] bytes) {
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            BufferedImage bufferedImage = ImageIO.read(in);
            int w = bufferedImage.getWidth();
            int h = bufferedImage.getHeight();
            int cw = w;
            int ch = h;
            // 宽度超过最大宽度度 等比例缩放
            if (cw > MAX_IMG_WIDTH) {
                cw = MAX_IMG_WIDTH;
                ch = (int) (h * (cw * 1.0 / w));
            }
            logger.debug("now this {} img width:{} height:{}.", key, cw, ch);
            Map<String, Object> pic = new HashMap<String, Object>();
            pic.put("width", cw);
            pic.put("height", ch);
            pic.put("type", type);
            BufferedImage image = Thumbnails.of(bufferedImage).size(cw, ch).asBufferedImage();
            ImageIO.write(image, type, out);
            pic.put("content", out.toByteArray());
            params.put(key, pic);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
        }
        return this;
    }

    public WordParamUtil putList(String key, String... args) {
        params.put(key, Arrays.asList(args));
        return this;
    }

    public Map<String, Object> get() {
        return this.params;
    }
}
