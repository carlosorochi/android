package com.nextcloud.client.whatsnew;

import android.content.Context;

import com.nextcloud.client.account.CurrentAccountProvider;
import com.nextcloud.client.appinfo.AppInfo;
import com.nextcloud.client.preferences.AppPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class WhatsNewModule {

    @Provides
    @Singleton
    WhatsNewService whatsNewService(
        Context context,
        AppPreferences preferences,
        CurrentAccountProvider accountProvider,
        AppInfo appInfo
    ) {
        return new WhatsNewService(context, preferences, accountProvider, appInfo);
    }
}
