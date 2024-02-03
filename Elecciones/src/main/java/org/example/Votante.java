package org.example;

class Votante {
    private int votosPartidoVerde;
    private int votosPartidoAnaranjado;
    private int votosPartidoRojo;
    private String genero;

    public int getVotosPartidoVerde() {
        return votosPartidoVerde;
    }

    public void setVotosPartidoVerde(int votosPartidoVerde) {
        this.votosPartidoVerde = votosPartidoVerde;
    }

    public int getVotosPartidoAnaranjado() {
        return votosPartidoAnaranjado;
    }

    public void setVotosPartidoAnaranjado(int votosPartidoAnaranjado) {
        this.votosPartidoAnaranjado = votosPartidoAnaranjado;
    }

    public int getVotosPartidoRojo() {
        return votosPartidoRojo;
    }

    public void setVotosPartidoRojo(int votosPartidoRojo) {
        this.votosPartidoRojo = votosPartidoRojo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void votar(int votoVerde, int votoAnaranjado, int votoRojo, String genero) {
        this.votosPartidoVerde += votoVerde;
        this.votosPartidoAnaranjado += votoAnaranjado;
        this.votosPartidoRojo += votoRojo;
        this.genero = genero;
    }


}
