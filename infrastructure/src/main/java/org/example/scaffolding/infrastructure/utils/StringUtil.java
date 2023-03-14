package org.example.scaffolding.infrastructure.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Leonardo
 * @creatTime 2023/3/14 22:12
 */
public class StringUtil {

    /**
     * 优化uri
     * example: "/api/abc/" -> "/api/abc"
     * @param uri uri
     * @return 增加前斜杠, 去除后斜杠
     */
    public static String optimisticUri(String uri) {
        if (StringUtils.isBlank(uri)) {
            return "";
        }
        if (!uri.startsWith("/")) {
            uri = "/" + uri;
        }
        if (uri.endsWith("/")) {
            uri = uri.substring(0, uri.length() - 1);
        }
        return uri;
    }

}
