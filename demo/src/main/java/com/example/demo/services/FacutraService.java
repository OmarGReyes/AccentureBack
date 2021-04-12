package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.models.UsuarioModel;

@Service
public class FacutraService {
	/* método imprimirFactura recibe cómo parámetros pun usuario y un valor
	 * retorna un String con las propiedades Cédula, Dirección, valor de compra e iva
	 * Si el valor de la compra es < $70000 se indica al cliente que no se realizan domicilios
	 * Si el valor es mayor a $70000 pero menor que $100000 se le suma a la compra el valor del domicilio
	 * Si el valor es mayor a $100000 se muestra la factura y se indica el valor de domicilio como 0
	 */
	public String imprimirFactura(UsuarioModel usuario, double valor){
		double domicilio = 5000;
		String factura = ("************ Super almacén Accenture ************"
				+"\nCédula: "+usuario.getCedula()
				+"\nDirección: "+usuario.getDireccion()
				+"\nValor de compra: "+valor
				+"\niva: "+valor*0.19);
		if(valor <70000){			
			return(factura
					+"\nDomicilio: no se realizan domicilios por compras inferiores a $70000"
					+"\nTotal: $"+valor);
		}else if(valor >100000){
			return(factura
					+"\nDomicilio: 0"
					+"\nTotal: $"+valor);
		}else{
			return(factura
					+"\nDomicilio: $"+domicilio
					+"\nTotal: $"+(valor+domicilio));
		}
	}
	
}
