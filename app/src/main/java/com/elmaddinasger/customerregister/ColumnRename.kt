package com.elmaddinasger.customerregister
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class ColumnRename(
    val oldName: String,
    val newName: String
)
