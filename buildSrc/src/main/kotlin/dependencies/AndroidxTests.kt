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

object AndroidxTests {

    // Libraries -----------------------------------------------------------------------------------

    // Architecture Components
    private const val ARCH_TEST = Libs.ARCH_TEST + Versions.ARCH_TEST
    private const val FRAGMENT_TEST = Libs.FRAGMENT_TEST + Versions.FRAGMENT
    private const val NAV_TEST = Libs.NAV_TEST + Versions.NAVIGATION
    private const val ROOM_TEST = Libs.ROOM_TEST + Versions.ROOM
    private const val WORK_TEST = Libs.WORK_TEST + Versions.WORK

    // AndroidX UnitRunner and JUnit Rules
    private const val TEST_CORE = Libs.TEST_CORE + Versions.TEST_CORE
    private const val TEST_RUNNER = Libs.TEST_RUNNER + Versions.JUNIT_RULES
    private const val TEST_RULES = Libs.TEST_RULES + Versions.JUNIT_RULES

    // Assertions
    private const val TEST_JUNIT_KTX = Libs.JUNIT_JUPITER_API + Versions.TEST_CORE
    private const val GOOGLE_TRUTH = Libs.GOOGLE_TRUTH + Versions.GOOGLE_TRUTH
    private const val TRUTH_KTX = Libs.TRUTH_KTX + Versions.TEST_CORE

    // UI
    private const val ESPRESSO_CORE = Libs.ESPRESSO_CORE + Versions.ESPRESSO
    private const val ESPRESSO_CONTRIB = Libs.ESPRESSO_CONTRIB + Versions.ESPRESSO
    private const val ESPRESSO_IDLING_RESOURCE = Libs.ESPRESSO_IDLING_RESOURCE + Versions.ESPRESSO
}