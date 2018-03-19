package com.ashish.buildurl.utilities;

import android.net.Uri;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ashish on 19/3/18.
 */

public class NetworkUtils {

    final static String INTENT_COMMON_BASE_URL =
            "https://developer.android.com/guide/components/intents-common.html";

    final static String PARAM_SOURCE = "utm_source";

    final static String PARAM_MEDIUM = "utm_medium";

    final static String PARAM_CAMPAIGN = "utm_campaign";

    public static URL buildUrl(String source, String medium, String campaign, String fragment) {
        Uri builtUri = Uri.parse(INTENT_COMMON_BASE_URL).buildUpon()
                .appendQueryParameter(PARAM_SOURCE, source)
                .appendQueryParameter(PARAM_MEDIUM, medium)
                .appendQueryParameter(PARAM_CAMPAIGN, campaign)
                .fragment(fragment)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

}
