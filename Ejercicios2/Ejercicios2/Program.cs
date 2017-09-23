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
            Producto miprod;
            List<Producto> milista = new List<Producto>();
            Random aleatorio = new Random();


            for (int i = 0; i < 10; i++)
            {
                miprod = new Producto();

                miprod.Nombre = "Producto " + i.ToString();
                miprod.Precio = (i + 1) * aleatorio.Next(1, 100); ;
                miprod.Tipo = aleatorio.Next(1, 2).ToString();
                milista.Add(miprod);
            }

            milista = milista.OrderBy(o => o.Precio).ToList();

            Console.WriteLine("Ejercicio punto 4");
            Console.WriteLine("PRODUCTO   | PRECIO  |  TIPO");
            for (int i = 0; i < milista.Count; i++)
            {
                Console.WriteLine(milista[i].Nombre + " | " + milista[i].Precio + " | " + milista[i].Tipo);
            }

            Console.ReadLine();



        }
    }
}
