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
    const val STDLIB = Libs.KOTLIN_STDLIB + Versions.KOTLIN
    const val JUNIT = Libs.KOTLIN_JUNIT + Versions.KOTLIN

    object Coroutines {
        const val CORE = Libs.COROUTINES_CORE + Versions.COROUTINES
        const val ANDROID = Libs.COROUTINES_ANDROID + Versions.COROUTINES
        const val TEST = Libs.COROUTINES_TEST + Versions.COROUTINES
    }

    override val dependencies: List<String>
        get() = listOf(
            STDLIB,
            Coroutines.CORE,
            Coroutines.ANDROID
        )
    override val tests: List<String>
        get() = listOf(
            JUNIT,
            Coroutines.TEST
        )

}