package com.tzx.game2048.View;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.Transformation;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import android.view.contentcapture.ContentCaptureSession;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.tzx.game2048.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
// score的组合控件，待优化
public class ScoreView extends ConstraintLayout {
    private TextView score;
    public ScoreView(Context context) {
        super(context);
        init();
    }

    public ScoreView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ScoreView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    void init(){
        View view = (View) View.inflate(getContext(), R.layout.scoreitem, this);
        score=view.findViewById(R.id.textView6);
        score.setText("0");
    }
    public void setScore(String s){
        score.setText(s);
        invalidate();
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
    }

    @Override
    public void removeView(View view) {
        super.removeView(view);
    }

    @Override
    public void onViewAdded(View view) {
        super.onViewAdded(view);
    }

    @Override
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
    }

    @Override
    public void setMinWidth(int value) {
        super.setMinWidth(value);
    }

    @Override
    public void setMinHeight(int value) {
        super.setMinHeight(value);
    }

    @Override
    public int getMinWidth() {
        return super.getMinWidth();
    }

    @Override
    public void setDesignInformation(int type, Object value1, Object value2) {
        super.setDesignInformation(type, value1, value2);
    }

    @Override
    public Object getDesignInformation(int type, Object value) {
        return super.getDesignInformation(type, value);
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public int getMinHeight() {
        return super.getMinHeight();
    }

    @Override
    public void setMaxWidth(int value) {
        super.setMaxWidth(value);
    }

    @Override
    public void setMaxHeight(int value) {
        super.setMaxHeight(value);
    }

    @Override
    public int getMaxWidth() {
        return super.getMaxWidth();
    }

    @Override
    public int getMaxHeight() {
        return super.getMaxHeight();
    }

    @Override
    public void fillMetrics(Metrics metrics) {
        super.fillMetrics(metrics);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void solveLinearSystem(String reason) {
        super.solveLinearSystem(reason);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    public void setOptimizationLevel(int level) {
        super.setOptimizationLevel(level);
    }

    @Override
    public int getOptimizationLevel() {
        return super.getOptimizationLevel();
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return super.generateLayoutParams(attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return super.generateLayoutParams(p);
    }

    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return super.checkLayoutParams(p);
    }

    @Override
    public void setConstraintSet(ConstraintSet set) {
        super.setConstraintSet(set);
    }

    @Override
    public View getViewById(int id) {
        return super.getViewById(id);
    }

    @Override
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override
    public void requestLayout() {
        super.requestLayout();
    }

    @Override
    public boolean shouldDelayChildPressedState() {
        return super.shouldDelayChildPressedState();
    }

    @Override
    public int getDescendantFocusability() {
        return super.getDescendantFocusability();
    }

    @Override
    public void setDescendantFocusability(int focusability) {
        super.setDescendantFocusability(focusability);
    }

    @Override
    public void requestChildFocus(View child, View focused) {
        super.requestChildFocus(child, focused);
    }

    @Override
    public void focusableViewAvailable(View v) {
        super.focusableViewAvailable(v);
    }

    @Override
    public boolean showContextMenuForChild(View originalView) {
        return super.showContextMenuForChild(originalView);
    }

    @Override
    public boolean showContextMenuForChild(View originalView, float x, float y) {
        return super.showContextMenuForChild(originalView, x, y);
    }

    @Override
    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback) {
        return super.startActionModeForChild(originalView, callback);
    }

    @Override
    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback, int type) {
        return super.startActionModeForChild(originalView, callback, type);
    }

    @Override
    public View focusSearch(View focused, int direction) {
        return super.focusSearch(focused, direction);
    }

    @Override
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
        return super.requestChildRectangleOnScreen(child, rectangle, immediate);
    }

    @Override
    public boolean requestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        return super.requestSendAccessibilityEvent(child, event);
    }

    @Override
    public boolean onRequestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        return super.onRequestSendAccessibilityEvent(child, event);
    }

    @Override
    public void childHasTransientStateChanged(View child, boolean childHasTransientState) {
        super.childHasTransientStateChanged(child, childHasTransientState);
    }

    @Override
    public boolean hasTransientState() {
        return super.hasTransientState();
    }

    @Override
    public boolean dispatchUnhandledMove(View focused, int direction) {
        return super.dispatchUnhandledMove(focused, direction);
    }

    @Override
    public void clearChildFocus(View child) {
        super.clearChildFocus(child);
    }

    @Override
    public void clearFocus() {
        super.clearFocus();
    }

    @Override
    public View getFocusedChild() {
        return super.getFocusedChild();
    }

    @Override
    public boolean hasFocus() {
        return super.hasFocus();
    }

    @Override
    public View findFocus() {
        return super.findFocus();
    }

    @Override
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        super.addFocusables(views, direction, focusableMode);
    }

    @Override
    public void addKeyboardNavigationClusters(Collection<View> views, int direction) {
        super.addKeyboardNavigationClusters(views, direction);
    }

    @Override
    public void setTouchscreenBlocksFocus(boolean touchscreenBlocksFocus) {
        super.setTouchscreenBlocksFocus(touchscreenBlocksFocus);
    }

    @Override
    public boolean getTouchscreenBlocksFocus() {
        return super.getTouchscreenBlocksFocus();
    }

    @Override
    public void findViewsWithText(ArrayList<View> outViews, CharSequence text, int flags) {
        super.findViewsWithText(outViews, text, flags);
    }

    @Override
    public void dispatchWindowFocusChanged(boolean hasFocus) {
        super.dispatchWindowFocusChanged(hasFocus);
    }

    @Override
    public void addTouchables(ArrayList<View> views) {
        super.addTouchables(views);
    }

    @Override
    public void dispatchDisplayHint(int hint) {
        super.dispatchDisplayHint(hint);
    }

    @Override
    protected void dispatchVisibilityChanged(View changedView, int visibility) {
        super.dispatchVisibilityChanged(changedView, visibility);
    }

    @Override
    public void dispatchWindowVisibilityChanged(int visibility) {
        super.dispatchWindowVisibilityChanged(visibility);
    }

    @Override
    public void dispatchConfigurationChanged(Configuration newConfig) {
        super.dispatchConfigurationChanged(newConfig);
    }

    @Override
    public void recomputeViewAttributes(View child) {
        super.recomputeViewAttributes(child);
    }

    @Override
    public void bringChildToFront(View child) {
        super.bringChildToFront(child);
    }

    @Override
    public boolean dispatchDragEvent(DragEvent event) {
        return super.dispatchDragEvent(event);
    }

    @Override
    public void dispatchWindowSystemUiVisiblityChanged(int visible) {
        super.dispatchWindowSystemUiVisiblityChanged(visible);
    }

    @Override
    public void dispatchSystemUiVisibilityChanged(int visible) {
        super.dispatchSystemUiVisibilityChanged(visible);
    }

    @Override
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        return super.dispatchKeyEventPreIme(event);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        return super.dispatchKeyShortcutEvent(event);
    }

    @Override
    public boolean dispatchTrackballEvent(MotionEvent event) {
        return super.dispatchTrackballEvent(event);
    }

    @Override
    public boolean dispatchCapturedPointerEvent(MotionEvent event) {
        return super.dispatchCapturedPointerEvent(event);
    }

    @Override
    public void dispatchPointerCaptureChanged(boolean hasCapture) {
        super.dispatchPointerCaptureChanged(hasCapture);
    }

    @Override
    public PointerIcon onResolvePointerIcon(MotionEvent event, int pointerIndex) {
        return super.onResolvePointerIcon(event, pointerIndex);
    }

    @Override
    protected boolean dispatchHoverEvent(MotionEvent event) {
        return super.dispatchHoverEvent(event);
    }

    @Override
    public void addChildrenForAccessibility(ArrayList<View> outChildren) {
        super.addChildrenForAccessibility(outChildren);
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        return super.onInterceptHoverEvent(event);
    }

    @Override
    protected boolean dispatchGenericPointerEvent(MotionEvent event) {
        return super.dispatchGenericPointerEvent(event);
    }

    @Override
    protected boolean dispatchGenericFocusedEvent(MotionEvent event) {
        return super.dispatchGenericFocusedEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void setMotionEventSplittingEnabled(boolean split) {
        super.setMotionEventSplittingEnabled(split);
    }

    @Override
    public boolean isMotionEventSplittingEnabled() {
        return super.isMotionEventSplittingEnabled();
    }

    @Override
    public boolean isTransitionGroup() {
        return super.isTransitionGroup();
    }

    @Override
    public void setTransitionGroup(boolean isTransitionGroup) {
        super.setTransitionGroup(isTransitionGroup);
    }

    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        return super.requestFocus(direction, previouslyFocusedRect);
    }

    @Override
    protected boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        return super.onRequestFocusInDescendants(direction, previouslyFocusedRect);
    }

    @Override
    public boolean restoreDefaultFocus() {
        return super.restoreDefaultFocus();
    }

    @Override
    public void dispatchStartTemporaryDetach() {
        super.dispatchStartTemporaryDetach();
    }

    @Override
    public void dispatchFinishTemporaryDetach() {
        super.dispatchFinishTemporaryDetach();
    }

    @Override
    public void dispatchProvideStructure(ViewStructure structure) {
        super.dispatchProvideStructure(structure);
    }

    @Override
    public void dispatchProvideAutofillStructure(ViewStructure structure, int flags) {
        super.dispatchProvideAutofillStructure(structure, flags);
    }

    @Override
    public CharSequence getAccessibilityClassName() {
        return super.getAccessibilityClassName();
    }

    @Override
    public void notifySubtreeAccessibilityStateChanged(View child, View source, int changeType) {
        super.notifySubtreeAccessibilityStateChanged(child, source, changeType);
    }

    @Override
    public boolean onNestedPrePerformAccessibilityAction(View target, int action, Bundle args) {
        return super.onNestedPrePerformAccessibilityAction(target, action, args);
    }

    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        super.dispatchSaveInstanceState(container);
    }

    @Override
    protected void dispatchFreezeSelfOnly(SparseArray<Parcelable> container) {
        super.dispatchFreezeSelfOnly(container);
    }

    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        super.dispatchRestoreInstanceState(container);
    }

    @Override
    protected void dispatchThawSelfOnly(SparseArray<Parcelable> container) {
        super.dispatchThawSelfOnly(container);
    }

    @Override
    protected void setChildrenDrawingCacheEnabled(boolean enabled) {
        super.setChildrenDrawingCacheEnabled(enabled);
    }

    @Override
    public ViewGroupOverlay getOverlay() {
        return super.getOverlay();
    }

    @Override
    protected int getChildDrawingOrder(int childCount, int drawingPosition) {
        return super.getChildDrawingOrder(childCount, drawingPosition);
    }

    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        return super.drawChild(canvas, child, drawingTime);
    }

    @Override
    public boolean getClipChildren() {
        return super.getClipChildren();
    }

    @Override
    public void setClipChildren(boolean clipChildren) {
        super.setClipChildren(clipChildren);
    }

    @Override
    public void setClipToPadding(boolean clipToPadding) {
        super.setClipToPadding(clipToPadding);
    }

    @Override
    public boolean getClipToPadding() {
        return super.getClipToPadding();
    }

    @Override
    public void dispatchSetSelected(boolean selected) {
        super.dispatchSetSelected(selected);
    }

    @Override
    public void dispatchSetActivated(boolean activated) {
        super.dispatchSetActivated(activated);
    }

    @Override
    protected void dispatchSetPressed(boolean pressed) {
        super.dispatchSetPressed(pressed);
    }

    @Override
    public void dispatchDrawableHotspotChanged(float x, float y) {
        super.dispatchDrawableHotspotChanged(x, y);
    }

    @Override
    protected void setStaticTransformationsEnabled(boolean enabled) {
        super.setStaticTransformationsEnabled(enabled);
    }

    @Override
    protected boolean getChildStaticTransformation(View child, Transformation t) {
        return super.getChildStaticTransformation(child, t);
    }

    @Override
    public void addView(View child) {
        super.addView(child);
    }

    @Override
    public void addView(View child, int index) {
        super.addView(child, index);
    }

    @Override
    public void addView(View child, int width, int height) {
        super.addView(child, width, height);
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        super.addView(child, params);
    }

    @Override
    public void updateViewLayout(View view, ViewGroup.LayoutParams params) {
        super.updateViewLayout(view, params);
    }

    @Override
    public void setOnHierarchyChangeListener(OnHierarchyChangeListener listener) {
        super.setOnHierarchyChangeListener(listener);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override
    protected boolean addViewInLayout(View child, int index, ViewGroup.LayoutParams params) {
        return super.addViewInLayout(child, index, params);
    }

    @Override
    protected boolean addViewInLayout(View child, int index, ViewGroup.LayoutParams params, boolean preventRequestLayout) {
        return super.addViewInLayout(child, index, params, preventRequestLayout);
    }

    @Override
    protected void cleanupLayoutState(View child) {
        super.cleanupLayoutState(child);
    }

    @Override
    protected void attachLayoutAnimationParameters(View child, ViewGroup.LayoutParams params, int index, int count) {
        super.attachLayoutAnimationParameters(child, params, index, count);
    }

    @Override
    public void removeViewInLayout(View view) {
        super.removeViewInLayout(view);
    }

    @Override
    public void removeViewsInLayout(int start, int count) {
        super.removeViewsInLayout(start, count);
    }

    @Override
    public void removeViewAt(int index) {
        super.removeViewAt(index);
    }

    @Override
    public void removeViews(int start, int count) {
        super.removeViews(start, count);
    }

    @Override
    public void setLayoutTransition(LayoutTransition transition) {
        super.setLayoutTransition(transition);
    }

    @Override
    public LayoutTransition getLayoutTransition() {
        return super.getLayoutTransition();
    }

    @Override
    public void removeAllViews() {
        super.removeAllViews();
    }

    @Override
    public void removeAllViewsInLayout() {
        super.removeAllViewsInLayout();
    }

    @Override
    protected void removeDetachedView(View child, boolean animate) {
        super.removeDetachedView(child, animate);
    }

    @Override
    protected void attachViewToParent(View child, int index, ViewGroup.LayoutParams params) {
        super.attachViewToParent(child, index, params);
    }

    @Override
    protected void detachViewFromParent(View child) {
        super.detachViewFromParent(child);
    }

    @Override
    protected void detachViewFromParent(int index) {
        super.detachViewFromParent(index);
    }

    @Override
    protected void detachViewsFromParent(int start, int count) {
        super.detachViewsFromParent(start, count);
    }

    @Override
    protected void detachAllViewsFromParent() {
        super.detachAllViewsFromParent();
    }

    @Override
    public void onDescendantInvalidated(@NonNull View child, @NonNull View target) {
        super.onDescendantInvalidated(child, target);
    }

    @Override
    public ViewParent invalidateChildInParent(int[] location, Rect dirty) {
        return super.invalidateChildInParent(location, dirty);
    }

    @Override
    public boolean getChildVisibleRect(View child, Rect r, Point offset) {
        return super.getChildVisibleRect(child, r, offset);
    }

    @Override
    protected boolean canAnimate() {
        return super.canAnimate();
    }

    @Override
    public void startLayoutAnimation() {
        super.startLayoutAnimation();
    }

    @Override
    public void scheduleLayoutAnimation() {
        super.scheduleLayoutAnimation();
    }

    @Override
    public void setLayoutAnimation(LayoutAnimationController controller) {
        super.setLayoutAnimation(controller);
    }

    @Override
    public LayoutAnimationController getLayoutAnimation() {
        return super.getLayoutAnimation();
    }

    @Override
    public boolean isAnimationCacheEnabled() {
        return super.isAnimationCacheEnabled();
    }

    @Override
    public void setAnimationCacheEnabled(boolean enabled) {
        super.setAnimationCacheEnabled(enabled);
    }

    @Override
    public boolean isAlwaysDrawnWithCacheEnabled() {
        return super.isAlwaysDrawnWithCacheEnabled();
    }

    @Override
    public void setAlwaysDrawnWithCacheEnabled(boolean always) {
        super.setAlwaysDrawnWithCacheEnabled(always);
    }

    @Override
    protected boolean isChildrenDrawnWithCacheEnabled() {
        return super.isChildrenDrawnWithCacheEnabled();
    }

    @Override
    protected void setChildrenDrawnWithCacheEnabled(boolean enabled) {
        super.setChildrenDrawnWithCacheEnabled(enabled);
    }

    @Override
    protected boolean isChildrenDrawingOrderEnabled() {
        return super.isChildrenDrawingOrderEnabled();
    }

    @Override
    protected void setChildrenDrawingOrderEnabled(boolean enabled) {
        super.setChildrenDrawingOrderEnabled(enabled);
    }

    @Override
    public int getPersistentDrawingCache() {
        return super.getPersistentDrawingCache();
    }

    @Override
    public void setPersistentDrawingCache(int drawingCacheToKeep) {
        super.setPersistentDrawingCache(drawingCacheToKeep);
    }

    @Override
    public int getLayoutMode() {
        return super.getLayoutMode();
    }

    @Override
    public void setLayoutMode(int layoutMode) {
        super.setLayoutMode(layoutMode);
    }

    @Override
    protected void debug(int depth) {
        super.debug(depth);
    }

    @Override
    public int indexOfChild(View child) {
        return super.indexOfChild(child);
    }

    @Override
    public int getChildCount() {
        return super.getChildCount();
    }

    @Override
    public View getChildAt(int index) {
        return super.getChildAt(index);
    }

    @Override
    protected void measureChildren(int widthMeasureSpec, int heightMeasureSpec) {
        super.measureChildren(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        super.measureChild(child, parentWidthMeasureSpec, parentHeightMeasureSpec);
    }

    @Override
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        super.measureChildWithMargins(child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
    }

    @Override
    public void clearDisappearingChildren() {
        super.clearDisappearingChildren();
    }

    @Override
    public void startViewTransition(View view) {
        super.startViewTransition(view);
    }

    @Override
    public void endViewTransition(View view) {
        super.endViewTransition(view);
    }

    @Override
    public void suppressLayout(boolean suppress) {
        super.suppressLayout(suppress);
    }

    @Override
    public boolean isLayoutSuppressed() {
        return super.isLayoutSuppressed();
    }

    @Override
    public boolean gatherTransparentRegion(Region region) {
        return super.gatherTransparentRegion(region);
    }

    @Override
    public void requestTransparentRegion(View child) {
        super.requestTransparentRegion(child);
    }

    @Override
    public WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        return super.dispatchApplyWindowInsets(insets);
    }

    @Override
    public Animation.AnimationListener getLayoutAnimationListener() {
        return super.getLayoutAnimationListener();
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        return super.onCreateDrawableState(extraSpace);
    }

    @Override
    public void setAddStatesFromChildren(boolean addsStates) {
        super.setAddStatesFromChildren(addsStates);
    }

    @Override
    public boolean addStatesFromChildren() {
        return super.addStatesFromChildren();
    }

    @Override
    public void childDrawableStateChanged(View child) {
        super.childDrawableStateChanged(child);
    }

    @Override
    public void setLayoutAnimationListener(Animation.AnimationListener animationListener) {
        super.setLayoutAnimationListener(animationListener);
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return super.onStartNestedScroll(child, target, nestedScrollAxes);
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int axes) {
        super.onNestedScrollAccepted(child, target, axes);
    }

    @Override
    public void onStopNestedScroll(View child) {
        super.onStopNestedScroll(child);
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(target, dx, dy, consumed);
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return super.onNestedFling(target, velocityX, velocityY, consumed);
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return super.onNestedPreFling(target, velocityX, velocityY);
    }

    @Override
    public int getNestedScrollAxes() {
        return super.getNestedScrollAxes();
    }

    @NonNull
    @Override
    public int[] getAttributeResolutionStack(int attribute) {
        return super.getAttributeResolutionStack(attribute);
    }

    @NonNull
    @Override
    public Map<Integer, Integer> getAttributeSourceResourceMap() {
        return super.getAttributeSourceResourceMap();
    }

    @Override
    public int getExplicitStyle() {
        return super.getExplicitStyle();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int getVerticalFadingEdgeLength() {
        return super.getVerticalFadingEdgeLength();
    }

    @Override
    public void setFadingEdgeLength(int length) {
        super.setFadingEdgeLength(length);
    }

    @Override
    public int getHorizontalFadingEdgeLength() {
        return super.getHorizontalFadingEdgeLength();
    }

    @Override
    public int getVerticalScrollbarWidth() {
        return super.getVerticalScrollbarWidth();
    }

    @Override
    protected int getHorizontalScrollbarHeight() {
        return super.getHorizontalScrollbarHeight();
    }

    @Override
    public void setVerticalScrollbarThumbDrawable(@Nullable Drawable drawable) {
        super.setVerticalScrollbarThumbDrawable(drawable);
    }

    @Override
    public void setVerticalScrollbarTrackDrawable(@Nullable Drawable drawable) {
        super.setVerticalScrollbarTrackDrawable(drawable);
    }

    @Override
    public void setHorizontalScrollbarThumbDrawable(@Nullable Drawable drawable) {
        super.setHorizontalScrollbarThumbDrawable(drawable);
    }

    @Override
    public void setHorizontalScrollbarTrackDrawable(@Nullable Drawable drawable) {
        super.setHorizontalScrollbarTrackDrawable(drawable);
    }

    @Nullable
    @Override
    public Drawable getVerticalScrollbarThumbDrawable() {
        return super.getVerticalScrollbarThumbDrawable();
    }

    @Nullable
    @Override
    public Drawable getVerticalScrollbarTrackDrawable() {
        return super.getVerticalScrollbarTrackDrawable();
    }

    @Nullable
    @Override
    public Drawable getHorizontalScrollbarThumbDrawable() {
        return super.getHorizontalScrollbarThumbDrawable();
    }

    @Nullable
    @Override
    public Drawable getHorizontalScrollbarTrackDrawable() {
        return super.getHorizontalScrollbarTrackDrawable();
    }

    @Override
    public void setVerticalScrollbarPosition(int position) {
        super.setVerticalScrollbarPosition(position);
    }

    @Override
    public int getVerticalScrollbarPosition() {
        return super.getVerticalScrollbarPosition();
    }

    @Override
    public void setScrollIndicators(int indicators) {
        super.setScrollIndicators(indicators);
    }

    @Override
    public void setScrollIndicators(int indicators, int mask) {
        super.setScrollIndicators(indicators, mask);
    }

    @Override
    public int getScrollIndicators() {
        return super.getScrollIndicators();
    }

    @Override
    public void setOnScrollChangeListener(OnScrollChangeListener l) {
        super.setOnScrollChangeListener(l);
    }

    @Override
    public void setOnFocusChangeListener(OnFocusChangeListener l) {
        super.setOnFocusChangeListener(l);
    }

    @Override
    public void addOnLayoutChangeListener(OnLayoutChangeListener listener) {
        super.addOnLayoutChangeListener(listener);
    }

    @Override
    public void removeOnLayoutChangeListener(OnLayoutChangeListener listener) {
        super.removeOnLayoutChangeListener(listener);
    }

    @Override
    public void addOnAttachStateChangeListener(OnAttachStateChangeListener listener) {
        super.addOnAttachStateChangeListener(listener);
    }

    @Override
    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener listener) {
        super.removeOnAttachStateChangeListener(listener);
    }

    @Override
    public OnFocusChangeListener getOnFocusChangeListener() {
        return super.getOnFocusChangeListener();
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        super.setOnClickListener(l);
    }

    @Override
    public boolean hasOnClickListeners() {
        return super.hasOnClickListeners();
    }

    @Override
    public void setOnLongClickListener(@Nullable OnLongClickListener l) {
        super.setOnLongClickListener(l);
    }

    @Override
    public void setOnContextClickListener(@Nullable OnContextClickListener l) {
        super.setOnContextClickListener(l);
    }

    @Override
    public void setOnCreateContextMenuListener(OnCreateContextMenuListener l) {
        super.setOnCreateContextMenuListener(l);
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    public boolean callOnClick() {
        return super.callOnClick();
    }

    @Override
    public boolean performLongClick() {
        return super.performLongClick();
    }

    @Override
    public boolean performLongClick(float x, float y) {
        return super.performLongClick(x, y);
    }

    @Override
    public boolean performContextClick(float x, float y) {
        return super.performContextClick(x, y);
    }

    @Override
    public boolean performContextClick() {
        return super.performContextClick();
    }

    @Override
    public boolean showContextMenu() {
        return super.showContextMenu();
    }

    @Override
    public boolean showContextMenu(float x, float y) {
        return super.showContextMenu(x, y);
    }

    @Override
    public ActionMode startActionMode(ActionMode.Callback callback) {
        return super.startActionMode(callback);
    }

    @Override
    public ActionMode startActionMode(ActionMode.Callback callback, int type) {
        return super.startActionMode(callback, type);
    }

    @Override
    public void setOnKeyListener(OnKeyListener l) {
        super.setOnKeyListener(l);
    }

    @Override
    public void setOnTouchListener(OnTouchListener l) {
        super.setOnTouchListener(l);
    }

    @Override
    public void setOnGenericMotionListener(OnGenericMotionListener l) {
        super.setOnGenericMotionListener(l);
    }

    @Override
    public void setOnHoverListener(OnHoverListener l) {
        super.setOnHoverListener(l);
    }

    @Override
    public void setOnDragListener(OnDragListener l) {
        super.setOnDragListener(l);
    }

    @Override
    public boolean requestRectangleOnScreen(Rect rectangle) {
        return super.requestRectangleOnScreen(rectangle);
    }

    @Override
    public boolean requestRectangleOnScreen(Rect rectangle, boolean immediate) {
        return super.requestRectangleOnScreen(rectangle, immediate);
    }

    @Override
    public boolean hasFocusable() {
        return super.hasFocusable();
    }

    @Override
    public boolean hasExplicitFocusable() {
        return super.hasExplicitFocusable();
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, @Nullable Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
    }

    @Override
    public void setAccessibilityPaneTitle(@Nullable CharSequence accessibilityPaneTitle) {
        super.setAccessibilityPaneTitle(accessibilityPaneTitle);
    }

    @Nullable
    @Override
    public CharSequence getAccessibilityPaneTitle() {
        return super.getAccessibilityPaneTitle();
    }

    @Override
    public void sendAccessibilityEvent(int eventType) {
        super.sendAccessibilityEvent(eventType);
    }

    @Override
    public void announceForAccessibility(CharSequence text) {
        super.announceForAccessibility(text);
    }

    @Override
    public void sendAccessibilityEventUnchecked(AccessibilityEvent event) {
        super.sendAccessibilityEventUnchecked(event);
    }

    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return super.dispatchPopulateAccessibilityEvent(event);
    }

    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);
    }

    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
    }

    @Override
    public AccessibilityNodeInfo createAccessibilityNodeInfo() {
        return super.createAccessibilityNodeInfo();
    }

    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
    }

    @Override
    public void onProvideStructure(ViewStructure structure) {
        super.onProvideStructure(structure);
    }

    @Override
    public void onProvideAutofillStructure(ViewStructure structure, int flags) {
        super.onProvideAutofillStructure(structure, flags);
    }

    @Override
    public void onProvideVirtualStructure(ViewStructure structure) {
        super.onProvideVirtualStructure(structure);
    }

    @Override
    public void onProvideAutofillVirtualStructure(ViewStructure structure, int flags) {
        super.onProvideAutofillVirtualStructure(structure, flags);
    }

    @Override
    public void autofill(AutofillValue value) {
        super.autofill(value);
    }

    @Override
    public void autofill(@NonNull SparseArray<AutofillValue> values) {
        super.autofill(values);
    }

    @Override
    public void setAutofillId(@Nullable AutofillId id) {
        super.setAutofillId(id);
    }

    @Override
    public int getAutofillType() {
        return super.getAutofillType();
    }

    @Nullable
    @Override
    public String[] getAutofillHints() {
        return super.getAutofillHints();
    }

    @Nullable
    @Override
    public AutofillValue getAutofillValue() {
        return super.getAutofillValue();
    }

    @Override
    public int getImportantForAutofill() {
        return super.getImportantForAutofill();
    }

    @Override
    public void setImportantForAutofill(int mode) {
        super.setImportantForAutofill(mode);
    }

    @Override
    public void setContentCaptureSession(@Nullable ContentCaptureSession contentCaptureSession) {
        super.setContentCaptureSession(contentCaptureSession);
    }

    @Override
    public void addExtraDataToAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo info, @NonNull String extraDataKey, @Nullable Bundle arguments) {
        super.addExtraDataToAccessibilityNodeInfo(info, extraDataKey, arguments);
    }

    @Override
    public boolean isVisibleToUserForAutofill(int virtualId) {
        return super.isVisibleToUserForAutofill(virtualId);
    }

    @Override
    public AccessibilityDelegate getAccessibilityDelegate() {
        return super.getAccessibilityDelegate();
    }

    @Override
    public void setAccessibilityDelegate(@Nullable AccessibilityDelegate delegate) {
        super.setAccessibilityDelegate(delegate);
    }

    @Override
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        return super.getAccessibilityNodeProvider();
    }


    @Override
    public void setContentDescription(CharSequence contentDescription) {
        super.setContentDescription(contentDescription);
    }

    @Override
    public void setAccessibilityTraversalBefore(int beforeId) {
        super.setAccessibilityTraversalBefore(beforeId);
    }

    @Override
    public int getAccessibilityTraversalBefore() {
        return super.getAccessibilityTraversalBefore();
    }

    @Override
    public void setAccessibilityTraversalAfter(int afterId) {
        super.setAccessibilityTraversalAfter(afterId);
    }

    @Override
    public int getAccessibilityTraversalAfter() {
        return super.getAccessibilityTraversalAfter();
    }

    @Override
    public int getLabelFor() {
        return super.getLabelFor();
    }

    @Override
    public void setLabelFor(int id) {
        super.setLabelFor(id);
    }

    @Override
    public boolean isFocused() {
        return super.isFocused();
    }

    @Override
    public boolean isScrollContainer() {
        return super.isScrollContainer();
    }

    @Override
    public void setScrollContainer(boolean isScrollContainer) {
        super.setScrollContainer(isScrollContainer);
    }

    @Override
    public int getDrawingCacheQuality() {
        return super.getDrawingCacheQuality();
    }

    @Override
    public void setDrawingCacheQuality(int quality) {
        super.setDrawingCacheQuality(quality);
    }
}
