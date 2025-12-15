package com.lucas.sportsdemo.api.gameDetailModels

data class Article(
    val byline: String,
    val categories: List<Category>,
    val contentKey: String,
    val dataSourceIdentifier: String,
    val description: String,
    val headline: String,
    val id: Int,
    val images: List<ImageX>,
    val lastModified: String,
    val links: LinksXXXXX,
    val nowId: String,
    val premium: Boolean,
    val published: String,
    val type: String
)