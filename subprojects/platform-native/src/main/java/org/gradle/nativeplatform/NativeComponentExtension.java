/*
 * Copyright 2014 the original author or authors.
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

package org.gradle.nativeplatform;

import org.gradle.api.Action;
import org.gradle.api.Incubating;
import org.gradle.api.NamedDomainObjectContainer;

/**
 * The configuration for native components generated by this build.
 */
@Incubating
public interface NativeComponentExtension {
    /**
     * The {@link NativeExecutableSpec} components produced by the build.
     */
    NamedDomainObjectContainer<NativeExecutableSpec> getExecutables();

    /**
     * Configure the {@link NativeExecutableSpec} components produced by the build.
     */
    void executables(Action<? super NamedDomainObjectContainer<? super NativeExecutableSpec>> action);

    /**
     * The {@link NativeLibrarySpec} components produced by the build.
     */
    NamedDomainObjectContainer<NativeLibrarySpec> getLibraries();

    /**
     * Configure the {@link NativeLibrarySpec} components produced by the build.
     */
    void libraries(Action<? super NamedDomainObjectContainer<? super NativeLibrarySpec>> action);
}
