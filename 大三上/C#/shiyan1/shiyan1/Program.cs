using System;

using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace shiyan1
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Shape> sha = new List<Shape>();
            List<Rectangle> recList = new List<Rectangle>();
            List<Combination2> cbt22 = new List<Combination2>();//用来装以组合图形为元素的数组
            List<Round> rouList = new List<Round>();
            List<Rectangle> recList1 = new List<Rectangle>();
            List<Round> rouList1 = new List<Round>();
            Rectangle rec = new Rectangle(3, 4, 5, 5);
            Rectangle rec1 = new Rectangle(3, 4, 8, 9);
            Round rou = new Round(3, 5, 9);
            Round rou1 = new Round(3, 1, 6);
            recList.Add(rec);
            recList.Add(rec1);
            rouList.Add(rou);
            rouList.Add(rou1);
            rec.drawRectangle();
            rou.drawRound();
            sha.Add(rec);
            sha.Add(rec1);
            sha.Add(rou);
            sha.Add(rou1);
            Console.WriteLine(" ");

            //一个圆和一个矩形之间的组合
/*            Console.WriteLine("一个圆和一个矩形的组合：");
            Combination1 cbt1 = new Combination1(rec, rou);
            cbt1.combinate();
            cbt1.move(3, 3);
            Console.WriteLine(" ");*/

            //组合任意多个矩形和任意多个圆
/*            Combination2 cbt2 = new Combination2(recList, rouList);
            cbt2.combinate();
            cbt2.move(3, 3);
            Console.WriteLine(" ");*/

            //组合任意多个单个图形(不使用多态）
/*          Combination3 cbt3 = new Combination3(sha);
            cbt3.combinate();
            cbt3.move(3, 3);
            Console.WriteLine(" ");*/

            //组合任意多个单个图形(使用多态）
/*            Combination4 cbt4 = new Combination4(sha);
            cbt4.combinate();
            cbt4.move(3, 3);
            Console.WriteLine(" ");*/

            //组合任意多个单个图形与任意多个组合图形
            List<Shape> sha1 = new List<Shape>();
            sha1.Add(rec);
            sha1.Add(rec1);
            List<Shape> sha2 = new List<Shape>();
            sha1.Add(rec);
            sha1.Add(rec1);
            sha1.Add(rou);
            recList1.Add(rec);
            rouList1.Add(rou);
            Combination2 cn1 = new Combination2(recList, rouList);//2个矩形，2个圆
            Combination2 cn2 = new Combination2(recList1, rouList1);//1个矩形，1个圆
            cbt22.Add(cn1);
            cbt22.Add(cn2);
            //sha自带了 2个圆，2个矩形
            Combination5 cbt5 = new Combination5(sha, cbt22);
            cbt5.combinate();
            cbt5.move(3, 3);

            Console.ReadLine();
        }
    }
}
