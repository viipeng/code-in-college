using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Lab1_1_
{
    class Program
    {
        static void Main(string[] args)
        {
            const double Pi = 3.14159265;
            Console.Write("输入半径:");
            int r = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("输出面积："+Pi*r*r);
            Console.ReadLine();
        }
    }
}
