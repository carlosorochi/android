/*
 * Nextcloud Android client application
 *
 * @author Chris Narkiewicz
 * Copyright (C) 2019 Chris Narkiewicz <hello@ezaquarii.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.nextcloud.client.appinfo;

import android.content.Context;
import android.content.pm.PackageManager;

import javax.inject.Inject;

class AppInfoImpl implements AppInfo {

    private Context context;

    AppInfoImpl(Context context) {
        this.context = context;
    }

    // Non gradle build systems do not provide BuildConfig.VERSION_CODE
    // so we must fallback to this method :(
    @Override
    public int getVersionCode() {
        try {
            String thisPackageName = context.getPackageName();
            return context.getPackageManager().getPackageInfo(thisPackageName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }
    }

    @Override
    public String getFormattedVersionCode() {
        return Integer.toString(getVersionCode());
    }

    // Non gradle build systems do not provide BuildConfig.VERSION_CODE
    // so we must fallback to this method :(
    @Override
    public String getVersionName() {
        try {
            String thisPackageName = context.getPackageName();
            return context.getPackageManager().getPackageInfo(thisPackageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
    }
}
