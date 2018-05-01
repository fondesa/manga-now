package com.fondesa.data.remote

import com.fondesa.domain.sortorder.model.SortOrder
import com.fondesa.remote.task.RemoteTask
import com.google.gson.JsonElement

/**
 * APIs for requests to MangaNow's webservice.
 */
object RemoteApi {

    /**
     * Keys used in the body of the requests or in query string.
     */
    object Key {
        const val PAGE = "page"
        const val PAGE_SIZE = "pageSize"
        const val SORT_ORDER_ID = "sortOrderId"
        const val TEXT_FILTER = "textFilter"
    }

    /**
     * Default values used in the body of the requests or in query string.
     */
    object Values {
    }

    /**
     * Constant paths appended to the base url.
     */
    object Path {
        const val CATEGORIES = "categories"
        const val SORT_ORDERS = "sortorders"
        const val LATEST = "latest"
        const val MANGA_LIST = "mangalist"
    }

    /**
     * Wrapper containing built-in requests to use through the application lifetime.
     */
    object Request {
        fun categories(): RemoteTask = Task.Get(Path.CATEGORIES)

        fun sortOrders(): RemoteTask = Task.Get(Path.SORT_ORDERS)

        fun latest(page: Int, pageSize: Int): RemoteTask {
            val queryParams = queryMap {
                put(Key.PAGE, page.toString())
                put(Key.PAGE_SIZE, pageSize.toString())
            }
            return Task.Get(Path.LATEST, queryParams)
        }

        fun mangaList(
            page: Int,
            pageSize: Int,
            sortOrder: SortOrder? = null,
            textFilter: String? = null
        ): RemoteTask {
            val queryParams = queryMap {
                put(Key.PAGE, page.toString())
                put(Key.PAGE_SIZE, pageSize.toString())
                sortOrder?.let {
                    put(Key.SORT_ORDER_ID, it.id.toString())
                }
                textFilter?.let {
                    put(Key.TEXT_FILTER, it)
                }
            }
            return Task.Get(Path.MANGA_LIST, queryParams)
        }

        private fun queryMap(values: MutableMap<String, String>.() -> Unit) =
            mutableMapOf<String, String>().apply(values)
    }

    /**
     * Common [RemoteTask]'s configurations used for requests.
     */
    object Task {

        /**
         * Implementation of [RemoteTask] for a GET request.
         *
         * @param apiPath the API path used for the request.
         * @param queryParams key-value params that will be added in query string.
         */
        data class Get(
            private val apiPath: String,
            private val queryParams: Map<String, String> = emptyMap()
        ) : BaseTask() {

            override fun apiPath(): String = apiPath

            override fun method() = RemoteTask.Method.GET

            override fun queryParams() = queryParams

            override fun body(): JsonElement? = null

            override fun headers(): Map<String, String> = emptyMap()
        }

        data class ImageTask(private val imageUrl: String) : RemoteTask {

            override fun method() = RemoteTask.Method.GET

            override fun scheme() = "https"

            override fun host() = "cdn.mangaeden.com"

            override fun path() = "mangasimg/$imageUrl"

            override fun headers(): Map<String, String> = emptyMap()

            override fun queryParams(): Map<String, String> = emptyMap()

            override fun body(): JsonElement? = null
        }

        /**
         * Implementation of [RemoteTask] that defines the configurations in common for all tasks.
         */
        abstract class BaseTask : RemoteTask {

            override fun scheme() = "http"

            override fun host() = "192.168.1.3"

            override fun path() = "api/${apiPath()}"

            override fun port() = 8080

            /**
             * @return path that will be appended to the root path of the APIs.
             */
            abstract fun apiPath(): String
        }
    }
}