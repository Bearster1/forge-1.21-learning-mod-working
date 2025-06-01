package net.bearster.learningmod.item.custom;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public class WarturtleArmorItem extends ArmorItem {
    public WarturtleArmorItem(Holder<ArmorMaterial> armorMaterial, Properties properties) {
        super(armorMaterial, Type.BODY, properties);
    }
}
