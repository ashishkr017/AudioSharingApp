package tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import tunehub.entities.Song;
import tunehub.services.SongService;

@Controller
public class SongController 
{
	@Autowired
	SongService service;
	
	@PostMapping("/addSong")
	public String  addSong(@ModelAttribute Song song)
	{
		boolean songStatus=service.songExists(song.getName());
		if(songStatus==false) {
		service.addSong(song);
		System.out.println("song added successfully");
		}
		else {
			System.out.println("song already exist");
		}
		return "adminHome";
	}
	
	
	@GetMapping("/viewSongs")
	public String  viewSongs(Model model)//import only from springframework.ui.Model
	{
		List<Song> songsList =service.fetchAllSongs();
		model.addAttribute("songs",songsList);
		return "displaySongs";
	}
	
	
	@GetMapping("/playSongs")
	public String  playSongs(Model model)//import only from springframework.ui.Model
	{
		boolean premiumUser=true;
		if(premiumUser==true) {
		List<Song> songsList =service.fetchAllSongs();
		model.addAttribute("songs",songsList);
		return "displaySongs";
		}
		else {
			return "makePayment";
		}
	}
	
	
	
	
	
	
	
}
