package com.lourenco.brandon.collectionhs.design;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EdgeEffect;

import com.lourenco.brandon.collectionhs.R;
import com.lourenco.brandon.collectionhs.hearthstone.EnumsHS;
import com.lourenco.brandon.collectionhs.hearthstone.ResourcesHS;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import at.markushi.ui.RevealColorView;

/**
 * Created by Brandon on 2016-03-19.
 */
public class AppDesign {

    public static void setEdgeGlowColor(final RecyclerView recyclerView, final int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            try {
                final Class<?> clazz = RecyclerView.class;
                for (final String name : new String[] {"ensureTopGlow", "ensureBottomGlow"}) {
                    Method method = clazz.getDeclaredMethod(name);
                    method.setAccessible(true);
                    method.invoke(recyclerView);
                }
                for (final String name : new String[] {"mTopGlow", "mBottomGlow"}) {
                    final Field field = clazz.getDeclaredField(name);
                    field.setAccessible(true);
                    final Object edge = field.get(recyclerView); // android.support.v4.widget.EdgeEffectCompat
                    final Field fEdgeEffect = edge.getClass().getDeclaredField("mEdgeEffect");
                    fEdgeEffect.setAccessible(true);
                    ((EdgeEffect) fEdgeEffect.get(edge)).setColor(color);
                }
            } catch (final Exception ignored) {}
        }
    }

    public static Point getLocationInView(View src, View target) {
        final int[] l0 = new int[2];
        src.getLocationOnScreen(l0);

        final int[] l1 = new int[2];
        target.getLocationOnScreen(l1);

        l1[0] = l1[0] - l0[0] + target.getWidth() / 2;
        l1[1] = l1[1] - l0[1] + target.getHeight() / 2;

        return new Point(l1[0], l1[1]);
    }

    public static void changeThemeColor(Context context, RevealColorView revealColorView, Point p, final int newColor, int transitionDuration_ms)
    {
        revealColorView.reveal(p.x, p.y, newColor, revealColorView.getHeight() / 2, transitionDuration_ms, null);
    }

    public static void changeFabColor(Context context, final FloatingActionButton fab, /*final int prevColor,*/ final int newColor, int transitionDuration_ms)
    {
        Integer colorFrom = fab.getBackgroundTintList().getDefaultColor();
        Integer colorTo = newColor;
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);

        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                fab.setBackgroundTintList(ColorStateList.valueOf((Integer) animator.getAnimatedValue()));
            }
        });

        colorAnimation.setDuration(transitionDuration_ms);
        colorAnimation.setStartDelay(0);
        colorAnimation.start();
    }

    /**
     * Changes a menu item icon to the desired color. Must be called after the menu layout has
     * been inflated.
     * @param item
     * @param color
     */
    public static void changeMenuItemColor(MenuItem item, int color)
    {
        Drawable drawable = item.getIcon();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable);
            DrawableCompat.setTint(drawable, color);

            DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_IN);
        }
    }

    /**
     * Changes the icon color of each item in a menu to the same color. Must be called after the
     * menu layout has been infalted.
     * @param menu
     * @param color
     */
    public static void changeAllMenuItemColors(Menu menu, int color)
    {
        for (int i = 0; i < menu.size(); i++)
        {
            changeMenuItemColor(menu.getItem(i), color);
        }

    }

    public static void setOverflowButtonColor(final Toolbar toolbar, final int color) {
        Drawable drawable = toolbar.getOverflowIcon();
        if(drawable != null) {
            drawable = DrawableCompat.wrap(drawable);
            DrawableCompat.setTint(drawable.mutate(), color);
            toolbar.setOverflowIcon(drawable);
        }
    }

    public static void setAllToolbarIconColors(final Toolbar toolbar, final int color)
    {
        setOverflowButtonColor(toolbar, color);
        changeAllMenuItemColors(toolbar.getMenu(), color);
    }
}
