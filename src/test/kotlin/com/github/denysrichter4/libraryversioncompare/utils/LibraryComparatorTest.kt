package com.github.denysrichter4.libraryversioncompare.utils

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull
import kotlin.io.path.createTempDirectory

class LibraryComparatorTest {
    @Test
    fun `compare should return differences between library versions`() {
        val repoPath = "./"
        val adaptedPath = createTempDirectory().toFile().absolutePath
        val oldTag = "v1.0.0"
        val newTag = "v2.0.0"

        val comparator = LibraryComparator(repoPath, adaptedPath, oldTag, newTag)
        val differences = comparator.compare()

        assertNotNull(differences, "Differences should not be null")
    }
}