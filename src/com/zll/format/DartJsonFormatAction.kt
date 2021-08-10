package com.zll.format

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.util.PsiUtilBase
import javax.swing.JFrame

class DartJsonFormatAction : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        PsiUtilBase.getPsiFileInEditor(event.getData(PlatformDataKeys.EDITOR) as Editor,
                event.getData(PlatformDataKeys.PROJECT) as Project)
                ?.let { UiBuilder(it.project, it.virtualFile) }
                ?.let {
                    JFrame("dart json format").apply {
                        setSize(700, 520)
                        defaultCloseOperation = JFrame.DISPOSE_ON_CLOSE
                        add(it.build())
                        isVisible = true
                    }.apply { it.frame = this }
                }
    }
}