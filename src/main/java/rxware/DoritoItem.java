package rxware;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class DoritoItem extends Item {
    public DoritoItem(){
        super(DoritoItem.createSettings());
    }
    private static FabricItemSettings createSettings(){
        FabricItemSettings settings = new FabricItemSettings();
        settings.group(ItemGroup.FOOD);
        FoodComponent.Builder builder = new FoodComponent.Builder();
        builder.meat();
        builder.snack();
        builder.hunger(-10);
        builder.statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 500, 10), 1.0f);
        FoodComponent food = builder.build();
        settings.food(food);
        return settings;
    }

}
