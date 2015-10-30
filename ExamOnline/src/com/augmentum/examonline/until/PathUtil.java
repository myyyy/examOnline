package com.augmentum.examonline.until;

import com.augmentum.examonline.AppContext;
import com.augmentum.examonline.Constants;

public class PathUtil {

    public static String getFullPath(String path) {
        if (path == null) {
            path = "";
        }
        String urlPrefix = Constants.APP_URL_PREFIX;
        if (!StringUtil.isEmpty(urlPrefix)) {
            urlPrefix += "/";
        }

        return AppContext.getContextPath() + "/" + urlPrefix + path;
    }

}
