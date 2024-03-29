/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.android.dialerbind;

import static com.android.dialer.calllog.CallLogAdapter.CallFetcher;

import android.content.Context;

import com.android.dialer.calllog.CallLogAdapter;
import com.android.dialer.calllog.ContactInfoHelper;
import com.android.dialer.service.CachedNumberLookupService;
import com.google.android.dialer.calllog.GoogleCallLogAdapter;
import com.google.android.dialer.phonenumbercache.CachedNumberLookupServiceImpl;

/**
 * Default static binding for various objects.
 */
public class ObjectFactory {

    public static CachedNumberLookupService newCachedNumberLookupService() {
        return new CachedNumberLookupServiceImpl();
    }

    public static CallLogAdapter newCallLogAdapter(Context context, CallFetcher callFetcher,
            ContactInfoHelper contactInfoHelper, boolean useCallAsPrimaryAction,
            boolean isCallLog) {
        if (isCallLog) {
            return new CallLogAdapter(context, callFetcher, contactInfoHelper, useCallAsPrimaryAction,
                    isCallLog);
        } else {
            return new GoogleCallLogAdapter(context, callFetcher, contactInfoHelper, useCallAsPrimaryAction,
                    isCallLog);
        }
    }
}
