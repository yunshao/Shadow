/*
 * Tencent is pleased to support the open source community by making Tencent Shadow available.
 * Copyright (C) 2019 THL A29 Limited, a Tencent company.  All rights reserved.
 *
 * Licensed under the BSD 3-Clause License (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *     https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.tencent.shadow.core.runtime;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;

import com.tencent.shadow.core.runtime.container.PluginContainerActivity;

public class ShadowDialog extends Dialog {
    public ShadowDialog(Context context) {
        super(context);
    }

    public ShadowDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected ShadowDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public final void setOwnerPluginActivity(ShadowActivity activity) {
        Activity hostActivity = (Activity) activity.mHostActivityDelegator.getHostActivity();
        setOwnerActivity(hostActivity);
    }

    public final ShadowActivity getOwnerPluginActivity() {
        PluginContainerActivity ownerActivity = (PluginContainerActivity) getOwnerActivity();
        if (ownerActivity != null) {
            return (ShadowActivity) PluginActivity.get(ownerActivity);
        } else {
            return null;
        }
    }
}
