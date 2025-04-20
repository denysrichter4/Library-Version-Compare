package com.github.denysrichter4.libraryversioncompare.actions

import com.github.denysrichter4.libraryversioncompare.model.FileDiffInfo
import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.ui.components.JBList

class ClearAction(
    private val list: JBList<FileDiffInfo> = JBList()
) : AnAction("Clear", "Clean list", AllIcons.Actions.GC) {
    override fun actionPerformed(e: AnActionEvent) {
        list.setListData(emptyArray())
    }
}