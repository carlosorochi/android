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

/**
 * This class provides general, static information about application
 * build.
 *
 * All methods should be thread-safe.
 */
public interface AppInfo {

    /**
     * Get application version code.
     *
     * TODO: check validity of this assumption:
     * Non gradle build systems do not provide {@link com.owncloud.android.BuildConfig#VERSION_CODE}
     * so we must fallback to this method :(
     *
     * @return Version code as defined in AndroidManifest.xml
     */
    int getVersionCode();

    /**
     * Get application version code as formatted string.
     *
     * TODO: check validity of this assumption:
     * Non gradle build systems do not provide {@link com.owncloud.android.BuildConfig#VERSION_CODE}
     * so we must fallback to this method :(
     *
     * @return Formatted version code as defined in AndroidManifest.xml
     */
    String getFormattedVersionCode();

    /**
     * Get application version name.
     *
     * TODO: check validity of this assumption:
     * Non gradle build systems do not provide {@link com.owncloud.android.BuildConfig#VERSION_NAME}
     * so we must fallback to this method :(
     *
     * @return Version code as defined in AndroidManifest.xml
     */
    String getVersionName();
}
