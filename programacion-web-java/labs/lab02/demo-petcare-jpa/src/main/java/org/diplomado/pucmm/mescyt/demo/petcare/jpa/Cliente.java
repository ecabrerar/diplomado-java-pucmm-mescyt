/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.demo.petcare.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ecabrerar
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findById", query = "SELECT c FROM Cliente c WHERE c.id = :id"),
    @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cliente.findByApellido", query = "SELECT c FROM Cliente c WHERE c.apellido = :apellido"),
    @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Cliente.findByCalle", query = "SELECT c FROM Cliente c WHERE c.calle = :calle"),
    @NamedQuery(name = "Cliente.findByApartamento", query = "SELECT c FROM Cliente c WHERE c.apartamento = :apartamento"),
    @NamedQuery(name = "Cliente.findByCiudad", query = "SELECT c FROM Cliente c WHERE c.ciudad = :ciudad"),
    @NamedQuery(name = "Cliente.findByUsuario", query = "SELECT c FROM Cliente c WHERE c.usuario = :usuario"),
    @NamedQuery(name = "Cliente.findByClave", query = "SELECT c FROM Cliente c WHERE c.clave = :clave"),
    @NamedQuery(name = "Cliente.findByAccesoAdministrativo", query = "SELECT c FROM Cliente c WHERE c.accesoAdministrativo = :accesoAdministrativo"),
    @NamedQuery(name = "Cliente.findByAccesoCliente", query = "SELECT c FROM Cliente c WHERE c.accesoCliente = :accesoCliente"),
    @NamedQuery(name = "Cliente.findByAccesoDoctor", query = "SELECT c FROM Cliente c WHERE c.accesoDoctor = :accesoDoctor")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "calle")
    private String calle;
    @Column(name = "apartamento")
    private String apartamento;
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @Column(name = "acceso_administrativo")
    private boolean accesoAdministrativo;
    @Basic(optional = false)
    @Column(name = "acceso_cliente")
    private boolean accesoCliente;
    @Basic(optional = false)
    @Column(name = "acceso_doctor")
    private boolean accesoDoctor;
    @JoinColumn(name = "pais_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pais paisId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteId")
    private List<Paciente> pacienteList;

    public Cliente() {
    }

    public Cliente(Integer id) {
        this.id = id;
    }

    public Cliente(Integer id, String nombre, String apellido, String calle, String ciudad, String usuario, String clave, boolean accesoAdministrativo, boolean accesoCliente, boolean accesoDoctor) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.calle = calle;
        this.ciudad = ciudad;
        this.usuario = usuario;
        this.clave = clave;
        this.accesoAdministrativo = accesoAdministrativo;
        this.accesoCliente = accesoCliente;
        this.accesoDoctor = accesoDoctor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean getAccesoAdministrativo() {
        return accesoAdministrativo;
    }

    public void setAccesoAdministrativo(boolean accesoAdministrativo) {
        this.accesoAdministrativo = accesoAdministrativo;
    }

    public boolean getAccesoCliente() {
        return accesoCliente;
    }

    public void setAccesoCliente(boolean accesoCliente) {
        this.accesoCliente = accesoCliente;
    }

    public boolean getAccesoDoctor() {
        return accesoDoctor;
    }

    public void setAccesoDoctor(boolean accesoDoctor) {
        this.accesoDoctor = accesoDoctor;
    }

    public Pais getPaisId() {
        return paisId;
    }

    public void setPaisId(Pais paisId) {
        this.paisId = paisId;
    }

    @XmlTransient
    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.diplomado.pucmm.mescyt.demo.petcare.jpa.Cliente[ id=" + id + " ]";
    }
    
}
