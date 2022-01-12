/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webservice.a.praktekpws.a;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author User
 */
@Entity
@Table(name="mahasiswa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mhs {
    @Id
    private String nim;
    
    private String nama;
    
    private String prodi;
    
    private String jeniskelamin;
    
    private String kelas;
    
    public String getNama() {
        return nama;
    }
      public void setNama(String nama) {
        this.nama = nama;
    }
    public Mhs(String b){
        nama = b;
    }
}