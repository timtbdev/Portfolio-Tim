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

package constants

/** Resources ---------------------------------------------------------------------------------- */
object Resources {
    object Default {
        val javaDirs = arrayListOf("src/main/kotlin")
        val resDirs = arrayListOf("src/main/res")
        const val testDir = "src/test/kotlin"
        const val androidTestDir = "src/androidTest/kotlin"
    }
}