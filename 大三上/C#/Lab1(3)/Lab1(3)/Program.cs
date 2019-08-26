using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Lab1_3_
{
    class Program
    {
        static void SortArray(int[] myArray, bool flag)
        {
            int i, j, temp;
            for (i = 0; i < myArray.Length - 1; i++)
            {
                for (j = i + 1; j < myArray.Length; j++)
                {
                    if (flag == true && myArray[i] > myArray[j])//true代表从小到大排序
                    {
                        temp = myArray[i];
                        myArray[i] = myArray[j];
                        myArray[j] = temp;
                    }
                     else if (flag == false && myArray[i] < myArray[j])//false代表从大到小排
                    {
                         temp = myArray[i];
                         myArray[i] = myArray[j];
                         myArray[j] = temp;
                     }
                }
            }
        }
        static void Main(string[] args)
        {
            int[] arr = new int[] {20,42,3,12,54,67,25 };
            bool flag = true;
            Console.Write("原数组：");
            for (int i = 0; i < arr.Length; i++)
            {
                Console.Write(arr[i] + " ");
            }
            Console.WriteLine();
            SortArray(arr, flag);
            Console.Write("排序后的数组：");
            for (int i = 0; i < arr.Length; i++)
            {
                Console.Write(arr[i] + " ");
            }
            Console.ReadLine();
        }
    }
}
