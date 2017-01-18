/*
 * Copyright 2017 the original author or authors.
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
 * limitations under the License.
 */

package org.gradle.api.internal.tasks;

import org.gradle.api.internal.TaskCacheability;

class DefaultTaskCacheability implements TaskCacheability {
    private final boolean cacheable;
    private final String disabledReason;

    static final DefaultTaskCacheability CACHEABLE = new DefaultTaskCacheability(true, null);
    static DefaultTaskCacheability notCacheable(String disabledReason) {
        return new DefaultTaskCacheability(false, disabledReason);
    }

    private DefaultTaskCacheability(boolean cacheable, String disabledReason) {
        this.cacheable = cacheable;
        this.disabledReason = disabledReason;
    }

    @Override
    public boolean isCacheable() {
        return cacheable;
    }

    @Override
    public String getDisabledReason() {
        return disabledReason;
    }
}