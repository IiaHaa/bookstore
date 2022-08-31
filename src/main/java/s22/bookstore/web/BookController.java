package s22.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {
	
	@GetMapping("/index")
	@ResponseBody
	public String welcome(@RequestParam (name="nimi", required=false, defaultValue="Stranger") String name) {
	return "Hello " + name;
	}

}