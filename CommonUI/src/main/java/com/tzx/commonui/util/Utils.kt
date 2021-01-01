package com.tzx.commonui.util

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

interface Callback{
    fun onConfirm(dialog: DialogInterface);
    fun onCancel(dialog: DialogInterface);
}
public fun showDialog(context:Context,title: String, msg: String,callback: Callback) {
    val normalDialog = AlertDialog.Builder(context)
    normalDialog.setTitle(title)
    normalDialog.setMessage(msg)
    normalDialog.setCancelable(false)
    normalDialog.setPositiveButton(
        "确定"
    ) { dialog, which -> callback.onConfirm(dialog) }
    // 显示
    normalDialog.show()
}
public  fun showNormalDialog(context:Context,title: String, msg: String,callback: Callback) {
    val normalDialog = AlertDialog.Builder(context)
    normalDialog.setTitle(title)
    normalDialog.setMessage(msg)
    normalDialog.setCancelable(false)
    normalDialog.setPositiveButton(
        "确定"
    ) { dialog, which -> callback.onConfirm(dialog) }
    normalDialog.setNegativeButton("取消"){ dialog, which -> callback.onCancel(dialog) }
    // 显示
    normalDialog.show()
}