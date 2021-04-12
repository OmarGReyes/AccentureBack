package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.FacturaModel;
import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioService;
import com.example.demo.services.FacutraService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	FacutraService facturaService;
	
	@GetMapping()
	public ArrayList<UsuarioModel> obtenerUsuarios(){
		return usuarioService.obtenerUsuarios();
	}
	
	
	
	@GetMapping(path="/{id}")
	public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
		return this.usuarioService.obtenerPorId(id);
	}
	
	
	@DeleteMapping(path = "/{id}")
	public String eliminarPorId(@PathVariable("id") Long id){
		boolean ok = this.usuarioService.eliminarUsuario(id);
		if(ok){
			return "Se eliminó el usuario con id: "+id;
		}else{
			return "No pudo eliminar el ussuario con id: "+id;
		}
	}
	
	@PostMapping
	public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
		return this.usuarioService.guardarUsuario(usuario);
	}
	
	
	
	@PostMapping("factura")
	public String generarFactura(@RequestBody FacturaModel factura){
		
		return facturaService.imprimirFactura(factura.getUsuario(), factura.getValor());
		
	}
	
	
}
