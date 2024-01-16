package com.example.test.Models

data class TVShow(
    val score: Double=0.0,
    val show: ShowDetails
)

data class ShowDetails(
    val id: Int=0,
    val url: String="",
    val name: String="",
    val type: String="",
    val language: String="",
    val genres: List<String>,
    val status: String="",
    val runtime: Int=0,
    val averageRuntime: Int=0,
    val premiered: String="",
    val ended: String="",
    val officialSite: String="",
    val schedule: Schedule,
    val rating: Rating,
    val weight: Int=0,
    val network: Network?,
    val webChannel: WebChannel?,
    val dvdCountry: String="",
    val externals: Externals,
    val image: Image,
    val summary: String="",
    val updated: Long=0L,
    val _links: Links
)

data class Schedule(
    val time: String="",
    val days: List<String>
)

data class Rating(
    val average: Double=0.0
)

data class Network(
    val id: Int=0,
    val name: String="",
    val country: Country,
    val officialSite: String=""
)

data class Country(
    val name: String="",
    val code: String="",
    val timezone: String=""
)

data class WebChannel(
    val id: Int=0,
    val name: String="",
    val country: Country,
    val officialSite: String=""
)

data class Externals(
    val tvrage: Int=0,
    val thetvdb: Int=0,
    val imdb: String=""
)

data class Image(
    val medium: String="",
    val original: String=""
)

data class Links(
    val self: Self,
    val previousepisode: Previousepisode
)

data class Self(
    val href: String=""
)

data class Previousepisode(
    val href: String=""
)
