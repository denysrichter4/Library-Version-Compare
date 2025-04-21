package com.github.denysrichter4.libraryversioncompare.actions

import com.github.denysrichter4.libraryversioncompare.dialog.CompareLibDialog
import com.github.denysrichter4.libraryversioncompare.model.FileDiffInfo
import com.github.denysrichter4.libraryversioncompare.utils.LibraryComparator
import com.intellij.ide.util.PropertiesComponent
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.ui.components.JBList
import org.junit.Before

class CompareActionTest {
    private lateinit var action: CompareAction
    private lateinit var event: AnActionEvent
    private lateinit var properties: PropertiesComponent
    private lateinit var dialog: CompareLibDialog
    private lateinit var comparator: LibraryComparator
    private lateinit var list: JBList<FileDiffInfo>

    @Before
    fun setUp() {
        /*MockitoAnnotations.openMocks(this)
        properties = mock(PropertiesComponent::class.java)
        dialog = mock(CompareLibDialog::class.java)
        comparator = mock(LibraryComparator::class.java)
        list = mock(JBList::class.java) as JBList<FileDiffInfo>
        event = mock(AnActionEvent::class.java)

        action = CompareAction(list)

        `when`(PropertiesComponent.getInstance()).thenReturn(properties)*/
    }

    /*@Test
    fun `should do nothing when dialog is cancelled`() {
        `when`(dialog.showAndGet()).thenReturn(false)

        action.actionPerformed(event)

        verify(properties, never()).setValue(anyString(), anyString())
        verify(list, never()).setListData(arrayOf())
    }*/

    /*@Test
    fun `should show info message when no differences are found`() {
        `when`(dialog.showAndGet()).thenReturn(true)
        `when`(comparator.compare()).thenReturn(emptyList())

        action.actionPerformed(event)

        verify(properties).setValue("repoPath", dialog.repoPath)
        verify(properties).setValue("adaptedPath", dialog.adaptedPath)
        verify(properties).setValue("oldTag", dialog.oldTag)
        verify(properties).setValue("newTag", dialog.newTag)
        verify(list, never()).setListData(arrayOf())
        Messages.showInfoMessage("No differences found between the versions.", "Compare Result")
    }*/

    /*@Test
    fun `should update list when differences are found`() {
        val diffFiles = listOf(
            Pair(mock(File::class.java), mock(File::class.java))
        )
        `when`(dialog.showAndGet()).thenReturn(true)
        `when`(comparator.compare()).thenReturn(diffFiles)

        action.actionPerformed(event)

        verify(properties).setValue("repoPath", dialog.repoPath)
        verify(properties).setValue("adaptedPath", dialog.adaptedPath)
        verify(properties).setValue("oldTag", dialog.oldTag)
        verify(properties).setValue("newTag", dialog.newTag)
        verify(list).setListData(arrayOf())
        Messages.showInfoMessage(anyString(), anyString())
    }*/

}