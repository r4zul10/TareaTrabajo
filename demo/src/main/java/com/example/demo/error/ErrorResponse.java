package com.example.demo.error;

public class ErrorResponse {
	private String mensaje;
	private String detalle;
	private int codigo;

	public ErrorResponse(String mensaje, String detalle, int codigo) {
		this.mensaje = mensaje;
		this.detalle = detalle;
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
