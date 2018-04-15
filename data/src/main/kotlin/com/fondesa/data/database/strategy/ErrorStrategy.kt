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

package com.fondesa.data.database.strategy

import com.fondesa.data.database.Database

/**
 * Used to define an action to take when database corruption is detected.
 */
interface ErrorStrategy {

    /**
     * Invoked when database corruption is detected.
     *
     * @param database [Database] object representing the database on which corruption
     * is detected.
     */
    fun onCorruption(database: Database)
}