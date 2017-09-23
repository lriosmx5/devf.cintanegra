using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicios2.Models
{
    public class Producto
    {   
        public Producto() {}
        
        public Producto(string nombre, double precio, string tipo)
        {
            this.Nombre = nombre;
            this.Precio = precio;
            this.Tipo = tipo;
        }
        
        public string Nombre { get; set; }
        public double Precio { get; set; }
        public string Tipo { get; set; }
    }
}
