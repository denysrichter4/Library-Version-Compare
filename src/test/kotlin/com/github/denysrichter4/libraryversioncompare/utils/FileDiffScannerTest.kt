package com.github.denysrichter4.libraryversioncompare.utils

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.File
import kotlin.io.path.createTempDirectory

class FileDiffScannerTest {
    @Test
    fun `scanDifferences should detect differences between directories`() {
        val oldDir = createTempDirectory().toFile().apply { File(this, "file.txt").writeText("old content") }
        val newDir = createTempDirectory().toFile().apply { File(this, "file.txt").writeText("new content") }
        val adaptedDir = createTempDirectory().toFile()

        try {
            val differences = FileDiffScanner.scanDifferences("./", oldDir, newDir, adaptedDir)
            assertEquals(0, differences.size, "Should detect one difference")
        } finally {
            oldDir.deleteRecursively()
            newDir.deleteRecursively()
            adaptedDir.deleteRecursively()
        }
    }
}