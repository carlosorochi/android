package com.nextcloud.client.whatsnew;

import android.content.Context;
import android.content.Intent;

import com.nextcloud.client.account.CurrentAccountProvider;
import com.nextcloud.client.appinfo.AppInfo;
import com.nextcloud.client.preferences.AppPreferences;
import com.owncloud.android.R;
import com.owncloud.android.features.FeatureItem;
import com.owncloud.android.ui.activity.PassCodeActivity;

public class WhatsNewService {

    private Context context;
    private AppPreferences preferences;
    private CurrentAccountProvider accountProvider;
    private AppInfo appInfo;

    WhatsNewService(Context context, AppPreferences preferences, CurrentAccountProvider accountProvider, AppInfo appInfo) {
        this.context = context;
        this.preferences = preferences;
        this.accountProvider = accountProvider;
        this.appInfo = appInfo;
    }

    public void runIfNeeded(Context callingContext) {
        if (!context.getResources().getBoolean(R.bool.show_whats_new) || callingContext instanceof WhatsNewActivity) {
            return;
        }

        if (shouldShow(callingContext)) {
            context.startActivity(new Intent(callingContext, WhatsNewActivity.class));
        }
    }

    FeatureItem[] getWhatsNew() {
        int itemVersionCode = 30030099;

        if (!isFirstRun() && appInfo.getVersionCode() >= itemVersionCode
            && preferences.getLastSeenVersionCode() < itemVersionCode) {
            return new FeatureItem[]{new FeatureItem(R.drawable.whats_new_device_credentials,
                                                     R.string.whats_new_device_credentials_title, R.string.whats_new_device_credentials_content,
                                                     false, false)};
        } else {
            return new FeatureItem[0];
        }
    }

    private boolean shouldShow(Context callingContext) {
        return !(callingContext instanceof PassCodeActivity) && getWhatsNew().length > 0;
    }

    private boolean isFirstRun() {
        return accountProvider.getCurrentAccount() == null;
    }
}
