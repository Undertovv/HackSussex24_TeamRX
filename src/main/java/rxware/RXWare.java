package rxware;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.*;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.minecraft.util.registry.Registry.*;

public class RXWare implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LogManager.getLogger("rxware");
	public static final DoritoItem rotor = new DoritoItem();
	public static final Identifier brapbrap = new Identifier("rxware:rotary");
	public static final Identifier explosion = new Identifier("rxware:tobyexplosion");
	public static SoundEvent spinSound = new SoundEvent(brapbrap);
	public static SoundEvent doritoBoom = new SoundEvent(explosion);
	public static int tickTimer = 0;
	public static final int TICK_LIMIT = 60;


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(ITEM, new Identifier("rxware", "dorito"), rotor);
		Registry.register(Registry.SOUND_EVENT, RXWare.brapbrap, spinSound);
		Registry.register(Registry.SOUND_EVENT, RXWare.explosion, doritoBoom);
		LOGGER.info("Wankel power!");

		ServerEntityEvents.ENTITY_LOAD.register(this::onEntityLoad);
		ClientTickEvents.END_WORLD_TICK.register(this::onEndWorldTick);
		//playSound();
	}
    /**
	*Increments int variable at the end of each world tick
	 * */
	//TODO: Figure this shit out later
	/*public static void playSound(World world, BlockPos blockpos) {
		if(!world.isClient) {
			world.playSound(
					null,
					blockpos,
					RXWare.spinSound, //Sound to be played
					SoundCategory.HOSTILE,
					2, //volume
					1); //pitch
		}
	}*/

	private void onEndWorldTick(ClientWorld world) {
		tickTimer++;
	}
	/**
	 * Destroys all item frame entities when player loads into world
	 */
	private void onEntityLoad(Entity entity, ServerWorld serverWorld) {
		CommandManager commands = serverWorld.getServer().getCommandManager();
		if (entity instanceof PlayerEntity player){
			commands.execute(player.getCommandSource(), "kill @e[type=item_frame]");
		}
	}
}

