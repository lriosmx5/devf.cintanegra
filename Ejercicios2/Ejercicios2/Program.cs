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

            Console.WriteLine(format, "NOMBRE", "PRECIO", "TIPO");
            for (int i = 0; i < milista.Count; i++)
            {
                Console.WriteLine(format, milista[i].Nombre, milista[i].Precio, milista[i].Tipo);
            }
            Console.WriteLine();
        }


        static string reverseParentheses(string s)
        {
            //var np = s.ToCharArray().Where(d => d == '(').Count();            
            if (s.Contains('('))
            {
                var pos1 = s.LastIndexOf('(');
                var pos2 = s.Substring(pos1).IndexOf(')') + 1;
                string left = s.Substring(0, pos1);
                string center = invertText(s.Substring(pos1 + 1, pos2 - 2));
                string right = s.Substring(pos1 + pos2);
                return reverseParentheses(left + center + right);
            }
            return s;
        }

        static string invertText(string s)
        {
            string sout = "";
            for (int i = s.Length - 1; i >= 0; i--)
                sout += s[i];
            return sout;
        }

        static int[] alternatingSums(int[] a)
        {
            int t1 = 0, t2 = 0;
            for (int i = 0; i < a.Length; i++)
            {
                if (i % 2 == 0) t1 = a[i]; else t2 = a[i];
            }
            return new int[] { t1, t2 };
        }

        static string[] addBorder(string[] picture)
        {
            string[] sout = new string[picture.Length + 1];
            sout[picture.Length] = sout[0] = getBorder(picture[0].Length + 2);
            for (int i = 0; i < picture.Length; i++)
                sout[i + 1] = $"*{picture[i]}*";

            return sout;

        }

        static string getBorder(int i)
        {
            string sout = "";
            while (--i == 0)
                sout += "*";
            return sout;
        }

        static bool areSimilar(int[] a, int[] b)
        {
            var l1 = a.OrderBy(d => d).ToList();
            var l2 = b.OrderBy(d => d).ToList();
            int loc = 0;
            for (int i = 0; i < l1.Count(); i++)
            {
                if (l1[i] != l2[i]) return false;
                if (a[i] != b[i]) loc++;
            }
            return loc < 2;

        }

        static bool areSimilar2(int[] a, int[] b)
        {
            string s = "";
            for (int i = 0; i < a.Length; i++)
            {
                if (a[i] != b[i]) continue;
                if (s == "") s = $"{a[i]}{b[i]}";
                else return s == $"{b[i]}{a[i]}";
            }
            return true;
        }

        static bool areSimilar3(int[] A, int[] B)
        {
            var diffs = A.Select((e, i) => i).Where(_ => A[_] != B[_]).ToArray();
            return diffs.Length == 0 || diffs.Length == 2 && A[diffs[0]] == B[diffs[1]] && B[diffs[0]] == A[diffs[1]];
        }

        int arrayChange(int[] inputArray)
        {
            /*
                [2, 3, 3, 5, 5, 5, 4, 12, 12, 10, 15] 
                [2, 3, 4, 5, 5, 5, 4, 12, 12, 10, 15] -1
                [2, 3, 4, 5, 6, 7, 4, 12, 12, 10, 15] -3
                [2, 3, 4, 5, 6, 7, 8, 12, 12, 10, 15] -4
                [2, 3, 4, 5, 6, 7, 8, 12, 13, 10, 15] -1
                [2, 3, 4, 5, 6, 7, 8, 12, 13, 14, 15] -4
                1+3+4+1+4 = 13
                */
            var r = 0;
            for (int i = 0; i < inputArray.Count() - 1; i++)
            {
                if (inputArray[i] >= inputArray[i + 1])
                {
                    r += inputArray[i] - inputArray[i + 1] + 1;
                    inputArray[i + 1] = inputArray[i] + 1;
                }
            }
            return r;
        }
        static bool palindromeRearranging(string inputString)
        {
            bool isPair = inputString.Length % 2 == 0;
            var val = inputString.ToCharArray().GroupBy(_ => _).Where(d => d.Count() % 2 > 0).Count();
            Console.WriteLine($"IsPair : {isPair}");
            Console.WriteLine($"Impair : {val}");
            return (isPair && val == 0) || (!isPair && val < 2);
        }

        static int firstDuplicate(int[] a)
        {
            int? maxIndex = null;
            //var unique = a.GroupBy(_ => _).Where(_ => _.Count() == 1).Select(_=>_.Key);
            //a = a.Where(_ => !unique.Contains(_)).ToArray();
            for (int s = 1; s < a.Length; s++)
                for (int i = 0; i + s < a.Length; i++)
                    if (a[i] == a[i + s] && (maxIndex == null || maxIndex.Value > s + i))
                        maxIndex = i + s;
            return maxIndex == null ? -1 : a[maxIndex.Value];
        }

        static int firstDuplicate2(int[] a)
        {
            bool[] sixflags = new bool[a.Max() + 1];
            for (int s = 0; s < a.Length; s++)
            {
                if (sixflags[a[s]]) return a[s];
                else sixflags[a[s]] = true;
            }
            return -1;
        }

        static int firstDuplicate3(int[] a)
        {
            HashSet<int> d = new HashSet<int>();
            for (int i = 0; i < a.Length; i++)
            {
                if (d.Contains(a[i]))
                    return a[i];
                else
                    d.Add(a[i]);
            }
            return -1;
        }


        static char firstNotRepeatingCharacter(string s)
        {
            while (s != "")
            {
                var l1 = s.Length;
                char c = s[0];
                s = s.Replace(c.ToString(), "");
                if (l1 - s.Length == 1) return c;
            }
            return '_';
        }
        static int[][] rotateImage(int[][] a)
        {
            var r = new int[a[0].Length][];

            /*
[[3,1, 2,1, 1,1],
 [3,2, 2,2, 1,2],
 [3,3, 2,3, 1,3]]
             */
            for (int i = 0; i < a.Length; i++) r[i] = new int[a.Length];


            int l = a.Length - 1;
            for (int i = 0; i < a.Length; i++)
            {
                for (int j = 0; j < a[0].Length; j++)
                {
                    r[j][l] = a[i][j];
                }
                l--;
            }
            /*
             
[[7, 4, 1],
 [8, 5, 2],
 [9, 6, 3]]
             */
            return r;
        }

        static int arrayMaximalAdjacentDifference(int[] inputArray)
        {
            //var remove = inputArray.Where(d => d > 0);
            //if (remove.Count() < 2) return 0;
            //return remove.Max() - remove.Min();
            var max = 0;
            for (int i = 0; i < inputArray.Length - 1; i++)
            {
                var r = Math.Abs(inputArray[i] - inputArray[i + 1]);
                if (max < r) max = r;
            }
            return max;
        }

        static bool isIPv4Address(string inputString)
        {
            var segment = inputString.Split('.');
            if (segment.Length != 4) return false;
            foreach (var s in segment)
                if (!int.TryParse(s, out var t) || t < 0 || t > 255) return false;
            return true;
        }

        static bool isIPv4Address2(string inputString)
        {
            // System.Net.IPAddress ip;
            //return System.Net.IPAddress.TryParse(inputString, out ip);
            //string pattern = @"(?<First>2[0-4]\d|25[0-5]|[01]?\d\d?)\.(?<Second>2[0-4]\d|25[0-5]|[01]?\d\d?)\.(?<Third>2[0-4]\d|25[0-5]|[01]?\d\d?)\.(?<Fourth>2[0-4]\d|25[0-5]|[01]?\d\d?)";
            string pattern = @"^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$";
            var check = new System.Text.RegularExpressions.Regex(pattern);
            return check.IsMatch(inputString);
        }

        static int avoidObstacles(int[] inputArray)
        {
            int r = 2;
            while (true)
            {
                if (!inputArray.Any(d => r == 0)) return r;
                r++;
            }            
        }

        int[][] boxBlur(int[][] image)
        {
            int[][] r = new int[image.Length - 2][];
            for (int x = 0; x < r.Length; x++)
            {
                r[x] = new int[image[0].Length - 2];
                for (int y = 0; y < r[x].Length; y++)
                {
                    for (int j = -1; j < 2; j++)
                    {
                        for (int k = -1; k < 2; k++)
                        {
                            r[x][y] += image[x + 1 + j][y + 1 + k];
                        }
                    }
                    r[x][y] = r[x][y] / 9;
                }
            }
            return r;
        }

        static int[][] minesweeper(bool[][] matrix)
        {
            int[][] r = new int[matrix.Length][];
            for (int x = 0; x < r.Length; x++) r[x] = new int[matrix[0].Length];

            for (int x = 0; x < r.Length; x++)
                for (int y = 0; y < r[x].Length; y++)
                    if (matrix[x][y])
                    {
                        r[x][y]++;                        
                        if (x != 0) r[x - 1][y]++;
                        if (y != 0) r[x][y - 1]++;
                        if (x < r.Length-1) r[x + 1][y] += 1;
                        if (y < r[x].Length-1) r[x][y + 1]++;
                    }
            return r;
        }

        static bool evenDigitsOnly(int n)
        {
            return !n.ToString().ToCharArray().Select(d => Convert.ToInt32(d) % 2).Where(d => d == 1).Any();
        }

        static void Main(string[] args)
        {
            //var r= reverseParentheses("Code(Cha(lle)nge)");
            //var r = firstDuplicate(new int[] { 28, 19, 13, 6, 34, 48, 50, 3, 47, 18, 15, 34, 16, 11, 13, 3, 2, 4, 46, 6, 7, 3, 18, 9, 32, 21, 3, 21, 50, 10, 45, 13, 22, 1, 27, 18, 3, 27, 30, 44, 12, 30, 40, 1, 1, 31, 6, 18, 33, 5 });
            //Console.WriteLine(r);
            //r = firstDuplicate2(new int[] { 28, 19, 13, 6, 34, 48, 50, 3, 47, 18, 15, 34, 16, 11, 13, 3, 2, 4, 46, 6, 7, 3, 18, 9, 32, 21, 3, 21, 50, 10, 45, 13, 22, 1, 27, 18, 3, 27, 30, 44, 12, 30, 40, 1, 1, 31, 6, 18, 33, 5 });
            //Console.WriteLine(r);
            //var r = firstNotRepeatingCharacter("abacabad");
            //Console.WriteLine(r);
            //var r = rotateImage(new int[][] {
            //            new int[] { 1, 2, 3 },
            //            new int[]  { 4, 5, 6 },
            //            new int[]  {7, 8, 9 } }
            //            );
            //var r = minesweeper(new bool[][]
            //{
            //    new bool[] {true, false, false, true },
            //    new bool[] {false, false, true, false },
            //    new bool[] {true, true, false, true }
            //});
            //var r = evenDigitsOnly(642386);
            var r = variableName("bbb_ass");
            Console.WriteLine(r);
            Console.ReadLine();
            //// ejercicio punto 4
            //Console.WriteLine("Lista original");
            //var lista = ObtenerProductos();
            //ImprimirListaFormateada(lista);
            //Console.WriteLine();
            //Console.WriteLine("Presione una tecla para continuar...");            
            //Console.ReadKey();

            //Console.WriteLine();
            //Console.WriteLine("Ordenamiento por precio");
            ////Metodo por precio
            // var milista = lista.OrderBy(o => o.Precio).ToList();
            // ImprimirListaFormateada(milista);
            //Console.WriteLine();
            //Console.WriteLine("Presione una tecla para continuar...");
            //Console.ReadKey(); 


            //Console.WriteLine();
            //Console.WriteLine("Ordenamiento por nombre");            
            //var listaPorNombre = OrdenarPorNombre(lista);
            //ImprimirListaFormateada(listaPorNombre);
            ////Imprimir lista
            //Console.WriteLine();
            //Console.WriteLine("Presione una tecla para terminar...");
            //Console.ReadKey();

        }

        static bool variableName(string name)
        {
            if (!Char.IsLetter(name[0])) return false;
            foreach(var c in name)
            {
                if (Char.IsLetterOrDigit(c)) continue;
                if (c == '_') continue;
                return false;
                    
            }
            return true;
            //if (String.IsNullOrEmpty(name))
            //    return false;
            //string pattern = @"[A-Z|a-z|_]\w+$";
            //var check = new System.Text.RegularExpressions.Regex(pattern);
            //var r = check.Match(name);
            //return r.Length == name.Length;
        }

        


}
}
