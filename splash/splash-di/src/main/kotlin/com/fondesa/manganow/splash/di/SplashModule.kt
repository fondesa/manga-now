/*
 * Copyright (c) 2019 Fondesa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fondesa.manganow.splash.di

import androidx.lifecycle.LifecycleObserver
import com.fondesa.manganow.splash.impl.SplashActivity
import com.fondesa.manganow.splash.impl.SplashContract
import com.fondesa.manganow.splash.impl.SplashPresenter
import com.fondesa.manganow.ui.di.ScreenScope
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoSet

@Module
interface SplashModule {

    @ScreenScope
    @ContributesAndroidInjector(modules = [ScreenBinds::class])
    fun splashActivity(): SplashActivity

    @Module
    interface ScreenBinds {

        @ScreenScope
        @Binds
        fun provideView(activity: SplashActivity): SplashContract.View

        @ScreenScope
        @Binds
        fun providePresenter(presenter: SplashPresenter): SplashContract.Presenter

        @ScreenScope
        @Binds
        @IntoSet
        fun providePresenterLifecycleObserver(presenter: SplashPresenter): LifecycleObserver
    }
}