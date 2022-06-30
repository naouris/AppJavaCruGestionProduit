/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entiter;

/**
 *
 * @author ACER
 */
public class Produit {
     private int id; //todo: please use a code style that arrange correctly your code, having spaces and non aligned code is not a good for checking code
    private String  produit ;
    private String Magazin;
    private int Prix;

    public Produit(){}
    public Produit(int id, String produit, String Magazin, int Prix) {
        this.id = id;
        this.produit = produit;
        this.Magazin = Magazin;
        this.Prix = Prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public String getMagazin() {
        return Magazin;
    }

    public void setMagazin(String Magazin) {
        this.Magazin = Magazin;
    }

    public int getPrix() {
        return Prix;
    }

    public void setPrix(int Prix) {
        this.Prix = Prix;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produit other = (Produit) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", produit=" + produit + ", Magazin=" + Magazin + ", Prix=" + Prix + '}' ;
    }

   
}
