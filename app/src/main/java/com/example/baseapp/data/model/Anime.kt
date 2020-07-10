package com.example.baseapp.data.model
import com.google.gson.annotations.SerializedName


data class Anime(
    @SerializedName("data")
    val `data`: List<Data>
)

data class Data(
    @SerializedName("id")
    val id: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("links")
    val links: Links,
    @SerializedName("attributes")
    val attributes: Attributes
)

data class Links(
    @SerializedName("self")
    val self: String
)

data class Attributes(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("synopsis")
    val synopsis: String,
    @SerializedName("coverImageTopOffset")
    val coverImageTopOffset: Int,
    @SerializedName("titles")
    val titles: Titles,
    @SerializedName("canonicalTitle")
    val canonicalTitle: String,
    @SerializedName("abbreviatedTitles")
    val abbreviatedTitles: Any,
    @SerializedName("averageRating")
    val averageRating: Any,
    @SerializedName("userCount")
    val userCount: Int,
    @SerializedName("favoritesCount")
    val favoritesCount: Int,
    @SerializedName("startDate")
    val startDate: String,
    @SerializedName("endDate")
    val endDate: Any,
    @SerializedName("popularityRank")
    val popularityRank: Int,
    @SerializedName("ratingRank")
    val ratingRank: Any,
    @SerializedName("ageRating")
    val ageRating: Any,
    @SerializedName("ageRatingGuide")
    val ageRatingGuide: String,
    @SerializedName("subtype")
    val subtype: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("posterImage")
    val posterImage: PosterImage,
    @SerializedName("coverImage")
    val coverImage: Any,
    @SerializedName("episodeCount")
    val episodeCount: Int,
    @SerializedName("episodeLength")
    val episodeLength: Int,
    @SerializedName("youtubeVideoId")
    val youtubeVideoId: String,
    @SerializedName("showType")
    val showType: String,
    @SerializedName("nsfw")
    val nsfw: Boolean
)

data class Titles(
    @SerializedName("en")
    val en: String,
    @SerializedName("en_jp")
    val enJp: String,
    @SerializedName("ja_jp")
    val jaJp: String
)

data class PosterImage(
    @SerializedName("original")
    val image: String
)
