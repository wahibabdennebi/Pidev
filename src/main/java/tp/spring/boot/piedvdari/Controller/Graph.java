package tp.spring.boot.piedvdari.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tp.spring.boot.piedvdari.entities.City;
@RestController
@RequestMapping("/Graph")
public class Graph {
	@GetMapping("/data")
	 public Map<City, Integer> estimetedGraph (Model model){
		 Map<City, Integer> estgraph = new HashMap<>();
		 estgraph.put(City.Ariana,1500);
		 estgraph.put(City.Tunis,800);
		 estgraph.put(City.Ben_arous,1200);
		 estgraph.put(City.Mannouba,900);
		 estgraph.put(City.Sousse,1000);
		 estgraph.put(City.Nabeul,1000);
		 estgraph.put(City.Bizerte,1000);
		 estgraph.put(City.Jendouba,400);
		 estgraph.put(City.Siliana,400);
		 estgraph.put(City.Beja,400);
		 estgraph.put(City.Zaghouan,600);
		 estgraph.put(City.Sidi_bouzid,300);
		 estgraph.put(City.Gafsa,500);
		 estgraph.put(City.Gabes,450);
		 estgraph.put(City.Kasserine,300);
		 estgraph.put(City.Kebeli,350);
		 estgraph.put(City.Kef,450);
		 estgraph.put(City.Mahdia,700);
		 estgraph.put(City.Medennine,400);
		 estgraph.put(City.Tataouin,400);
		 estgraph.put(City.Sfax,800);
		 estgraph.put(City.Touzuer,500);
		 estgraph.put(City.Mounastir,850);
		 
		
		 return estgraph;
	 }

}
