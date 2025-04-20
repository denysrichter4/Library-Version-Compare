package com.github.denysrichter4.libraryversioncompare.model

data class FileDiffInfo(
    val libraryPath: String,
    val adaptedPath: String,
    val fileName: String,
    val existsInAdapted: Boolean = true
)
