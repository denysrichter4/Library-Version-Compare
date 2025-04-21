package com.github.denysrichter4.libraryversioncompare.model

import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue

class FileDiffInfoTest {
    private lateinit var fileDiffInfo: FileDiffInfo

    @Before
    fun setUp() {
        fileDiffInfo = FileDiffInfo("libraryPath", "adaptedPath", "fileName", true)
    }

    @Test
    fun `getLibraryPath should return correct value`() {
        assertEquals("libraryPath", fileDiffInfo.libraryPath)
    }

    @Test
    fun `getAdaptedPath should return correct value`() {
        assertEquals("adaptedPath", fileDiffInfo.adaptedPath)
    }

    @Test
    fun `getFileName should return correct value`() {
        assertEquals("fileName", fileDiffInfo.fileName)
    }

    @Test
    fun `getExistsInAdapted should return correct value`() {
        assertTrue(fileDiffInfo.existsInAdapted)
    }

    @Test
    fun `equals should return true for identical objects`() {
        val other = FileDiffInfo("libraryPath", "adaptedPath", "fileName", true)
        assertEquals(fileDiffInfo, other)
    }

}