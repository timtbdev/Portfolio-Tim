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

package dependencies

import constants.Libs
import constants.Versions
import interfaces.DepsTests

object Kotlin : DepsTests {
    // Libraries -----------------------------------------------------------------------------------
    private const val KOTLIN = Libs.KOTLIN + Versions.KOTLIN
    private const val KOTLIN_JUNIT = Libs.KOTLIN_JUNIT + Versions.KOTLIN

    // Dependencies --------------------------------------------------------------------------------
    override val dependencies: List<String>
        get() = listOf(KOTLIN)

    // Tests ---------------------------------------------------------------------------------------
    override val tests: List<String>
        get() = listOf(KOTLIN_JUNIT)
}