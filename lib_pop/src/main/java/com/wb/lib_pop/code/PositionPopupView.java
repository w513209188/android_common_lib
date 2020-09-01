package com.wb.lib_pop.code;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wb.lib_pop.R;
import com.wb.lib_pop.animator.PopupAnimator;
import com.wb.lib_pop.animator.ScaleAlphaAnimator;
import com.wb.lib_pop.util.PopupUtils;
import com.wb.lib_pop.widget.PartShadowContainer;

import static com.wb.lib_pop.animator.PopupAnimation.ScaleAlphaFromCenter;

/**
 * Description: 用于自由定位的弹窗
 */
public class PositionPopupView extends BasePopupView {
    PartShadowContainer attachPopupContainer;

    public PositionPopupView(@NonNull Context context) {
        super(context);
        attachPopupContainer = findViewById(R.id.attachPopupContainer);

        View contentView = LayoutInflater.from(getContext()).inflate(initLayoutResId(), attachPopupContainer, false);
        attachPopupContainer.addView(contentView);
    }

    @Override
    protected int getPopupLayoutId() {
        return R.layout._popup_attach_popup_view;
    }

    @Override
    protected void initPopupContent() {
        super.initPopupContent();
        PopupUtils.applyPopupSize((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), new Runnable() {
            @Override
            public void run() {
                if (popupInfo.isCenterHorizontal) {
                    float left = !PopupUtils.isLayoutRtl(PositionPopupView.this) ? (PopupUtils.getWindowWidth(getContext())-attachPopupContainer.getMeasuredWidth())/2f
                    : -( PopupUtils.getWindowWidth(getContext())-attachPopupContainer.getMeasuredWidth())/2f;
                    attachPopupContainer.setTranslationX(left);
                }else {
                    attachPopupContainer.setTranslationX(popupInfo.offsetX);
                }
                attachPopupContainer.setTranslationY(popupInfo.offsetY);
            }
        });
    }

    @Override
    protected PopupAnimator getPopupAnimator() {
        return new ScaleAlphaAnimator(getPopupContentView(), ScaleAlphaFromCenter);
    }
}
