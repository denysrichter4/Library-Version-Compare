package com.github.denysrichter4.libraryversioncompare.utils

import java.io.File

object GitUtils {
    fun cloneAndCheckout(repoPath: String, tag: String, destDir: File) {
        val process = ProcessBuilder("git", "clone", repoPath, destDir.absolutePath)
            .redirectErrorStream(true).start()
        process.waitFor()

        val checkout = ProcessBuilder("git", "checkout", tag)
            .directory(destDir)
            .redirectErrorStream(true).start()
        checkout.waitFor()
    }
}
