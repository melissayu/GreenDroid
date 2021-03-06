/*
 * Copyright (C) 2010 Cyril Mottier (http://www.cyrilmottier.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cyrilmottier.android.gdcatalog;

import greendroid.app.GDActivity;
import greendroid.widget.ActionBarItem;
import greendroid.widget.ActionBarItem.Type;
import greendroid.widget.QuickAction;
import greendroid.widget.QuickActionBar;
import greendroid.widget.QuickActionGrid;
import greendroid.widget.QuickActionWidget;
import greendroid.widget.QuickActionWidget.OnQuickActionClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class QuickActionActivity extends GDActivity {

    private QuickActionWidget mBar;
    private QuickActionWidget mGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setActionBarContentView(R.layout.quick_action);

        prepareQuickActionBar();
        //prepareQuickActionGrid();

        //addActionBarItem(Type.Edit);
    }

    public void onShowGrid(View v) {
        mGrid.show(v);
    }

    public void onShowBar(View v) {
        mBar.show(v);
    }

    @Override
    public boolean onHandleActionBarItemClick(ActionBarItem item, int position) {

        switch (position) {
            case 0:
                onShowGrid(item.getItemView());
                break;

            default:
                return super.onHandleActionBarItemClick(item, position);
        }

        return true;
    }

    private void prepareQuickActionBar() {
        mBar = new QuickActionBar(this);
        mBar.addQuickAction(new QuickAction(this, R.drawable.gd_action_bar_compose_alt, R.string.gd_compose));
        mBar.addQuickAction(new QuickAction(this, R.drawable.gd_action_bar_export_alt, R.string.gd_export));
        mBar.addQuickAction(new QuickAction(this, R.drawable.gd_action_bar_share_alt, R.string.gd_share));

        mBar.setOnQuickActionClickListener(mActionListener);
    }

    private void prepareQuickActionGrid() {
        mGrid = new QuickActionGrid(this);
        mGrid.addQuickAction(new QuickAction(this, R.drawable.gd_action_bar_compose_alt, R.string.gd_compose));
        mGrid.addQuickAction(new QuickAction(this, R.drawable.gd_action_bar_export_alt, R.string.gd_export));
        mGrid.addQuickAction(new QuickAction(this, R.drawable.gd_action_bar_share_alt, R.string.gd_share));
        mGrid.addQuickAction(new QuickAction(this, R.drawable.gd_action_bar_search_alt, R.string.gd_search));
        mGrid.addQuickAction(new QuickAction(this, R.drawable.gd_action_bar_edit_alt, R.string.gd_edit));
        mGrid.addQuickAction(new QuickAction(this, R.drawable.gd_action_bar_locate_alt, R.string.gd_locate));

        mGrid.setOnQuickActionClickListener(mActionListener);
    }

    private OnQuickActionClickListener mActionListener = new OnQuickActionClickListener() {
        public void onQuickActionClicked(QuickActionWidget widget, int position) {
            Toast.makeText(QuickActionActivity.this, "Item " + position + " clicked", Toast.LENGTH_SHORT).show();
        }
    };
}
