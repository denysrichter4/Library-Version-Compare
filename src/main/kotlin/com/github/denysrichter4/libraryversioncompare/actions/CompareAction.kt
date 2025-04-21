package com.github.denysrichter4.libraryversioncompare.actions

import com.github.denysrichter4.libraryversioncompare.dialog.CompareLibDialog
import com.github.denysrichter4.libraryversioncompare.model.FileDiffInfo
import com.github.denysrichter4.libraryversioncompare.utils.LibraryComparator
import com.intellij.icons.AllIcons
import com.intellij.ide.util.PropertiesComponent
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages
import com.intellij.ui.components.JBList

class CompareAction(
    private val list: JBList<FileDiffInfo> = JBList()
) : AnAction("Compare", "Libraries compare", AllIcons.Actions.Diff) {
    override fun actionPerformed(e: AnActionEvent) {
        val properties = PropertiesComponent.getInstance()
        val dialog = CompareLibDialog(
            defaultRepoPath = properties.getValue("repoPath", ""),
            defaultAdaptedPath = properties.getValue("adaptedPath", ""),
            defaultOldTag = properties.getValue("oldTag", ""),
            defaultNewTag = properties.getValue("newTag", "")
        )
        if (dialog.showAndGet()) {
            properties.setValue("repoPath", dialog.repoPath)
            properties.setValue("adaptedPath", dialog.adaptedPath)
            properties.setValue("oldTag", dialog.oldTag)
            properties.setValue("newTag", dialog.newTag)

            val comparator = LibraryComparator(
                dialog.repoPath,
                dialog.adaptedPath,
                dialog.oldTag,
                dialog.newTag
            )

            val diffFiles = comparator.compare()
            if (diffFiles.isEmpty()) {
                Messages.showInfoMessage("No differences found between the versions.", "Compare Result")
            } else {
                val diffInfos = diffFiles.map {
                    FileDiffInfo(it.first.absolutePath, it.second.absolutePath, it.first.name)
                }
                list.setListData(diffInfos.toTypedArray())
            }
        }
    }
}