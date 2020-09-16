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
import interfaces.AndroidTests

object AndroidxTests : AndroidTests {

    // AndroidX UnitRunner and JUnit Rules
    private const val TEST_CORE = Libs.TEST_CORE + Versions.TEST_CORE
    private const val TEST_RUNNER = Libs.TEST_RUNNER + Versions.JUNIT_RULES
    private const val TEST_RULES = Libs.TEST_RULES + Versions.JUNIT_RULES

    // Assertions
    private const val TEST_JUNIT = Libs.JUNIT_JUPITER_API + Versions.TEST_CORE
    private const val GOOGLE_TRUTH = Libs.GOOGLE_TRUTH + Versions.GOOGLE_TRUTH
    private const val TRUTH = Libs.TRUTH + Versions.TEST_CORE

    // UI
    private const val ESPRESSO_CORE = Libs.ESPRESSO_CORE + Versions.ESPRESSO
    private const val ESPRESSO_CONTRIB = Libs.ESPRESSO_CONTRIB + Versions.ESPRESSO
    private const val ESPRESSO_IDLING_RESOURCE = Libs.ESPRESSO_IDLING_RESOURCE + Versions.ESPRESSO

    // AndroidTests dependencies -------------------------------------------------------------------
    override val androidTests: List<String>
        get() = listOf(
            TEST_CORE,
            TEST_RUNNER,
            TEST_RULES,
            TEST_JUNIT,
            GOOGLE_TRUTH,
            TRUTH,
            ESPRESSO_CORE,
            ESPRESSO_CONTRIB,
            ESPRESSO_IDLING_RESOURCE
        )
}