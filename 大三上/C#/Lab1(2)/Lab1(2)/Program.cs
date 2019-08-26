using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Lab1_2_
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("水仙花数：");
            int a, b, c, sum;
            for (int i = 100; i < 10000; i++)
            {
                a = i / 100;
                b = (i / 10) % 10;
                c = i % 10;
                sum=Convert.ToInt32(Math.Pow(a, 3) + Math.Pow(b, 3) + Math.Pow(c, 3));
                if (i ==sum )
                {
                    Console.Write("{0} ",+i);
                }
            }
            Console.ReadLine();
        }
    }
}
