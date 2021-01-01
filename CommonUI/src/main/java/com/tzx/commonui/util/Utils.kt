package com.tzx.commonui.util

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.util.DisplayMetrics
import android.util.TypedValue





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
public fun getWidth(context: Context):Int{
    val outMetrics = DisplayMetrics()
   (context as Activity)?.getWindowManager().getDefaultDisplay().getMetrics(outMetrics)
    val widthPixels = outMetrics.widthPixels
    val heightPixels = outMetrics.heightPixels
    return widthPixels
}
fun dp2px(context: Context, dp: Float): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp,
        context.resources.displayMetrics
    )
}