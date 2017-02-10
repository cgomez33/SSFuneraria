/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cgomez
 */
@Entity
@Table(name = "sfm_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SfmCliente.findAll", query = "SELECT s FROM SfmCliente s")
    , @NamedQuery(name = "SfmCliente.findByIdCliente", query = "SELECT s FROM SfmCliente s WHERE s.idCliente = :idCliente")
    , @NamedQuery(name = "SfmCliente.findByCedula", query = "SELECT s FROM SfmCliente s WHERE s.cedula = :cedula")
    , @NamedQuery(name = "SfmCliente.findByNombre", query = "SELECT s FROM SfmCliente s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SfmCliente.findByApellidos", query = "SELECT s FROM SfmCliente s WHERE s.apellidos = :apellidos")
    , @NamedQuery(name = "SfmCliente.findByIdTelefono", query = "SELECT s FROM SfmCliente s WHERE s.idTelefono = :idTelefono")
    , @NamedQuery(name = "SfmCliente.findByDireccion", query = "SELECT s FROM SfmCliente s WHERE s.direccion = :direccion")})
public class SfmCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private Integer idCliente;
    @Basic(optional = false)
    @Column(name = "CEDULA")
    private String cedula;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "ID_TELEFONO")
    private int idTelefono;
    @Basic(optional = false)
    @Column(name = "DIRECCION")
    private String direccion;

    public SfmCliente() {
    }

    public SfmCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public SfmCliente(Integer idCliente, String cedula, String nombre, String apellidos, int idTelefono, String direccion) {
        this.idCliente = idCliente;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.idTelefono = idTelefono;
        this.direccion = direccion;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(int idTelefono) {
        this.idTelefono = idTelefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SfmCliente)) {
            return false;
        }
        SfmCliente other = (SfmCliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.SfmCliente[ idCliente=" + idCliente + " ]";
    }
    
}
