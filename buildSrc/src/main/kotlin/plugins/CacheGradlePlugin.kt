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

package plugins

import constants.ModuleBuildType.AndroidLibrary
import constants.ModuleType.CacheModule
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.invoke
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

open class CacheGradlePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.configurePlugins(AndroidLibrary)
        project.configureAndroid(AndroidLibrary)
        project.configureDependencies(CacheModule)

        project.afterEvaluate {
            with(project) {
                tasks {
                    withType<KotlinCompile> {
                        with(kotlinOptions) {
                            jvmTarget = JavaVersion.VERSION_1_8.toString()
                            freeCompilerArgs = listOf(
                                "-Xallow-result-return-type",
                                "-Xuse-experimental=",
                                "kotlin.Experimental,",
                                "kotlinx.coroutines.ExperimentalCoroutinesApi,",
                                "kotlinx.coroutines.InternalCoroutinesApi,",
                                "kotlinx.coroutines.FlowPreview"
                            )
                        }
                    }
                }
            }
        }

    }
}