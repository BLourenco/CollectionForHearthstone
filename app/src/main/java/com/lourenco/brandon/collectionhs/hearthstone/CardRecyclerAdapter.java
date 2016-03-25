package com.lourenco.brandon.collectionhs.hearthstone;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lourenco.brandon.collectionhs.R;
import com.lourenco.brandon.collectionhs.db.CollectionDbContract;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.MaskTransformation;

public class CardRecyclerAdapter extends RecyclerView.Adapter<CardRecyclerAdapter.ViewHolder> {
    private int classId;
    private Context context;
    private SQLiteDatabase db;
    private Cursor c;
    private EnumsHS.Locale language;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView imgCardArt;
        public ImageView imgSetIcon;
        public TextView txtName;
        public ImageView imgRaceIcon;
        public TextView txtRace;
        public TextView txtText;
        public ImageView imgCostIcon;
        public TextView txtCost;
        public ImageView imgAttackIcon;
        public TextView txtAttack;
        public ImageView imgHealthIcon;
        public TextView txtHealth;
        public ViewHolder(View v) {
            super(v);
            this.imgCardArt = (ImageView) v.findViewById(R.id.imgCardViewArt);
            this.imgSetIcon = (ImageView) v.findViewById(R.id.imgCardViewSetIcon);
            this.txtName = (TextView)v.findViewById(R.id.txtCardViewName);
            this.imgRaceIcon = (ImageView) v.findViewById(R.id.imgCardViewRaceIcon);
            this.txtRace = (TextView)v.findViewById(R.id.txtCardViewRace);
            this.txtText = (TextView)v.findViewById(R.id.txtCardViewText);
            this.imgCostIcon = (ImageView) v.findViewById(R.id.imgCardViewCostIcon);
            this.txtCost = (TextView)v.findViewById(R.id.txtCardViewCost);
            this.imgAttackIcon = (ImageView) v.findViewById(R.id.imgCardViewAttackIcon);
            this.txtAttack = (TextView)v.findViewById(R.id.txtCardViewAttack);
            this.imgHealthIcon = (ImageView) v.findViewById(R.id.imgCardViewHealthIcon);
            this.txtHealth = (TextView)v.findViewById(R.id.txtCardViewHealth);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public CardRecyclerAdapter(Integer classId, Context context, SQLiteDatabase db, EnumsHS.Locale lang) {
        this.classId = classId;
        this.context = context;
        this.db = db;
        this.language = lang;

        String rawQuery =
                "SELECT " +
                        CollectionDbContract.Card.TABLE_NAME + "." + CollectionDbContract.Card.COLUMN_NAME_CARD_ID + ", " +
                        CollectionDbContract.Card.TABLE_NAME + "." + CollectionDbContract.Card.COLUMN_NAME_CARD_TYPE_ID_FOREIGN + ", " +
                        CollectionDbContract.Card.TABLE_NAME + "." + CollectionDbContract.Card.COLUMN_NAME_COLLECTIBLE + ", " +
                        CollectionDbContract.Card.TABLE_NAME + "." + CollectionDbContract.Card.COLUMN_NAME_CARD_SET_ID_FOREIGN + ", " +
                        CollectionDbContract.CardLocale.TABLE_NAME + "." + CollectionDbContract.CardLocale.COLUMN_NAME_CARD_NAME + ", " +
                        CollectionDbContract.Card.TABLE_NAME + "." + CollectionDbContract.Card.COLUMN_NAME_RARITY_ID_FOREIGN + ", " +
                        CollectionDbContract.CardLocale.TABLE_NAME + "." + CollectionDbContract.CardLocale.COLUMN_NAME_CARD_TEXT + ", " +
                        CollectionDbContract.Card.TABLE_NAME + "." + CollectionDbContract.Card.COLUMN_NAME_COST + ", " +
                        CollectionDbContract.Card.TABLE_NAME + "." + CollectionDbContract.Card.COLUMN_NAME_ATTACK + ", " +
                        CollectionDbContract.Card.TABLE_NAME + "." + CollectionDbContract.Card.COLUMN_NAME_HEALTH + ", " +
                        CollectionDbContract.Card.TABLE_NAME + "." + CollectionDbContract.Card.COLUMN_NAME_RACE_ID_FOREIGN + " " +
                        " FROM " +
                        CollectionDbContract.Card.TABLE_NAME + " INNER JOIN " + CollectionDbContract.CardLocale.TABLE_NAME +
                        " ON " +
                        CollectionDbContract.Card.TABLE_NAME + "." + CollectionDbContract.Card.COLUMN_NAME_CARD_ID +
                        "=" +
                        CollectionDbContract.CardLocale.TABLE_NAME + "." + CollectionDbContract.CardLocale.COLUMN_NAME_CARD_ID_COMPOSITE +
                        " WHERE " +
                        CollectionDbContract.CardLocale.TABLE_NAME + "." + CollectionDbContract.CardLocale.COLUMN_NAME_LOCALE_ID_COMPOSITE + "=" + language.getValue() +
                        " AND " +
                        CollectionDbContract.Card.TABLE_NAME + "." + CollectionDbContract.Card.COLUMN_NAME_PLAYER_CLASS_ID_FOREIGN + "=" + classId +
                        " AND " +
                        CollectionDbContract.Card.TABLE_NAME + "." + CollectionDbContract.Card.COLUMN_NAME_CARD_TYPE_ID_FOREIGN + "!=" + EnumsHS.CardType.ENCHANTMENT.getValue() +
                        " AND " +
                        CollectionDbContract.Card.TABLE_NAME + "." + CollectionDbContract.Card.COLUMN_NAME_CARD_TYPE_ID_FOREIGN + "!=" + EnumsHS.CardType.HERO_POWER.getValue() +
                        " AND " +
                        CollectionDbContract.Card.TABLE_NAME + "." + CollectionDbContract.Card.COLUMN_NAME_COLLECTIBLE + "=1" +
                        " ORDER BY " +
                        CollectionDbContract.Card.TABLE_NAME + "." + CollectionDbContract.Card.COLUMN_NAME_COST + " ASC, " +
                        CollectionDbContract.CardLocale.TABLE_NAME + "." + CollectionDbContract.CardLocale.COLUMN_NAME_CARD_NAME + " ASC";

        Log.d("CRA", rawQuery);
        c = db.rawQuery(rawQuery, null);
        c.moveToFirst();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CardRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_card, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {



        c.moveToPosition(position);
        String id = c.getString(c.getColumnIndexOrThrow(CollectionDbContract.Card.COLUMN_NAME_CARD_ID));
        Integer type = c.getInt(c.getColumnIndexOrThrow(CollectionDbContract.Card.COLUMN_NAME_CARD_TYPE_ID_FOREIGN));
        Integer set = c.getInt(c.getColumnIndexOrThrow(CollectionDbContract.Card.COLUMN_NAME_CARD_SET_ID_FOREIGN));
        String name = c.getString(c.getColumnIndexOrThrow(CollectionDbContract.CardLocale.COLUMN_NAME_CARD_NAME));
        Integer rarity = c.getInt(c.getColumnIndexOrThrow(CollectionDbContract.Card.COLUMN_NAME_RARITY_ID_FOREIGN));
        String text = c.getString(c.getColumnIndexOrThrow(CollectionDbContract.CardLocale.COLUMN_NAME_CARD_TEXT));
        Integer cost = c.getInt(c.getColumnIndexOrThrow(CollectionDbContract.Card.COLUMN_NAME_COST));
        Integer attack = c.getInt(c.getColumnIndexOrThrow(CollectionDbContract.Card.COLUMN_NAME_ATTACK));
        Integer health = c.getInt(c.getColumnIndexOrThrow(CollectionDbContract.Card.COLUMN_NAME_HEALTH));
        Integer race = c.getInt(c.getColumnIndexOrThrow(CollectionDbContract.Card.COLUMN_NAME_RACE_ID_FOREIGN));







        // Card Art
        MaskTransformation transform = new MaskTransformation(context, ResourcesHS.getCardTypeMask(EnumsHS.CardType.getEnumByValue(type)));
        Picasso.with(context)
                .load(ResourcesHS.getCartArtResourceId(context, id))
                .placeholder(R.drawable.placeholder_missing)
                .transform(transform)
                .into(holder.imgCardArt);

        // Set Icon
        holder.imgSetIcon.setImageResource(
                ResourcesHS.getSetIcon(EnumsHS.CardSet.getEnumByValue(set)));

        // Set Icon Color
        holder.imgSetIcon.setColorFilter(
                ResourcesHS.getSetColor(context,
                        EnumsHS.CardSet.getEnumByValue(set)));

        // Card Name & Rarity Color
        holder.txtName.setText(name);
        holder.txtName.setTextColor(
                ResourcesHS.getRarityTextColor(context,
                        EnumsHS.Rarity.getEnumByValue(rarity)));

        // Card Text
        if (text != null) {
            holder.txtText.setText(Html.fromHtml(text));
            holder.txtText.setVisibility(View.VISIBLE);
        }
        else {
            holder.txtText.setText("");
            holder.txtText.setVisibility(View.GONE);
        }

        if (cost != null)
        {
            holder.txtCost.setText(String.format("%d", cost));
            holder.imgCostIcon.setImageResource(R.drawable.icon_stat_mana);
        }
        else {
            holder.txtCost.setText("");
            holder.imgCostIcon.setImageResource(0);
        }

        if (type == EnumsHS.CardType.MINION.getValue() || type == EnumsHS.CardType.WEAPON.getValue()) {
            holder.txtAttack.setText(String.format("%d", attack));
            //holder.imgAttackIcon.setImageResource(R.drawable.icon_attack);
            if (type == EnumsHS.CardType.MINION.getValue())
                holder.imgAttackIcon.setImageResource(R.drawable.icon_stat_attack_minion);
            else
                holder.imgAttackIcon.setImageResource(R.drawable.icon_stat_attack_weapon);
        }
        else {
            holder.txtAttack.setText("");
            holder.imgAttackIcon.setImageResource(0);
        }

        if (type == EnumsHS.CardType.MINION.getValue() || type == EnumsHS.CardType.HERO.getValue()) {
            holder.txtHealth.setText(String.format("%d", health));
            holder.imgHealthIcon.setImageResource(R.drawable.icon_stat_health_minion);
        }
        else if (type == EnumsHS.CardType.WEAPON.getValue()) {
            holder.txtHealth.setText(String.format("%d", health));
            holder.imgHealthIcon.setImageResource(R.drawable.icon_stat_health_weapon);
        }
        else {
            holder.txtHealth.setText("");
            holder.imgHealthIcon.setImageResource(0);
        }

        // Race Stat
/*        if (card.getRace() != null) {
            String race = card.getRace();
            holder.txtRace.setText(race.charAt(0) + race.substring(1).toLowerCase());
            holder.imgRaceIcon.setImageResource(R.drawable.icon_stat_race);
            holder.imgRaceIcon.setColorFilter(context.getResources().getColor(R.color.statRace));
        }
        else {
            holder.txtRace.setText("");
            holder.imgRaceIcon.setImageResource(0);
        }*/

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return c.getCount();
    }


}
