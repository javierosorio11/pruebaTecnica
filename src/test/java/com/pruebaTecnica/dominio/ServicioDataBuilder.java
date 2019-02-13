package com.pruebaTecnica.dominio;




import com.pruebaTecnica.servicio.EstacionamientoService;

public class ServicioDataBuilder {
	
		private String modelo;
		private String placa;
		private String fechaHoraIngreso;
		private String fechaHoraSalida;
		private int tipoVehiculo;
		private int estado;
		
		
		public ServicioDataBuilder() {
			modelo = "1999";
			placa = "BWA-777";
			fechaHoraIngreso ="12-02-2019 12:22:23";
			fechaHoraSalida ="13-02-2019 14:22:23";
			tipoVehiculo = 1;
			estado = 0;
		}
		
	    public ServicioDataBuilder withModelo(String modelo){
	        this.modelo = modelo;
	        return this;
	    }
	    
	    public ServicioDataBuilder withPlaca(String placa){
	        this.placa = placa;
	        return this;
	    }
	    
	    public ServicioDataBuilder withFechaHoraIngreso(String fechaHoraIngreso){
	        this.fechaHoraIngreso = fechaHoraIngreso;
	        return this;
	    }
	    
	    public ServicioDataBuilder withFechaHoraSalida(String fechaHoraSalida){
	        this.fechaHoraSalida = fechaHoraSalida;
	        return this;
	    }
	
	    public ServicioDataBuilder withPlaca(int tipoVehiculo){
	        this.tipoVehiculo = tipoVehiculo;
	        return this;
	    }
	    
	    public ServicioDataBuilder withEstado(int estado){
	        this.estado = estado;
	        return this;
	    }

	    
	    public Servicio build(){
	        return new Servicio(modelo,placa,fechaHoraIngreso,fechaHoraSalida,tipoVehiculo,estado);
	    }
	    
	    public static ServicioDataBuilder anServicio(){
	        return new ServicioDataBuilder();
	    }
}
