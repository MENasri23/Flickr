package com.example.data.source.remote

interface QueryParams<K, V> {

    fun getParams(): Map<K, V>
}


data class FlickrQueryParams(
    val method: String,
    val userId: String,
    val extras: String,
    val format: String,
    val noJsonCallback: Int,
    val perPage: Int,
    val page: Int,
) : QueryParams<String, String> {

    private val params = hashMapOf(
        PARAM_METHOD to method,
        PARAM_USER_ID to userId,
        PARAM_EXTRAS to extras,
        PARAM_FORMAT to format,
        PARAM_NO_JSON_CALLBACK to noJsonCallback.toString(),
        PARAM_PER_PAGE to perPage.toString(),
        PARAM_PAGE to page.toString()
    )

    override fun getParams(): Map<String, String> {
        return params
    }

    fun get(key: String) = params[key]

    fun put(param: Pair<String, String>) {
        params[param.first] = param.second
    }

    class Builder() {

        var method: String? = null
        var userId: String? = null
        var extras: String? = null
        var format: String? = null
        var noJsonCallback: Int = 1
        var perPage: Int = 30
        var page: Int = 1

        var text: String? = null

        constructor(flickrQueryParams: FlickrQueryParams) : this() {
            flickrQueryParams.let { params ->
                method = params.method
                userId = params.userId
                extras = params.extras
                format = params.format
                noJsonCallback = params.noJsonCallback
                perPage = params.perPage
                page = params.page
                text = params.get(PARAM_TEXT)
            }
        }


        fun build(): FlickrQueryParams {
            return FlickrQueryParams(
                method ?: "flickr.photos.getPopular",
                userId ?: "34427466731@N01",
                extras ?: "url_s",
                format ?: "json",
                noJsonCallback,
                perPage,
                page
            ).apply { text?.let { put(PARAM_TEXT to it) } }
        }

    }

    fun buildNew(queryBuilder: Builder.() -> Unit) = Builder(this)
        .apply(queryBuilder).build()


    companion object {
        const val PARAM_METHOD = "method"
        const val PARAM_USER_ID = "user_id"
        const val PARAM_EXTRAS = "extras"
        const val PARAM_FORMAT = "format"
        const val PARAM_NO_JSON_CALLBACK = "nojsoncallback"
        const val PARAM_PER_PAGE = "perpage"
        const val PARAM_PAGE = "page"
        const val PARAM_TEXT = "text"
    }

}

fun flickrQueryParams(queryBuilder: FlickrQueryParams.Builder.() -> Unit): FlickrQueryParams {
    return FlickrQueryParams.Builder().apply(queryBuilder).build()
}
