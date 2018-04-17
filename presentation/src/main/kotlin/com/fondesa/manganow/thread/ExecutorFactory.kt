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

package com.fondesa.manganow.thread

/**
 * Factory used to create an [Executor.Builder].
 */
interface ExecutorFactory {

    /**
     * Creates an [Executor.Builder].
     *
     * @param executionBlock block used to execute the operation.
     * @param T the type of the operation's output which will be returned to the optional [CompletedBlock].
     * @return new instance of an [Executor.Builder].
     */
    fun <T> create(executionBlock: ExecutionBlock<T>): Executor.Builder<T>
}