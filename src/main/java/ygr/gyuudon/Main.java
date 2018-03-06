package ygr.gyuudon;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.plugin.PluginBase;
import ygr.gyuudon.iw.tests.TestCase01;

public class Main extends PluginBase implements Listener{
	
	public void onEnable(){
		getLogger().info("起動しました。");
        this.getServer().getPluginManager().registerEvents(this, this);
	}
	 
	 @EventHandler
	 public void onChat(PlayerChatEvent ev) {
		 if(ev.getMessage() == "test01") {
			 this.getServer().broadcastMessage("TestCase01 is Runing");
			 new TestCase01(ev.getPlayer().getLevel(),0,0,255,255);
		 }
	 }
	 
	 
	 public boolean onCommand(final CommandSender sender, Command command, String label, String[] args){
		switch(command.getName()){
			
		}
		return false;
	 }
	 
}