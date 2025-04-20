package com.github.denysrichter4.libraryversioncompare.utils

import com.intellij.openapi.project.Project
import java.io.File

class LibraryComparator(
    private val project: Project,
    private val repoPath: String,
    private val adaptedPath: String,
    private val oldTag: String,
    private val newTag: String
) {
    fun compare(): List<Pair<File, File>> {
        val tempDir = File.createTempFile("libCompare", "").apply {
            delete()
            mkdirs()
        }

        val oldVersionDir = File(tempDir, "old").also { it.mkdirs() }
        val newVersionDir = File(tempDir, "new").also { it.mkdirs() }
        val adaptedDir = File(adaptedPath)

        return try {
            GitUtils.cloneAndCheckout(repoPath, oldTag, oldVersionDir)
            GitUtils.cloneAndCheckout(repoPath, newTag, newVersionDir)
            FileDiffScanner.scanDifferences(repoPath, oldVersionDir, newVersionDir, adaptedDir)
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        } finally {
            tempDir.deleteRecursively()
        }
    }
}
