package com.example.perludilindungi


class NewsHeadlines {
    constructor()
    var source: Source = Source()
    var title: String = ""
    var url: String = ""
    var urlToImg = ""
    var headlinePubDate = ""
    var content = ""

    fun setHeadlineSource(src: Source) {
        this.source = src
    }

    fun setHeadlineTitle(ttl: String) {
        this.title = ttl
    }

    fun setHeadlineUrl(url: String) {
        this.url = url
    }

    fun setHeadlineUrlToImg(urlImg: String) {
        this.urlToImg = urlImg
    }

    fun setPubDate(date: String) {
        this.headlinePubDate = date
    }

    fun setHeadlineContent(content: String) {
        this.content = content
    }

    fun getHeadlineSource(): String {
        return this.source
    }

    fun getHeadlineTitle(): String {
        return this.title
    }

    fun getHeadlineUrl(): String {
        return this.url
    }

    fun getHeadlineUrlToImg(): String {
        return this.urlToImg
    }

    fun getPubDate(): String {
        return this.headlinePubDate
    }

    fun getHeadlineContent(): String {
        return this.content
    }
}