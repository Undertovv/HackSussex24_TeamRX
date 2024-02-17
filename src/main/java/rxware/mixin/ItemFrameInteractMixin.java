package rxware.mixin;

import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rxware.RXWare;



@Mixin(ItemFrameEntity.class)
public class ItemFrameInteractMixin {
    Item potentialDorito;
    int spinAmount;
    @Inject(method = "setHeldItemStack(Lnet/minecraft/item/ItemStack;Z)V", at = @At("TAIL"))
    private void onSetHeldItem(ItemStack value, boolean update, CallbackInfo ci) {
        if (!Registry.ITEM.getId(RXWare.rotor).equals(Registry.ITEM.getId(value.getItem()))) {
            return;
        }
        RXWare.LOGGER.info("Added '" + value.getItem().getName() + "' entity to item frame.");
        potentialDorito = value.getItem();
    }
    @Inject(method = "setRotation(IZ)V", at = @At("TAIL"))
    private void setRotation(World world, BlockPos blockpos) {
        if (!Registry.ITEM.getId(RXWare.rotor).equals(Registry.ITEM.getId(potentialDorito))) {
            //If being spun is not dorito...
            return;
        } else if (!world.isClient) {
            world.playSound(
                    null,
                    blockpos,
                    RXWare.spinSound, //Sound to be played
                    SoundCategory.HOSTILE,
                    2, //volume
                    1); //pitch

        }

        RXWare.LOGGER.info("ITS FUCKING SPINNING!");
        // Increments int variable each time item frame dorito is rotated
        spinAmount++;
        // Resets spinAmount and tickTimer when a chosen amount of ticks has happened
        if (RXWare.tickTimer >= RXWare.TICK_LIMIT){
            RXWare.tickTimer = 0;
            spinAmount = 0;
        }
        // This will be the part that makes the malware window
        if (spinAmount >= 5){
            RXWare.LOGGER.info("Get malware idiot");
        }
    }
}
