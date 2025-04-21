package com.github.denysrichter4.libraryversioncompare.dialog

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.openapi.ui.TextComponentAccessor
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import java.awt.GridLayout
import javax.swing.*

class CompareLibDialog(
    private val defaultRepoPath: String = "",
    private val defaultAdaptedPath: String = "",
    defaultOldTag: String = "",
    defaultNewTag: String = ""
) : DialogWrapper(true) {
    private val repoPathField = TextFieldWithBrowseButton().apply { text = defaultRepoPath }
    private val adaptedPathField = TextFieldWithBrowseButton().apply { text = defaultAdaptedPath }
    private val oldTagField = JTextField(defaultOldTag)
    private val newTagField = JTextField(defaultNewTag)

    init {
        init()
        title = "Configure Library Comparison"

        repoPathField.addBrowseFolderListener(
             null,
            FileChooserDescriptorFactory.createSingleFolderDescriptor(),
            TextComponentAccessor.TEXT_FIELD_WHOLE_TEXT
        )

        adaptedPathField.addBrowseFolderListener(
             null,
            FileChooserDescriptorFactory.createSingleFolderDescriptor(),
            TextComponentAccessor.TEXT_FIELD_WHOLE_TEXT
        )
    }

    override fun createCenterPanel(): JComponent {
        val panel = JPanel(GridLayout(4, 2, 10, 10))
        panel.add(JLabel("Library repository path:"))
        panel.add(repoPathField)

        panel.add(JLabel("Local adapted version path:"))
        panel.add(adaptedPathField)

        panel.add(JLabel("Old version tag/branch:"))
        panel.add(oldTagField)

        panel.add(JLabel("New version tag/branch:"))
        panel.add(newTagField)

        return panel
    }

    val repoPath: String get() = repoPathField.text.trim()
    val adaptedPath: String get() = adaptedPathField.text.trim()
    val oldTag: String get() = oldTagField.text.trim()
    val newTag: String get() = newTagField.text.trim()

    override fun doOKAction() {
        if (repoPath.isEmpty() || adaptedPath.isEmpty() || oldTag.isEmpty() || newTag.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields must be filled.", "Error", JOptionPane.ERROR_MESSAGE)
            return
        }
        super.doOKAction()
    }
}