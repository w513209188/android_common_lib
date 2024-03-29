package com.wb.lib_pop.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wb.lib_pop.PopupManager;
import com.wb.lib_pop.R;
import com.wb.lib_pop.code.CenterPopupView;
import com.wb.lib_pop.interfaces.OnCancelListener;
import com.wb.lib_pop.interfaces.OnConfirmListener;

/**
 * Description: 确定和取消的对话框
 */
public class ConfirmPopupView extends CenterPopupView implements View.OnClickListener {
    OnCancelListener cancelListener;
    OnConfirmListener confirmListener;
    TextView tv_title, tv_content, tv_cancel, tv_confirm;
    CharSequence title, content, hint, cancelText, confirmText;
    public boolean isHideCancel = false;

    /**
     * @param context
     * @param bindLayoutId layoutId 要求布局中必须包含的TextView以及id有：tv_title，tv_content，tv_cancel，tv_confirm
     */
    public ConfirmPopupView(@NonNull Context context, int bindLayoutId) {
        super(context);
        this.bindLayoutId = bindLayoutId;
        addInnerContent();
    }

    @Override
    protected int initLayoutResId() {
        return bindLayoutId != 0 ? bindLayoutId : R.layout._popup_center_impl_confirm;
    }

    @Override
    protected void initPopupContent() {
        super.initPopupContent();
        tv_title = findViewById(R.id.tv_title);
        tv_content = findViewById(R.id.tv_content);
        tv_cancel = findViewById(R.id.tv_cancel);
        tv_confirm = findViewById(R.id.tv_confirm);
        tv_content.setMovementMethod(LinkMovementMethod.getInstance());
        if (bindLayoutId == 0) {
            applyPrimaryColor();
        }

        tv_cancel.setOnClickListener(this);
        tv_confirm.setOnClickListener(this);

        if (!TextUtils.isEmpty(title)) {
            tv_title.setText(title);
        } else {
            tv_title.setVisibility(GONE);
        }

        if (!TextUtils.isEmpty(content)) {
            tv_content.setText(content);
        } else {
            tv_content.setVisibility(GONE);
        }
        if (!TextUtils.isEmpty(cancelText)) {
            tv_cancel.setText(cancelText);
        }
        if (!TextUtils.isEmpty(confirmText)) {
            tv_confirm.setText(confirmText);
        }
        if (isHideCancel) {
            tv_cancel.setVisibility(GONE);
            View divider = findViewById(R.id.xpopup_divider_h);
            if (divider != null) {
                divider.setVisibility(GONE);
            }
        }
        if (bindItemLayoutId == 0 && popupInfo.isDarkTheme) {
            applyDarkTheme();
        }
    }

    protected void applyPrimaryColor() {
//        tv_cancel.setTextColor(XPopup.getPrimaryColor());
        if (bindItemLayoutId == 0) {
            tv_confirm.setTextColor(PopupManager.getPrimaryColor());
        }
    }

    public TextView getTitleTextView() {
        return findViewById(R.id.tv_title);
    }

    public TextView getContentTextView() {
        return findViewById(R.id.tv_content);
    }

    public TextView getCancelTextView() {
        return findViewById(R.id.tv_cancel);
    }

    public TextView getConfirmTextView() {
        return findViewById(R.id.tv_confirm);
    }

    @Override
    protected void applyDarkTheme() {
        super.applyDarkTheme();
        tv_title.setTextColor(getResources().getColor(R.color._popup_white_color));
        tv_content.setTextColor(getResources().getColor(R.color._popup_white_color));
        tv_cancel.setTextColor(getResources().getColor(R.color._popup_white_color));
        tv_confirm.setTextColor(getResources().getColor(R.color._popup_white_color));
        findViewById(R.id.xpopup_divider).setBackgroundColor(getResources().getColor(R.color._popup_dark_color));
        findViewById(R.id.xpopup_divider_h).setBackgroundColor(getResources().getColor(R.color._popup_dark_color));
        ((ViewGroup) tv_title.getParent()).setBackgroundResource(R.drawable._popup_round3_dark_bg);
    }

    public ConfirmPopupView setListener(OnConfirmListener confirmListener, OnCancelListener cancelListener) {
        this.cancelListener = cancelListener;
        this.confirmListener = confirmListener;
        return this;
    }

    public ConfirmPopupView setTitleContent(CharSequence title, CharSequence content, CharSequence hint) {
        this.title = title;
        this.content = content;
        this.hint = hint;
        return this;
    }

    public ConfirmPopupView setCancelText(CharSequence cancelText) {
        this.cancelText = cancelText;
        return this;
    }

    public ConfirmPopupView setConfirmText(CharSequence confirmText) {
        this.confirmText = confirmText;
        return this;
    }

    @Override
    public void onClick(View v) {
        if (v == tv_cancel) {
            if (cancelListener != null) {
                cancelListener.onCancel();
            }
            dismiss();
        } else if (v == tv_confirm) {
            if (confirmListener != null) {
                confirmListener.onConfirm();
            }
            if (popupInfo.autoDismiss) {
                dismiss();
            }
        }
    }
}
