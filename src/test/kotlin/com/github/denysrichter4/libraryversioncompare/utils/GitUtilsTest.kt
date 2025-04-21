package com.github.denysrichter4.libraryversioncompare.utils

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertTrue
import java.io.File
import kotlin.io.path.createTempDirectory

class GitUtilsTest {
    @Test
    fun `cloneAndCheckout should clone and checkout repository`() {
        val tempDir = createTempDirectory().toFile()
        val repoPath = "./"
        val tag = "v1.0.0"

        try {
            GitUtils.cloneAndCheckout(repoPath, tag, tempDir)
            assertTrue(File(tempDir, ".git").exists(), "Repository should be cloned")
        } finally {
            tempDir.deleteRecursively()
        }
    }
}