package com.wb.lib_dialog.interfaces;

import android.view.View;

import com.wb.lib_dialog.core.BaseDialog;


/**
 */
public interface OnInputDialogButtonClickListener {
    
    boolean onClick(BaseDialog baseDialog, View v, String inputStr);
}
