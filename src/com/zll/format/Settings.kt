package com.zll.format

import com.intellij.ide.util.PropertiesComponent

class Settings {

    companion object {
        private const val KEY_COMMENT = "dart_json_format_comment"
        private const val KEY_NULL_SAFETY = "dart_json_null_safety"
    }

    var generateComments: Boolean
    var generateNullSafety: Boolean

    init {
        val propertiesComponent = PropertiesComponent.getInstance()
        generateComments = propertiesComponent.getBoolean(KEY_COMMENT, true)
        generateNullSafety = propertiesComponent.getBoolean(KEY_NULL_SAFETY, true)
    }

    fun save() = PropertiesComponent.getInstance().apply {
        setValue(KEY_COMMENT, generateComments.toString())
        setValue(KEY_NULL_SAFETY, generateNullSafety.toString())
    }
}