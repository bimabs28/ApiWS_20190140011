/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package webservice.a.praktekpws.a;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@CrossOrigin
@RestController
@RequestMapping("/data")
public class MhsController {
    @Autowired
    private MhsRepo mahasiswa;
    
    @GetMapping("/mahasiswa")
    public List<Mhs> getAllMahasiswa(){
        return mahasiswa.findAll();
    }
    
    @GetMapping ("/mahasiswa/{nim}")
    public Mhs getMahasiswaById(@PathVariable String nim){
        return mahasiswa.findById(nim).get();
    }
    
    @PostMapping ("/mahasiswa")
    public Mhs saveMahasiswaDetails(@RequestBody Mhs o){
        return mahasiswa.save(o);
    }
    
    @PutMapping("/mahasiswa")
    public Mhs updateMahasiswa(@RequestBody Mhs o){
        return mahasiswa.save(o);
    }
    
    @DeleteMapping("/mahasiswa/{nim}")
    public ResponseEntity<HttpStatus> deleteMahasiswaById(@PathVariable String nim){
        mahasiswa.deleteById(nim);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/mahasiswa/nama")
    public ResponseEntity<List<Mhs>> getMahasiswaByNama(@RequestParam(required=false) String nama) {
        try{
            List<Mhs> t = new ArrayList<Mhs>();
            mahasiswa.findByNamaContaining(nama).forEach(t::add);
            
            if (t.isEmpty()){
                mahasiswa.findAll().forEach(t::add);
            }
            
            return new ResponseEntity<>(t, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}