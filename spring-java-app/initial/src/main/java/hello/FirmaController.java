package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
public class FirmaController {
    private List<Firma> firme = new ArrayList<Firma>();

    FirmaController() {
        Firma f1 = new Firma(1, "bla");
        Firma f2 = new Firma(2, "blabla");
        Firma f3 = new Firma(3, "blablabla");

        firme.add(f1);
        firme.add(f2);
        firme.add(f3);
    }

    @RequestMapping(value="/firma", method = RequestMethod.GET)
    public List<Firma> index() {
        return this.firme;
    }



    @RequestMapping(value="/firma/{id}", method = RequestMethod.GET)
    public ResponseEntity show(@PathVariable("id") int id) {
        for(Firma f : this.firme) {
            if(f.getId() == id) {
                return new ResponseEntity<Firma>(f, new HttpHeaders(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/firma/{id}", method = RequestMethod.DELETE)
    public ResponseEntity remove(@PathVariable("id") int id) {
        for(Firma f : this.firme) {
            if(f.getId() == id) {
                this.firme.remove(f);
                return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/firma/{id}", method = RequestMethod.POST)
    public List<Firma> create(@PathVariable(value="id") int id,@RequestParam(value="nume") String nume) {
        Firma f=new Firma (id,nume);
        firme.add(f);
        return this.firme;
    }

    @RequestMapping(value="/firma/{id}", method = RequestMethod.PUT)
    public ResponseEntity putFirma(@PathVariable(value="id") int id, @RequestParam(value="nume") String nume) {
        for(Firma f: this.firme){
            if(f.getId() == id){
                f.setNume(nume);
                return new ResponseEntity<Firma>(f, new HttpHeaders(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}