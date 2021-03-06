/*
 * Copyright 2012 the original author or authors.
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

package org.gradle.internal.resource.transfer;

import org.gradle.api.Nullable;
import org.gradle.internal.resource.local.LocallyAvailableExternalResource;
import org.gradle.internal.resource.local.LocallyAvailableResourceCandidates;
import org.gradle.internal.resource.local.LocallyAvailableResource;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public interface CacheAwareExternalResourceAccessor {
    /**
     * Fetches for a resource located at some URI.
     * @param source the URI of the resource to be fetched
     * @param fileStore used whenever the resource is effectively downloaded, to move it into a cache
     * @param additionalCandidates a list of candidates, found in a different place than the cache. When null, will only look into the cache. When not null, the checksum of the
     * resource is going to be checked
     * @return a locally available resource, if found
     * @throws IOException whenever an error occurs when downloading of fetching from the cache
     */
    @Nullable
    LocallyAvailableExternalResource getResource(URI source, ResourceFileStore fileStore, @Nullable LocallyAvailableResourceCandidates additionalCandidates) throws IOException;

    interface ResourceFileStore {
        /**
         * Called when a resource is to be cached. Should *move* the given file into the appropriate location and return a handle to the file.
         */
        LocallyAvailableResource moveIntoCache(File downloadedResource);
    }
}
