package ec.edu.puce.elecciones.dominio;

import java.util.ArrayList;

public class Ciudad
{
    
    private String ciudad;
    private ArrayList<VotosCiudad> votosCandidatos;
    private Provincia provincia;
    private int votosCiudad;

   
    public Ciudad(String ciudad, Provincia provincia)
    {
        this.ciudad = ciudad;
        this.votosCandidatos = new ArrayList<VotosCiudad>();
        this.votosCiudad = 0;
        this.provincia = provincia;
        
    }
    
    public void agregarCandidato(VotosCiudad voto)
    {
        this.votosCandidatos.add(voto);
    }
    
    public int getVotos(String nombre){
        
        return 0;
    }
    
    public int votosTotales(){
        votosCiudad = 0;
        
        return votosCiudad;
    }

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public int getVotosCiudad() {
		return votosCiudad;
	}

	public void setVotosCiudad(int votosCiudad) {
		this.votosCiudad = votosCiudad;
	}

	public ArrayList<VotosCiudad> getVotosCandidatos() {
		return votosCandidatos;
	}

	public void setVotosCandidatos(ArrayList<VotosCiudad> votosCandidatos) {
		this.votosCandidatos = votosCandidatos;
	}
    
	
    
}
