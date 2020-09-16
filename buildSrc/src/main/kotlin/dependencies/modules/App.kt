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
import dependencies.Firebase
import dependencies.Kotlin
import dependencies.Utils
import interfaces.DepsAndroidTestsKapts

object App : DepsAndroidTestsKapts {
    // Dependencies --------------------------------------------------------------------------------
    override val dependencies: List<String>
        get() = listOf(
            Kotlin.dependencies,
            listOf(
                Androidx.KTX,
                Androidx.LiveData.dependency,
                Androidx.WorkManager.dependency,
                Androidx.APP_STARTUP,
                Utils.LEAK_CANARY,
                Utils.TIMBER
            ),
            Androidx.Layout.dependencies,
            Androidx.ViewModel.dependencies,
            Androidx.Compose.dependencies,
            Androidx.Navigation.dependencies,
            Androidx.DaggerHilt.dependencies,
            Androidx.DynamicFeature.dependencies,
            Androidx.DataStore.dependencies,
            Firebase.dependencies
        ).flatten()

    // Tests ---------------------------------------------------------------------------------------
    override val tests: List<String>
        get() = listOf(
            listOf(Androidx.Compose.test, Androidx.LiveData.test),
            Kotlin.tests
        ).flatten()

    // AndroidTests --------------------------------------------------------------------------------
    override val androidTests: List<String>
        get() = listOf(Androidx.Navigation.androidTest, Androidx.WorkManager.androidTest)

    // Kapts ---------------------------------------------------------------------------------------
    override val kapts: List<String>
        get() = listOf(Androidx.LiveData.kapt, Androidx.DaggerHilt.kapt)
}