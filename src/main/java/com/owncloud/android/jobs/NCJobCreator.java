/**
 * Nextcloud Android client application
 *
 * @author Mario Danic
 * @author Chris Narkiewicz
 * Copyright (C) 2017 Mario Danic
 * Copyright (C) 2017 Nextcloud GmbH
 * Copyright (C) 2019 Chris Narkiewicz <hello@ezaquarii.com>
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.owncloud.android.jobs;

import android.content.Context;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;
import com.nextcloud.client.account.UserAccountManager;
import com.nextcloud.client.preferences.AppPreferences;

import androidx.annotation.NonNull;

/**
 * Job creator for android-job
 */

public class NCJobCreator implements JobCreator {

    private final Context context;
    private final UserAccountManager accountManager;
    private final AppPreferences preferences;

    public NCJobCreator(Context context, UserAccountManager accountManager, AppPreferences preferences) {
        this.context = context;
        this.accountManager = accountManager;
        this.preferences = preferences;
    }

    @Override
    public Job create(@NonNull String tag) {
        switch (tag) {
            case ContactsBackupJob.TAG:
                return new ContactsBackupJob();
            case ContactsImportJob.TAG:
                return new ContactsImportJob();
            case AccountRemovalJob.TAG:
                return new AccountRemovalJob();
            case FilesSyncJob.TAG:
                return new FilesSyncJob(accountManager, preferences);
            case OfflineSyncJob.TAG:
                return new OfflineSyncJob(accountManager);
            case NotificationJob.TAG:
                return new NotificationJob(context, accountManager);
            case MediaFoldersDetectionJob.TAG:
                return new MediaFoldersDetectionJob(accountManager);
            default:
                return null;
        }
    }
}
