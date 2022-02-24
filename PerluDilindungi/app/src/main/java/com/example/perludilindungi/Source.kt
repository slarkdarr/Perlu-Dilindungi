package com.example.perludilindungi

class Source {
    constructor()
    var title: String = ""
    var url: String = ""

    fun setNewsTitle(str: String) {
        this.title = str
    }

    fun setNewsUrl(link: String) {
        this.url = link
    }

    fun getNewsTitle() : String {
        return this.title
    }

    fun getNewsUrl() : String {
        return this.url
    }


}