package com.erp.winkaws.codedb.stokrbk;

import com.erp.winkaws.codedb.stoklar.Stoklar;
import com.erp.winkaws.codedb.stokrbkmodel.StokRBKModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "StokRBK", schema = "dto", catalog = "CodeDB_1")
public class StokRBK {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "Renk")
    private Integer renk;

    @Column(name = "Beden", length = 8)
    private String beden;

    @Column(name = "Kavala", length = 8)
    private String kavala;
    
    @ManyToOne
    @JoinColumn(name = "StokId")
    private Stoklar stok;
    
    @ManyToOne
    @JoinColumn(name = "ModelId")
    private StokRBKModel model;

}
