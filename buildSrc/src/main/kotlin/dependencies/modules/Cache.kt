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

package dependencies.modules

import dependencies.Androidx
import dependencies.Kotlin
import interfaces.DepsTestsKapts

object Cache : DepsTestsKapts {

    // Dependencies --------------------------------------------------------------------------------
    override val dependencies: List<String>
        get() = listOf(
            Kotlin.dependencies,
            Androidx.Room.dependencies,
            Androidx.DaggerHilt.dependencies
        ).flatten()

    // Tests ---------------------------------------------------------------------------------------
    override val tests: List<String>
        get() = listOf(
            Kotlin.tests,
            listOf(Androidx.Room.test)
        ).flatten()

    // Kapts ---------------------------------------------------------------------------------------
    override val kapts: List<String>
        get() = listOf(
            Androidx.Room.kapt,
            Androidx.DaggerHilt.kapt
        )
}