/*
 * Copyright 2020 timtb.dev
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package extensions

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler


// Implementation ----------------------------------------------------------------------------------
fun DependencyHandler.implementation(dependencyNotation: String): Dependency? =
    add("implementation", dependencyNotation)

fun DependencyHandler.implementAll(list: List<String>) {
    list.forEach {
        implementation(it)
    }
}

// TestImplementation ------------------------------------------------------------------------------
fun DependencyHandler.testImplementation(dependencyNotation: String): Dependency? =
    add("testImplementation", dependencyNotation)

fun DependencyHandler.testImplementationAll(list: List<String>) {
    list.forEach {
        testImplementation(it)
    }
}

// Kapt --------------------------------------------------------------------------------------------
fun DependencyHandler.kapt(dependencyNotation: String): Dependency? =
    add("kapt", dependencyNotation)

fun DependencyHandler.kaptAll(list: List<String>) {
    list.forEach {
        kapt(it)
    }
}

// AndroidTestImplementation -----------------------------------------------------------------------
fun DependencyHandler.androidTestImplementation(dependencyNotation: String): Dependency? =
    add("androidTestImplementation", dependencyNotation)

fun DependencyHandler.androidTestImplementationAll(list: List<String>) {
    list.forEach {
        androidTestImplementation(it)
    }
}

// API ---------------------------------------------------------------------------------------------
fun DependencyHandler.api(dependencyNotation: String): Dependency? =
    add("api", dependencyNotation)

// DebugImplementation -----------------------------------------------------------------------------
fun DependencyHandler.debugImplementation(dependencyNotation: String): Dependency? =
    add("debugImplementation", dependencyNotation)

fun DependencyHandler.debugImplementationAll(list: List<String>) {
    list.forEach {
        debugImplementation(it)
    }
}