package org.marouanedbibih.soap_p.compte;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comptes")
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(name = "compteId")
    private Long id;
    private Double amount;
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Enumerated(EnumType.STRING)
    private TypeCompte type;
}
