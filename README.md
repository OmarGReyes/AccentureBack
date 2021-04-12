# Accenture prueba backend

## Criterios de aceptación
  * Dado un cliente con la cedula de ciudadanía 12345 y con la dirección carrera 11# 14-08, cuando el
  cliente selecciona los productos a comprar con un valor mayor de 70.000 pesos entonces el sistema
  genera la factura con el iva (Impuesto del 19%) y el valor del domicilio.
  * Dado un cliente con la cedula de ciudadanía 12345 y con la dirección carrera 11# 14-08, cuando el
  cliente selecciona los productos a comprar con un valor mayor de 100.000 pesos entonces el sistema
  genera la factura con el iva (Impuesto del 19%) y el valor del domicilio en 0 pesos. 
  
## Modelos
  ### UsuarioModel
  * Atributos:
    * nombre: String.
    * cedula: String.
    * direccion: String.

  ### FacturaModel
   * Atributos:
      * usuario: UsuarioModel.
      * valor: double.
    
## Servicios
  ### UsuarioService
  * Métodos:
    * obtenerUsuarios: no recibe parámetros y obtiene todos los usuarios registrados en la BD.
    * guardarUsuario: recibe un usuario y guarda el usuario en la BD.
    * obtenerPorId: recibe un id y retorn un usuario.
    * eliminarUsuario: recibe un id y retorna true si el usuario es eliminado o falso si no se elimina ningún usuario.
  
  ### FacturaService
  * Métodos:
    * imprimirFactura: recibe cómo parámetros un usuario y un valor, retorna un String con las propiedades Cédula, Dirección, valor de compra e iva:
      * Si el valor de la compra es < $70000 se indica al cliente que no se realizan domicilios.
      * Si el valor es mayor a $70000 pero menor que $100000 se le suma a la compra el valor del domicilio.
      * Si el valor es mayor a $100000 se muestra la factura y se indica el valor de domicilio como 0.

## Controladores
  ### UsuarioController
  * url: baseUrl/usuario
  * Métodos:
      * obtenerUsuarios: 
        * Tipo de petición: GET.
        * Llama al servicio obtenerUsuario.
      * obtenerUsuarioPorId:
        * Path : /id
        * Tipo de petición: GET.
        * llama al servicio obtenerPorId
      * eliminarPorId:
        * Path: /id
        * Tipo de petición: DELETE.
        * llama al servicio eliminarUsuario.
      * guardarUsuario:
        * Tipo de petición: POST.
        * llama al servicio guardarUsuario.
      * generarFactura:
        * Path: /factura
        * Tipo de petición: POST.
        * Llama al servicio imprimirFactura. 

## Respuestas a petición realizada a: '/usuario/factura': 
  Se realizaron múltiples peticiones para hacer un test del endpoint '/usuario/factura' con la sguiente estructura en el body de la petición:
  ```javascript
{
    "usuario": {
        "nombre": "Omar",
        "direccion": "11# 14-08",
        "cedula": "12345"
    },
    "valor": "x"
}
```
Dónde x toma los siguientes valores: mayor a 100mil, menor que 100mil pero mayor que 70mil y finalmente menor que 70mil.
  
  ### Mayor a 100mill 
  ![Image of App](https://github.com/OmarGReyes/AccentureBack/blob/master/peticionesIMG/mas100.JPG)
  ### Menor a 100 y mayor a 70mil
  ![Image of App](https://github.com/OmarGReyes/AccentureBack/blob/master/peticionesIMG/menos100.JPG)
  ### Menor a 70mil
  ![Image of App](https://github.com/OmarGReyes/AccentureBack/blob/master/peticionesIMG/menos70.JPG)
  
## Prueba de BD:
Si desea realizar una prueba a la BD diríjase a: src/main/resources y realice los respectivos cambios en la url, username y password para ingresar a una BD previamente creada.

Los endpoints para conectarse a la BD fueron creados con le fin de realizar los puntos 2.2 y 2.3. Sin embargo, atendiendo al correo en el cúal se indicaba la realización de el punto 2.1
se decidió no proseguir con la realizacón de los puntos 2.2 y 2.3 pero se optó por dejar la conexión a la base de datos y los endpoints para el CRUD de Usuarios.
  
  
  
