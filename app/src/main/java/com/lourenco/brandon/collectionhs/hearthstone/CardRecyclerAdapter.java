package com.lourenco.brandon.collectionhs.hearthstone;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lourenco.brandon.collectionhs.R;
import com.lourenco.brandon.collectionhs.db.CollectionDbContract;
import com.lourenco.brandon.collectionhs.hearthstone.model.Card;
import com.lourenco.brandon.collectionhs.hearthstone.model.CardNEW;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.MaskTransformation;

public class CardRecyclerAdapter extends RecyclerView.Adapter<CardRecyclerAdapter.ViewHolder> {
    private int classId;
    private Context context;

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
    public CardRecyclerAdapter(int classId, Context context) {
        this.classId = classId;
        this.context = context;
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

        final CardNEW card = new CardNEW();

        String[] projection = {
                CollectionDbContract.Card.COLUMN_NAME_CARD_ID,
                CollectionDbContract.Card.COLUMN_NAME_CARD_SET_FOREIGN,
                CollectionDbContract.CardLocale.COLUMN_NAME_CARD_NAME,
                CollectionDbContract.Card.COLUMN_NAME_RARITY_FOREIGN
        }





        // Card Art
        MaskTransformation transform = new MaskTransformation(context, ResourcesHS.getCardTypeMask(card.getTypeEnum()));
        Picasso.with(context)
                .load(ResourcesHS.getCartArtResourceId(context, card.getCardId()))
                .placeholder(R.drawable.placeholder_missing)
                .transform(transform)
                .into(holder.imgCardArt);

        // Set Icon
        holder.imgSetIcon.setImageResource(
                ResourcesHS.getSetIcon(
                        ResourcesHS.getSetEnum(context, card.getSet())));

        // Set Icon Color
        holder.imgSetIcon.setColorFilter(
                ResourcesHS.getSetColor(context,
                        ResourcesHS.getSetEnum(context, card.getSet())));

        // Card Name & Rarity Color
        holder.txtName.setText(card.getName());
        holder.txtName.setTextColor(
                ResourcesHS.getRarityTextColor(context,
                        ResourcesHS.getRarityEnum(context, card.getRarity())));

        // Card Text
        if (card.getText() != null) {
            holder.txtText.setText(Html.fromHtml(card.getText()));
            holder.txtText.setVisibility(View.VISIBLE);
        }
        else {
            holder.txtText.setText("");
            holder.txtText.setVisibility(View.GONE);
        }

        if (card.getCost() != null) {
            holder.txtCost.setText(String.format("%d", card.getCost()));
            holder.imgCostIcon.setImageResource(R.drawable.icon_stat_mana);
        }
        else {
            holder.txtCost.setText("");
            holder.imgCostIcon.setImageResource(0);
        }

        if (card.getType().equals("MINION") || card.getType().equals("WEAPON")) {
            holder.txtAttack.setText(String.format("%d", card.getAttack()));
            //holder.imgAttackIcon.setImageResource(R.drawable.icon_attack);
            if (card.getType().equals("MINION"))
                holder.imgAttackIcon.setImageResource(R.drawable.icon_stat_attack_minion);
            else
                holder.imgAttackIcon.setImageResource(R.drawable.icon_stat_attack_weapon);
        }
        else {
            holder.txtAttack.setText("");
            holder.imgAttackIcon.setImageResource(0);
        }

        if (card.getType().equals("MINION") || card.getType().equals("HERO")) {
            holder.txtHealth.setText(String.format("%d", card.getHealth()));
            holder.imgHealthIcon.setImageResource(R.drawable.icon_stat_health_minion);
        }
        else if (card.getType().equals("WEAPON")) {
            holder.txtHealth.setText(String.format("%d", card.getDurability()));
            holder.imgHealthIcon.setImageResource(R.drawable.icon_stat_health_weapon);
        }
        else {
            holder.txtHealth.setText("");
            holder.imgHealthIcon.setImageResource(0);
        }

        // Race Stat
        if (card.getRace() != null) {
            String race = card.getRace();
            holder.txtRace.setText(race.charAt(0) + race.substring(1).toLowerCase());
            holder.imgRaceIcon.setImageResource(R.drawable.icon_stat_race);
            holder.imgRaceIcon.setColorFilter(context.getResources().getColor(R.color.statRace));
        }
        else {
            holder.txtRace.setText("");
            holder.imgRaceIcon.setImageResource(0);
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
