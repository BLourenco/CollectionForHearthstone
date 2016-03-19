package com.lourenco.brandon.collectionhs;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lourenco.brandon.collectionhs.models.Card;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.MaskTransformation;

public class CardRecyclerAdapter extends RecyclerView.Adapter<CardRecyclerAdapter.ViewHolder> {
    private List<Card> mDataset;
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
    public CardRecyclerAdapter(List<Card> myDataset, Context context) {
        mDataset = myDataset;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CardRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Card card = mDataset.get(position);

        MaskTransformation transform = null;
        switch (card.getTypeEnum())
        {
            case MINION:
                transform = new MaskTransformation(context, R.drawable.mask_minion);
                break;
            case SPELL:
                transform = new MaskTransformation(context, R.drawable.mask_spell);
                break;
            case WEAPON:
                transform = new MaskTransformation(context, R.drawable.mask_weapon);
                break;
            case HERO:
                transform = new MaskTransformation(context, R.drawable.mask_hero);
                break;
            case HERO_POWER:
                transform = new MaskTransformation(context, R.drawable.mask_heropower);
                break;
            case ENCHANTMENT:
                transform = new MaskTransformation(context, R.drawable.mask_enchantment);
                break;
            default:
                transform = new MaskTransformation(context, R.drawable.mask_enchantment);
        }
        Picasso.with(context)
                .load(card.getCartArtResourceId(context))
                .placeholder(R.drawable.placeholder_missing)
                .transform(transform)
                .into(holder.imgCardArt);


        int rarity = 0;
        if (card.getRarity() != null) {
            switch (card.getRarity()) {
                case "FREE":
                    rarity = context.getResources().getColor(R.color.rarityFree);
                    break;
                case "COMMON":
                    rarity = context.getResources().getColor(R.color.rarityFree);
                    break;
                case "RARE":
                    rarity = context.getResources().getColor(R.color.rarityRare);
                    break;
                case "EPIC":
                    rarity = context.getResources().getColor(R.color.rarityEpic);
                    break;
                case "LEGENDARY":
                    rarity = context.getResources().getColor(R.color.rarityLegendary);
                    break;
                default:
                    rarity = context.getResources().getColor(R.color.rarityFree);
            }
        }
        else
        {
            rarity = context.getResources().getColor(R.color.rarityFree);
        }

        switch (card.getSet())
        {
            case "HERO_SKINS":
                holder.imgSetIcon.setImageResource(R.drawable.icon_set_hero_skins);
                holder.imgSetIcon.setColorFilter(context.getResources().getColor(R.color.setHeroSkins));
                break;
            case "CHEAT":
                holder.imgSetIcon.setImageResource(R.drawable.icon_set_cheat_material);
                holder.imgSetIcon.setColorFilter(context.getResources().getColor(R.color.setCore));
                break;
            case "CORE"://TODO Create the 'Core' icon
                if (card.getType().equals("HERO"))
                    holder.imgSetIcon.setImageResource(R.drawable.icon_set_hero_skins);
                else
                    holder.imgSetIcon.setImageResource(R.drawable.icon_set_core);
                holder.imgSetIcon.setColorFilter(context.getResources().getColor(R.color.setCore));
                break;
            case "EXPERT1":
                holder.imgSetIcon.setImageResource(R.drawable.icon_set_classic);
                holder.imgSetIcon.setColorFilter(context.getResources().getColor(R.color.setClassic));
                break;
            case "PROMO":
                holder.imgSetIcon.setImageResource(R.drawable.icon_set_promo);
                holder.imgSetIcon.setColorFilter(context.getResources().getColor(R.color.setReward));
                break;
            case "REWARD"://TODO Create the "Reward" icon for Reward and Promo cards
                holder.imgSetIcon.setImageResource(R.drawable.icon_set_reward_material);
                holder.imgSetIcon.setColorFilter(context.getResources().getColor(R.color.setReward));
                break;
            case "NAXX":
                holder.imgSetIcon.setImageResource(R.drawable.icon_set_naxx);
                holder.imgSetIcon.setColorFilter(context.getResources().getColor(R.color.setNaxx));
                break;
            case "GVG":
                holder.imgSetIcon.setImageResource(R.drawable.icon_set_gvg);
                holder.imgSetIcon.setColorFilter(context.getResources().getColor(R.color.setGVG));
                break;
            case "BRM":
                holder.imgSetIcon.setImageResource(R.drawable.icon_set_brm);
                holder.imgSetIcon.setColorFilter(context.getResources().getColor(R.color.setBRM));
                break;
            case "TGT":
                holder.imgSetIcon.setImageResource(R.drawable.icon_set_tgt);
                holder.imgSetIcon.setColorFilter(context.getResources().getColor(R.color.setTGT));
                break;
            case "LOE":
                holder.imgSetIcon.setImageResource(R.drawable.icon_set_loe);
                holder.imgSetIcon.setColorFilter(context.getResources().getColor(R.color.setLOE));
                break;
            case "WOG":
                holder.imgSetIcon.setImageResource(R.drawable.icon_set_wog);
                holder.imgSetIcon.setColorFilter(context.getResources().getColor(R.color.setWOG));
                break;
            default:
                holder.imgSetIcon.setImageResource(R.drawable.ic_add_24dp);
                holder.imgSetIcon.setColorFilter(Color.BLACK);
        }

        holder.txtName.setText(card.getName());
        holder.txtName.setTextColor(rarity);

        if (card.getRace() != null) {
            String race = card.getRace();
            holder.txtRace.setText(race.charAt(0) + race.substring(1).toLowerCase());
            holder.imgRaceIcon.setImageResource(R.drawable.icon_race);
            holder.imgRaceIcon.setColorFilter(context.getResources().getColor(R.color.statRace));
        }
        else {
            holder.txtRace.setText("");
            holder.imgRaceIcon.setImageResource(0);
        }

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
            holder.imgCostIcon.setImageResource(R.drawable.icon_mana);
            holder.imgCostIcon.setColorFilter(context.getResources().getColor(R.color.statMana));
        }
        else {
            holder.txtCost.setText("");
            holder.imgCostIcon.setImageResource(0);
        }

        if (card.getType().equals("MINION") || card.getType().equals("WEAPON")) {
            holder.txtAttack.setText(String.format("%d", card.getAttack()));
            holder.imgAttackIcon.setImageResource(R.drawable.icon_attack);
            if (card.getType().equals("MINION"))
                holder.imgAttackIcon.setColorFilter(context.getResources().getColor(R.color.statMinionAttack));
            else
                holder.imgAttackIcon.setColorFilter(context.getResources().getColor(R.color.statWeaponAttack));
        }
        else {
            holder.txtAttack.setText("");
            holder.imgAttackIcon.setImageResource(0);
        }

        if (card.getType().equals("MINION") || card.getType().equals("HERO")) {
            holder.txtHealth.setText(String.format("%d", card.getHealth()));
            holder.imgHealthIcon.setImageResource(R.drawable.icon_health);
            holder.imgHealthIcon.setColorFilter(context.getResources().getColor(R.color.statMinionHealth));
        }
        else if (card.getType().equals("WEAPON")) {
            holder.txtHealth.setText(String.format("%d", card.getDurability()));
            holder.imgHealthIcon.setImageResource(R.drawable.icon_durability);
            holder.imgHealthIcon.setColorFilter(context.getResources().getColor(R.color.statWeaponDurability));
        }
        else {
            holder.txtHealth.setText("");
            holder.imgHealthIcon.setImageResource(0);
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
