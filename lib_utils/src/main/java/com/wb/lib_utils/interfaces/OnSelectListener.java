package com.wb.lib_utils.interfaces;

import android.view.View;

/**
 * 选择回调
 *
 * @author wb
 */
public interface OnSelectListener {

    /**
     * 点击回调
     *
     * @param v        view
     * @param position 当前位置
     * @param text     内容
     */
    void onClick(View v, int position, String text);
}
