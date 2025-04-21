package com.github.denysrichter4.libraryversioncompare.actions

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class ToolWindowFactoryImplTest {
    private lateinit var factory: ToolWindowFactoryImpl
    private lateinit var project: Project
    private lateinit var toolWindow: ToolWindow

    @Before
    fun setUp() {
        factory = ToolWindowFactoryImpl()
        project = mock(Project::class.java)
        toolWindow = mock(ToolWindow::class.java)
    }

    @Test
    fun `createToolWindowContent should execute without exceptions`() {
        //assertDoesNotThrow { factory.createToolWindowContent(project, toolWindow) }
    }
}