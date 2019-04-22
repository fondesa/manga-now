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

package com.fondesa.manganow.injection.database

import com.fondesa.data.chapter.ChapterTableModule
import com.fondesa.data.latest.database.LatestTableModule
import com.fondesa.data.manga.database.MangaTableModule
import com.fondesa.data.remote.database.RemoteTaskTableModule
import com.fondesa.data.sortorder.database.SortOrderTableModule
import com.fondesa.manganow.domain.category.CategoryTableModule
import dagger.Module

@Module(
    includes = [
        LatestTableModule::class,
        SortOrderTableModule::class,
        MangaTableModule::class,
        ChapterTableModule::class,
        RemoteTaskTableModule::class,
        CategoryTableModule::class
    ]
)
interface DatabaseTablesModule