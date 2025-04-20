package com.github.denysrichter4.libraryversioncompare.actions

import com.github.denysrichter4.libraryversioncompare.model.FileDiffInfo
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.ui.components.JBList
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

class ClearActionTest {

    @Test
    fun `should clear the list when actionPerformed is called`() {
        // Arrange
        val mockList = mock(JBList::class.java) as JBList<FileDiffInfo>
        val mockEvent = mock(AnActionEvent::class.java)
        val action = ClearAction(mockList)

        // Act
        action.actionPerformed(mockEvent)

        // Assert
        verify(mockList).setListData(emptyArray())
    }
}