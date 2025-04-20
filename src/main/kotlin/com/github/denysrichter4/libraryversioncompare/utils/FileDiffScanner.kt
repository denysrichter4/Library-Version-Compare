package com.github.denysrichter4.libraryversioncompare.utils

import java.io.File

object FileDiffScanner {

    fun scanDifferences(
        repoPath: String,
        oldVersionDir: File,
        newVersionDir: File,
        adaptedDir: File
    ): List<Pair<File, File>> {
        val allRelativePaths = mutableSetOf<String>()

        collectRelativePaths(oldVersionDir, allRelativePaths)
        collectRelativePaths(newVersionDir, allRelativePaths)

        val diffBetweenLibVersions = allRelativePaths.filter { relativePath ->
            val oldFile = File(oldVersionDir, relativePath)
            val newFile = File(newVersionDir, relativePath)
            hasDiff(oldFile, newFile)
        }

        return diffBetweenLibVersions.mapNotNull { relativePath ->
            val newFile = File(newVersionDir, relativePath)

            val adaptedFile = adaptedDir.walkTopDown().find { adaptedFile ->
                adaptedFile.isFile && adaptedFile.nameWithoutExtension.contains(File(relativePath).nameWithoutExtension, ignoreCase = true)
            }

            if (adaptedFile != null && hasDiff(newFile, adaptedFile)) {
                val repoFile = File(repoPath, relativePath)
                repoFile to adaptedFile
            } else {
                null
            }
        }
    }

    private fun collectRelativePaths(baseDir: File, collector: MutableSet<String>) {
        baseDir.walkTopDown().forEach { file ->
            if (file.isFile) {
                val relativePath = file.relativeTo(baseDir).path.replace("\\", "/")
                collector.add(relativePath)
            }
        }
    }

    private fun hasDiff(file1: File, file2: File): Boolean {
        if (!file1.exists() || !file2.exists()) return true
        if (file1.length() != file2.length()) return true

        return file1.readBytes().contentEquals(file2.readBytes()).not()
    }
}
