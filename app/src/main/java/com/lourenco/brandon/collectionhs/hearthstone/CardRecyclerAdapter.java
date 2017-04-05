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
import com.lourenco.brandon.collectionhs.hearthstone.model.Card;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.MaskTransformation;

public class CardRecyclerAdapter extends RecyclerView.Adapter<CardRecyclerAdapter.ViewHolder> {
    private Context context;
    //private Cursor c;
    private List<Card> classCards;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView imgCardArt;
        public ImageView imgCardFrameLegendary;
        public ImageView imgCardFrameLegendarySpell;
        public ImageView imgSetIcon;
        public TextView txtName;
        public ImageView imgRaceIcon;
        public TextView txtRace;
        public TextView txtText;
        public ImageView imgCostIcon;
        public ImageView imgTriClassBannerIcon;
        public TextView txtCost;
        public ImageView imgAttackIcon;
        public TextView txtAttack;
        public ImageView imgHealthIcon;
        public TextView txtHealth;
        public ViewHolder(View v) {
            super(v);
            this.imgCardArt = (ImageView) v.findViewById(R.id.imgCardViewArt);
            this.imgCardFrameLegendary = (ImageView) v.findViewById(R.id.imgCardViewFrameDragon);
            this.imgCardFrameLegendarySpell = (ImageView) v.findViewById(R.id.imgCardViewFrameDragonSpell);
            this.imgSetIcon = (ImageView) v.findViewById(R.id.imgCardViewSetIcon);
            this.txtName = (TextView)v.findViewById(R.id.txtCardViewName);
            this.imgRaceIcon = (ImageView) v.findViewById(R.id.imgCardViewRaceIcon);
            this.txtRace = (TextView)v.findViewById(R.id.txtCardViewRace);
            this.txtText = (TextView)v.findViewById(R.id.txtCardViewText);
            this.imgCostIcon = (ImageView) v.findViewById(R.id.imgCardViewCostIcon);
            this.imgTriClassBannerIcon = (ImageView) v.findViewById(R.id.imgCardViewTriClassBanner);
            this.txtCost = (TextView)v.findViewById(R.id.txtCardViewCost);
            this.imgAttackIcon = (ImageView) v.findViewById(R.id.imgCardViewAttackIcon);
            this.txtAttack = (TextView)v.findViewById(R.id.txtCardViewAttack);
            this.imgHealthIcon = (ImageView) v.findViewById(R.id.imgCardViewHealthIcon);
            this.txtHealth = (TextView)v.findViewById(R.id.txtCardViewHealth);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public CardRecyclerAdapter(Context context, List<Card> classCards) {
        this.context = context;
        this.classCards = classCards;
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

        Card card = classCards.get(position);

        // Card Art
        MaskTransformation transform = new MaskTransformation(context, ResourcesHS.getCardTypeMask(EnumsHS.CardType.getEnumByValue(card.getCardTypeId())));
        Picasso.with(context)
                .load(ResourcesHS.getCartArtResourceId(context, card.getCardId()))
                .fit()
                .placeholder(R.drawable.placeholder_missing)
                .transform(transform)
                .into(holder.imgCardArt);

        // Set Icon
        holder.imgSetIcon.setImageResource(
                ResourcesHS.getSetIcon(EnumsHS.CardSet.getEnumByValue(card.getCardSetId())));

        // Set Icon Color
        holder.imgSetIcon.setColorFilter(
                ResourcesHS.getSetColor(context,
                        EnumsHS.CardSet.getEnumByValue(card.getCardSetId())));

        // Card Name & Rarity Color
        holder.txtName.setText(card.getName());
        holder.txtName.setTextColor(
                ResourcesHS.getRarityTextColor(context,
                        EnumsHS.Rarity.getEnumByValue(card.getRarityId())));

        // Legendary Dragon Frame
        if (EnumsHS.Rarity.getEnumByValue(card.getRarityId()) == EnumsHS.Rarity.LEGENDARY)
        {
            if (EnumsHS.CardType.getEnumByValue(card.getCardTypeId()) == EnumsHS.CardType.MINION)
            {
                holder.imgCardFrameLegendary.setVisibility(View.VISIBLE);
                holder.imgCardFrameLegendarySpell.setVisibility(View.GONE);
            }
            else if (EnumsHS.CardType.getEnumByValue(card.getCardTypeId()) == EnumsHS.CardType.SPELL)
            {
                holder.imgCardFrameLegendary.setVisibility(View.GONE);
                holder.imgCardFrameLegendarySpell.setVisibility(View.VISIBLE);
            }
        }
        else
        {
            holder.imgCardFrameLegendary.setVisibility(View.GONE);
            holder.imgCardFrameLegendarySpell.setVisibility(View.GONE);
        }

        // Card Text
        if (card.getText() != null) {
            holder.txtText.setText(Html.fromHtml(card.getText()));
            holder.txtText.setVisibility(View.VISIBLE);
        }
        else {
            holder.txtText.setText("");
            holder.txtText.setVisibility(View.GONE);
        }

        //Mana
        if (card.getCost() != null)
        {
            holder.txtCost.setText(String.format("%d", card.getCost()));
            holder.imgCostIcon.setImageResource(R.drawable.icon_stat_mana);
        }
        else {
            holder.txtCost.setText("");
            holder.imgCostIcon.setImageResource(0);
        }

        // TriClass Banner
        if (card.getTriClassId() == EnumsHS.TriClass.GRIMY_GOONS.getValue())
        {
            holder.imgTriClassBannerIcon.setImageResource(R.drawable.icon_triclass_grimy_goons_banner);
        }
        else if (card.getTriClassId() == EnumsHS.TriClass.JADE_LOTUS.getValue())
        {
            holder.imgTriClassBannerIcon.setImageResource(R.drawable.icon_triclass_jade_lotus_banner);
        }
        else if (card.getTriClassId() == EnumsHS.TriClass.KABAL.getValue())
        {
            holder.imgTriClassBannerIcon.setImageResource(R.drawable.icon_triclass_kabal_banner);
        }
        else
        {
            holder.imgTriClassBannerIcon.setImageResource(0);
        }

        //Attack
        if (card.getCardTypeId() == EnumsHS.CardType.MINION.getValue() || card.getCardTypeId() == EnumsHS.CardType.WEAPON.getValue()) {
            holder.txtAttack.setText(String.format("%d", card.getAttack()));
            //holder.imgAttackIcon.setImageResource(R.drawable.icon_attack);
            if (card.getCardTypeId() == EnumsHS.CardType.MINION.getValue())
                holder.imgAttackIcon.setImageResource(R.drawable.icon_stat_attack_minion);
            else
                holder.imgAttackIcon.setImageResource(R.drawable.icon_stat_attack_weapon);
        }
        else {
            holder.txtAttack.setText("");
            holder.imgAttackIcon.setImageResource(0);
        }

        //Health/Durability
        if (card.getCardTypeId() == EnumsHS.CardType.MINION.getValue() || card.getCardTypeId() == EnumsHS.CardType.HERO.getValue()) {
            holder.txtHealth.setText(String.format("%d", card.getHealth()));
            holder.imgHealthIcon.setImageResource(R.drawable.icon_stat_health_minion);
        }
        else if (card.getCardTypeId() == EnumsHS.CardType.WEAPON.getValue()) {
            holder.txtHealth.setText(String.format("%d", card.getHealth()));
            holder.imgHealthIcon.setImageResource(R.drawable.icon_stat_health_weapon);
        }
        else {
            holder.txtHealth.setText("");
            holder.imgHealthIcon.setImageResource(0);
        }

        // Race Stat
        if (card.getRaceId() != EnumsHS.Race.INVALID.getValue()) {
            String raceText = ResourcesHS.getRaceText(context, EnumsHS.Race.getEnumByValue(card.getRaceId()));
            raceText = raceText.toUpperCase().charAt(0) + raceText.substring(1).toLowerCase();
            holder.txtRace.setText(raceText);
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
        return classCards.size();
    }


}

