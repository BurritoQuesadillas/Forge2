package ac345.at;

import ac345.at.item.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = "at", name = "Aperture Mod", version = "1.0")
 public class ApertureMod {

    public static Item itemFats;
    public static Item cookedFats;
    public static Item siewYuk;
    public static Block blockFats;

    public static Item tntPickaxe;
    public static Item tntAxe;
    public static Item tntSword;
    public static Item tntHoe;
    public static Item tntSpade;
    public static final Item.ToolMaterial tntToolMaterial = EnumHelper.addToolMaterial("tntToolMaterial", 4, 100, 10.0F, 9.0F, 30);
    public static Item tntStick;
    public static final ItemArmor.ArmorMaterial tntArmorMaterial = EnumHelper.addArmorMaterial("tntArmorMaterial", 4000, new int[]{10,14,8,8}, 30);

    public static Item tntHelmet;
    public static Item tntChestplate;
    public static Item tntLeggings;
    public static Item tntBoots;

   @EventHandler
    public void preInit(FMLPreInitializationEvent event){
       //Item and Block Init & registering, Config Handling
       itemFats = new ItemFood(2, 0.8F, false).setUnlocalizedName("ItemFats").setTextureName("at:itemfats").setCreativeTab(tabApertureMod); //item.itemFats
       cookedFats = new ItemFood(6, 0.9F, false).setUnlocalizedName("CookedFats").setTextureName("at:cookedfats").setCreativeTab(tabApertureMod);
       siewYuk = new ItemFood(6, 0.9F, true).setUnlocalizedName("SiewYuk").setTextureName("at:siewyuk").setCreativeTab(tabApertureMod);

       blockFats = new BlockFats(Material.glass).setBlockName("BlockFats").setBlockTextureName("at:blockfats").setCreativeTab(tabApertureMod);

       tntPickaxe = new ItemTntPickaxe(tntToolMaterial).setUnlocalizedName("TntPickaxe").setTextureName("at:tntpickaxe").setCreativeTab(tabApertureMod);
       tntAxe = new ItemTntAxe(tntToolMaterial).setUnlocalizedName("TntAxe").setTextureName("at:tntaxe").setCreativeTab(tabApertureMod);
       tntSword = new ItemTntSword(tntToolMaterial).setUnlocalizedName("TntSword").setTextureName("at:tntsword").setCreativeTab(tabApertureMod);
       tntHoe = new ItemTntHoe(tntToolMaterial).setUnlocalizedName("TntHoe").setTextureName("at:tnthoe").setCreativeTab(tabApertureMod);
       tntSpade = new ItemTntSpade(tntToolMaterial).setUnlocalizedName("TntSpade").setTextureName("at:tntspade").setCreativeTab(tabApertureMod);
       tntStick = new ItemTntStick().setUnlocalizedName("TntStick").setTextureName("at:tntstick").setCreativeTab(tabApertureMod);

       tntHelmet = new ItemTntArmor(tntArmorMaterial, 0, 0).setUnlocalizedName("TntHelmet").setTextureName("at:tnthelmet").setCreativeTab(tabApertureMod);
       tntChestplate = new ItemTntArmor(tntArmorMaterial, 0, 1).setUnlocalizedName("TntChestplate").setTextureName("at:tntchestplate").setCreativeTab(tabApertureMod);
       tntLeggings = new ItemTntArmor(tntArmorMaterial, 0, 2).setUnlocalizedName("TntLeggings").setTextureName("at:tntleggings").setCreativeTab(tabApertureMod);
       tntBoots = new ItemTntArmor(tntArmorMaterial, 0, 3).setUnlocalizedName("TntBoots").setTextureName("at:tntboots").setCreativeTab(tabApertureMod);


       GameRegistry.registerItem(itemFats, itemFats.getUnlocalizedName().substring(5)); //substrings to itemFats
       GameRegistry.addSmelting(itemFats, new ItemStack(cookedFats), 3.0F);
       GameRegistry.registerItem(cookedFats, cookedFats.getUnlocalizedName().substring(5));
       GameRegistry.registerItem(siewYuk, siewYuk.getUnlocalizedName().substring(5));
       GameRegistry.registerBlock(blockFats, blockFats.getUnlocalizedName().substring(5));

       GameRegistry.registerItem(tntPickaxe, tntPickaxe.getUnlocalizedName().substring(5));
       GameRegistry.registerItem(tntAxe, tntAxe.getUnlocalizedName().substring(5));
       GameRegistry.registerItem(tntSword, tntSword.getUnlocalizedName().substring(5));
       GameRegistry.registerItem(tntHoe, tntHoe.getUnlocalizedName().substring(5));
       GameRegistry.registerItem(tntSpade, tntSpade.getUnlocalizedName().substring(5));
       GameRegistry.registerItem(tntStick, tntStick.getUnlocalizedName().substring(5));
   }

   @EventHandler
    public void init(FMLInitializationEvent event){
       //Proxy, TileEntity, entity, GUI & Packet Handling
       GameRegistry.addRecipe(new ItemStack(itemFats, 4), new Object[]{"   ", "PPP", "   ", 'P', Items.porkchop});
       GameRegistry.addRecipe(new ItemStack(itemFats, 9), new Object[]{"   ", " B ", "   ", 'B', blockFats});
       GameRegistry.addRecipe(new ItemStack(blockFats), new Object[]{"FFF", "FFF", "FFF", 'F', itemFats});
       GameRegistry.addRecipe(new ItemStack(siewYuk), new Object[]{"   ", " C ", " P ", 'C', cookedFats, 'P', Items.cooked_porkchop});

       GameRegistry.addRecipe(new ItemStack(tntPickaxe), new Object[]{"TTT", " S ", " S ", 'T', Blocks.tnt, 'S', Items.stick});
       GameRegistry.addRecipe(new ItemStack(tntAxe), new Object[]{"TT ", "TS ", " S ", 'T', Blocks.tnt, 'S', Items.stick});
       GameRegistry.addRecipe(new ItemStack(tntSpade), new Object[]{" T ", " S ", " S ", 'T', Blocks.tnt, 'S', Items.stick});
       GameRegistry.addRecipe(new ItemStack(tntSword), new Object[]{" T ", " T ", " S ", 'T', Blocks.tnt, 'S', Items.stick});
       GameRegistry.addRecipe(new ItemStack(tntHoe), new Object[]{"TT ", " S ", " S ", 'T', Blocks.tnt, 'S', Items.stick});
       GameRegistry.addRecipe(new ItemStack(tntStick, 16), new Object[]{"   ", " T ", " S ", 'T', Blocks.tnt, 'S', Items.stick});
       EntityRegistry.registerModEntity(EntityGrenade.class, "Grenade", 4, this, 80, 3, true);
   }


   @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

   }

   public static CreativeTabs tabApertureMod = new CreativeTabs("tabApertureMod"){
       @Override
       public Item getTabIconItem(){
           return new ItemStack(Blocks.tnt).getItem();
       }
   };
}
