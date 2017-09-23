using Ejercicios2.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicios2
{
    class Program
    {
        static void Main(string[] args)
        {

            // ejercicio punto 4
            Console.WriteLine("Lista original");
            var lista = ObtenerProductos();
            ImprimirListaFormateada(lista);
            Console.WriteLine();
            Console.WriteLine("Presione una tecla para continuar...");            
            Console.ReadKey();

            Console.WriteLine();
            Console.WriteLine("Ordenamiento por precio");
            //Metodo por precio
             var milista = lista.OrderBy(o => o.Precio).ToList();
             ImprimirListaFormateada(milista);
            Console.WriteLine();
            Console.WriteLine("Presione una tecla para continuar...");
            Console.ReadKey();


            Console.WriteLine();
            Console.WriteLine("Ordenamiento por nombre");            
            var listaPorNombre = OrdenarPorNombre(lista);
            ImprimirListaFormateada(listaPorNombre);
            //Imprimir lista
            Console.WriteLine();
            Console.WriteLine("Presione una tecla para terminar...");
            Console.ReadKey();

        }
        
        static List<Models.Producto> OrdenarPorNombre(List<Models.Producto> lista)
        {
            return lista.OrderBy(d => d.Nombre).ToList();
        }

        static List<Models.Producto> ObtenerProductos()
        {
            return new List<Models.Producto>
            {
                new Models.Producto("Calculador", 15.2, "Oficina" ) ,
                new Models.Producto("Computadora", 25230.6, "Computacion") ,
                new Models.Producto("Laptop", 22323, "Computación") ,
                new Models.Producto("Chocomilk", 23.5, "Otros")                 
            };
        }


        static void ImprimirListaFormateada(List<Models.Producto> milista)
        {
            var format = "{0,-25} | {1,10} | {2,-15}";
            Console.WriteLine();
            
            Console.WriteLine(format,"NOMBRE","PRECIO","TIPO");
            for (int i = 0; i < milista.Count; i++)
            {
                Console.WriteLine(format, milista[i].Nombre, milista[i].Precio, milista[i].Tipo);                
            }
            Console.WriteLine();
        }
    }
}
