/*
 * Copyright (c) 2018 Fondesa
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

package com.fondesa.manganow.manga.list

import com.fondesa.manganow.ui.mvp.BasePresenter

/**
 * Used to specify the contract between the view and the presenter for the manga list section.
 */
object MangaListContract {

    /**
     * Specify the view methods for the manga list section.
     */
    interface View {

    }

    /**
     * Specify the presenter methods for the manga list section linked to [View].
     */
    interface Presenter : BasePresenter<View> {

    }
}