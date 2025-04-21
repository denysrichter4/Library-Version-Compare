package com.github.denysrichter4.libraryversioncompare.actions

import com.github.denysrichter4.libraryversioncompare.model.FileDiffInfo
import com.intellij.diff.DiffContentFactory
import com.intellij.diff.DiffManager
import com.intellij.diff.requests.SimpleDiffRequest
import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.actionSystem.ActionToolbar
import com.intellij.openapi.actionSystem.DefaultActionGroup
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.ui.SimpleToolWindowPanel
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.SimpleListCellRenderer
import com.intellij.ui.components.JBList
import com.intellij.ui.components.JBScrollPane
import java.io.File

class ToolWindowFactoryImpl : ToolWindowFactory {

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val panel = SimpleToolWindowPanel(true, true)

        val fileList = JBList<FileDiffInfo>()
        fileList.cellRenderer = SimpleListCellRenderer.create { label, value, _ ->
            if (value != null) {
                label.icon = AllIcons.FileTypes.Any_type
                label.text = value.fileName
                label.toolTipText = "Library:\n${value.libraryPath}\n\nAdapted:\n${value.adaptedPath}"

                label.foreground = if (value.existsInAdapted) label.foreground else java.awt.Color.RED
                label.font = label.font.deriveFont(java.awt.Font.BOLD)
            }
        }

        fileList.addListSelectionListener { event ->
            if (!event.valueIsAdjusting) {
                val selected = fileList.selectedValue
                if (selected != null) {
                    val libFile = File(selected.libraryPath)
                    val adaptedFile = File(selected.adaptedPath)
                    openFileDiffView(project, adaptedFile, libFile)
                }
            }
        }

        val actionGroup = DefaultActionGroup()
        actionGroup.add(CompareAction(fileList))
        actionGroup.add(ClearAction(fileList))

        val actionToolbar: ActionToolbar = ActionManager.getInstance().createActionToolbar("LibraryVersionCompare", actionGroup, true)
        actionToolbar.targetComponent = panel

        val scrollPane = JBScrollPane(fileList)

        panel.toolbar = actionToolbar.component
        panel.setContent(scrollPane)

        val contentManager = toolWindow.contentManager
        val content = contentManager.factory.createContent(panel, "Differences", false)
        contentManager.addContent(content)
    }

    private fun openFileDiffView(project: Project?, adaptedFile: File, libFile: File) {
        val libVirtualFile = LocalFileSystem.getInstance().findFileByIoFile(libFile)
        val adaptedVirtualFile = LocalFileSystem.getInstance().findFileByIoFile(adaptedFile)

        if (libVirtualFile == null || adaptedVirtualFile == null) {
            Messages.showErrorDialog(
                "Unable to locate the files for comparison:\n" +
                        "Library file: ${libFile.absolutePath}\n" +
                        "Adapted file: ${adaptedFile.absolutePath}",
                "Error"
            )
            return
        }

        val libContent = DiffContentFactory.getInstance().create(project, libVirtualFile)
        val adaptedContent = DiffContentFactory.getInstance().create(project, adaptedVirtualFile)

        val request = SimpleDiffRequest(
            "Differences: ${adaptedFile.name}",
            libContent,
            adaptedContent,
            "Library version",
            "Adapted version"
        )

        DiffManager.getInstance().showDiff(project, request)

    }
}